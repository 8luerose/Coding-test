package section_07;
import java.util.*;

public class ex12 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] result, check;
	static int N, M;
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();

		check[v] = 1;
		result[v] = 0;
		Q.offer(v);
		while (Q.isEmpty() == false) {
			int current = Q.poll();
			for (int x : graph.get(current)) {
				if (check[x] == 0) {
					check[x] = 1;
					Q.offer(x);
					result[x] = result[current] + 1; 
				}	
			}
		}
	}
	public void print(ArrayList<ArrayList<Integer>> graph) {
		for (int i = 2; i <= N; i++) {
			System.out.println(i + " : " + result[i]);
		}
	}

	public static void main(String[] args) {
		ex12 T = new ex12();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		check = new int[N + 1];
		result = new int[N + 1];

		T.BFS(1);
		T.print(graph);
		sc.close();
	}
}

/** 입출력
▣ 입력
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

=> ▣ 출력
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
*/

/** 배울점
1. "result[x] = result[current] + 1"의 이해
   - 입력 예시 기준으로 전체 과정 추적:
     * 시작: result[1] = 0 (시작점)
     * Level 1: 
       - 1->3: result[3] = result[1] + 1 = 1
       - 1->4: result[4] = result[1] + 1 = 1
     * Level 2:
       - 4->5: result[5] = result[4] + 1 = 2
       - 4->6: result[6] = result[4] + 1 = 2
     * Level 3:
       - 6->2: result[2] = result[6] + 1 = 3
   - 각 단계마다 이전 정점까지의 거리에 1을 더해 현재 정점의 거리 계산

2. result 배열의 초기화와 갱신 과정
   - "result = new int[N + 1]"의 실제 동작:
     * N=6일 때 배열 상태:
       [0] = 0 (사용 안함)
       [1] = 0 (시작점)
       [2] = 0 → 3 (1->6->2: 3단계)
       [3] = 0 → 1 (1->3: 1단계)
       [4] = 0 → 1 (1->4: 1단계)
       [5] = 0 → 2 (1->4->5: 2단계)
       [6] = 0 → 2 (1->4->6: 2단계)

3. BFS while 루프 상세 분석
   while (!Q.isEmpty()) {  // 큐가 빌 때까지 반복
       int current = Q.poll();  // 현재 처리할 정점 추출
       for (int x : graph.get(current)) {  // current의 인접 정점들 순회
           if (check[x] == 0) {  // 미방문 정점이면
               check[x] = 1;      // 방문 처리
               Q.offer(x);        // 큐에 추가
               result[x] = result[current] + 1;  // 거리 갱신
           }
       }
   }

   실제 동작 예시 (1번 정점 시작):
   1) Q에 1 들어갈 때 -> check[1]=1, result[1]=0
   2) current=1, 인접정점=[3,4]
      - x=3: check[3]=1, Q=[4,3], result[3]=1
      - x=4: check[4]=1, Q=[3,4], result[4]=1
   3) current=3, 인접정점=[4]
      - x=4: 이미 방문(skip)
   4) current=4, 인접정점=[5,6]
      - x=5: check[5]=1, Q=[6,5], result[5]=2
      - x=6: check[6]=1, Q=[5,6], result[6]=2
   [이하 과정 계속...]
*/

/* 해설
[이전 해설에 추가로]
1. 레벨별 처리 특성
   - BFS는 너비 우선이므로 같은 레벨의 정점들을 모두 처리한 후 다음 레벨로 진행
   - 큐에 들어간 순서대로 처리 -> Q.offer -> Q.poll 한 것을 for_each로 처리
   - result[x] = result[current] + 1 는 현재 정점 방문 갯수 = 이전 정점 방문 갯수 + 1
   - check 배열로 중복 방문 방지하여 무한 루프 예방

2. 최단거리 보장 원리
   - 처음 방문할 때가 항상 최단거리
   - 나중에 다른 경로로 도달하더라도 이미 방문했으므로 거리 갱신 안함
   예) 4번 정점은 1->4와 1->3->4 두 경로 가능
      첫 방문(1->4)에서 result[4]=1로 설정
      이후 1->3->4 경로는 무시됨
*/