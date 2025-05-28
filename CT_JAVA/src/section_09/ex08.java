package section_09;
import java.util.*;

class EdgeB implements Comparable<EdgeB> {
	public int vertex;
	public int cost;
	EdgeB(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	@Override
	public int compareTo(EdgeB other) {
		return (this.cost - other.cost);
	}
}

public class ex08 {
	static ArrayList<ArrayList<EdgeB>> graph;
	static int[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		graph = new ArrayList<ArrayList<EdgeB>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<EdgeB>());
		}

		check = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new EdgeB(b, c));
			graph.get(b).add(new EdgeB(a, c));
		}

		int answer = 0;
		PriorityQueue<EdgeB> PQ = new PriorityQueue<EdgeB>();
		PQ.offer(new EdgeB(1, 0));
		while (!PQ.isEmpty()) {
			EdgeB tmp = PQ.poll();
			int endVertex = tmp.vertex;
			if (check[endVertex] == 0) {
				check[endVertex] = 1;
				answer += tmp.cost;
				for (EdgeB ob : graph.get(endVertex)) {
					if (check[ob.vertex] == 0) {
						PQ.offer(new EdgeB(ob.vertex, ob.cost));
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
▣ 입력예제 1
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

▣ 출력예제 1
196
*/

/** 배울점

1. 문제 유형 인식: 최소 스패닝 트리 (MST)
- 핵심 문구: "모든 도시를 서로 연결하면서 최소의 유지비용".
- 의미: 주어진 그래프의 모든 정점을 포함 + 간선 가중치 합이 최소인 트리 찾기.

2. 핵심 알고리즘: 프림 (Prim) 알고리즘
- 특징: 대표적인 MST 해결법, 탐욕적(Greedy) 방식.
- 작동 원리 요약:
    -> 1. 시작 정점 선택.
    -> 2. 현재 트리에 연결된 간선 중 (아직 트리에 없는 정점으로 향하는) 가장 가중치가 낮은 간선 선택.
    -> 3. 해당 간선과 정점을 트리에 추가.
    -> 4. 모든 정점이 트리에 포함될 때까지 위 2-3 과정 반복.

3. 주요 자료구조: 우선순위 큐 (PriorityQueue)
- 역할: "다음 연결할 가장 비용 적은 간선"을 빠르게 찾기 위함.
- 동작: 내부적으로 간선 비용(cost) 기준으로 자동 최소 힙(Min Heap) 구성.
    -> poll() 호출 시 항상 비용이 가장 적은 간선 반환.
- EdgeB 클래스의 Comparable 구현 (compareTo 메서드) -> 우선순위 큐의 정렬 기준 제공.

4. 그래프 데이터 구조: 인접 리스트 (무방향 그래프 처리)
- 표현: ArrayList<ArrayList<EdgeB>> graph;
    -> 바깥 리스트 인덱스: 정점 번호.
    -> 안쪽 리스트: 해당 정점에 연결된 간선(EdgeB 객체)들의 목록.
- 무방향 그래프의 중요성: 도시 간 도로는 양방향 통행 가능.
- 양방향 간선 정보 추가: graph.get(a).add(new EdgeB(b, c)); 와 graph.get(b).add(new EdgeB(a, c)); 모두 실행.
    -> 이유: 프림은 현재 MST에 속한 모든 정점에서 외부로 나가는 간선들을 후보로 간주.
    -> A가 MST에 있다면 A->B 간선을, B가 MST에 있다면 B->A 간선을 고려할 수 있어야 함.
    -> 양방향 정보를 모두 저장해야 어떤 정점이든 연결된 모든 간선을 올바르게 탐색 가능.

5. 중복 및 사이클 방지: check 배열
- check 배열: 정점의 MST 포함 여부 표시 (0: 미포함, 1: 포함).
- 목적: 이미 트리에 포함된 정점을 다시 선택하여 사이클이 형성되는 것을 방지 + 중복 처리 방지.
*/

/* 해설

1. 문제 접근: "가장 적은 비용으로 모든 도시 연결하기" -> 프림 알고리즘 떠올리기.
- 아이디어: 한 도시에서 시작 -> 연결된 도로 중 가장 싼 것 선택 -> 연결된 도시로 확장 -> 반복.

2. 프림 알고리즘 구현 흐름

- 단계 1: 도로 정보 표현 (EdgeB 클래스)
    -> 정보: 연결 대상 도시(vertex), 비용(cost).
    -> 기능: 비용 낮은 순 정렬 위한 Comparable 구현 (compareTo 오버라이드).

- 단계 2: 도시 연결망 구성 (인접 리스트)
    -> graph: 각 도시(인덱스) -> 연결된 도로(EdgeB) 목록.
    -> 양방향 도로 처리:
        -> A-B 도로 입력 시 -> graph의 A 목록에 (B, 비용) 추가.
        -> 또한, graph의 B 목록에 (A, 비용) 추가.
        -> 이유: 프림은 현재 연결된 도시들 '전체'에서 외부로 뻗는 최단 간선을 찾기 때문.

- 단계 3: 프림 알고리즘 실제 실행 (main 로직)
    -> 준비물:
        -> PriorityQueue<EdgeB> PQ: 건설 후보 도로 저장소 (항상 가장 싼 도로가 위에).
        -> int[] check: 도시의 건설 계획 포함 여부 (0: 미포함, 1: 포함).
        -> int answer: 총 건설 비용.
    -> 시작점:
        -> PQ에 (1번 도시, 비용 0) 가상 도로 추가 (1번부터 시작).
    -> 반복 (PQ가 빌 때까지):
        -> 1. 가장 싼 후보 도로 꺼내기: currentRoad = PQ.poll().
           -> currentRoad.vertex: 이 도로로 연결될 도시.
           -> currentRoad.cost: 이 도로의 건설 비용.
        -> 2. 새 도시인지 확인: if (check[currentRoad.vertex] == 0) -> 이 도시가 아직 계획에 없는 도시라면,
           -> 계획 포함: check[currentRoad.vertex] = 1.
           -> 비용 누적: answer += currentRoad.cost.
           -> 새 도시에서 뻗어나갈 도로 찾기:
              for (EdgeB nextRoad : graph.get(currentRoad.vertex))
              -> if (check[nextRoad.vertex] == 0) -> 연결될 도시가 아직 미포함 상태면,
                 -> PQ에 후보로 추가: PQ.offer(new EdgeB(nextRoad.vertex, nextRoad.cost)).

3. 시뮬레이션 (간단 예시)
- 초기: answer = 0, check = [0,0,...], PQ = []
- 시작: PQ.offer((정점1, 비용0)) -> PQ: [(1,0)]

- 반복 1:
  -> PQ.poll() -> (1,0) 나옴. 대상 정점: 1.
  -> check[1]이 0이므로 -> check[1]=1, answer=0.
  -> 1번 정점의 인접 간선들 (예: (2,12), (9,25)) 중,
     상대 정점이 check되지 않은 간선들을 PQ에 offer.
  -> PQ: [(2,12), (9,25)] (비용 낮은 순 정렬)

- 반복 2:
  -> PQ.poll() -> (2,12) 나옴. 대상 정점: 2.
  -> check[2]가 0이므로 -> check[2]=1, answer=12.
  -> 2번 정점의 인접 간선들 (예: (1,12), (3,10), (9,8)) 중,
     상대 정점(1은 이미 check됨)이 check되지 않은 간선 (3,10), (9,8) 등을 PQ에 offer.
  -> PQ: [(9,8), (3,10), (9,25 기존)] (새로 들어온 (9,8)이 비용 가장 낮음)

- 반복 3:
  -> PQ.poll() -> (9,8) 나옴. 대상 정점: 9.
  -> check[9]가 0이므로 -> check[9]=1, answer=12+8=20.
  -> 9번 정점의 인접 간선들 ... PQ에 offer.

- 이런 과정을 계속 반복하여 모든 연결 가능한 정점이 check될 때까지 진행. 최종 answer는 196.
*/