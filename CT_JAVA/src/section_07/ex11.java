package section_07;
import java.util.*;

public class ex11 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] check;
	static int answer = 0;
	static int a, b;
	static int N, M;

	public void DFS(int v) {
		if (v == N) answer++;
		else {
			for (int next : graph.get(v)) {
				if (check[next] == 0) {
					check[next] = 1;
					DFS(next);
					check[next] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		ex11 T = new ex11();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = (new ArrayList<ArrayList<Integer>>());
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		check = new int[N + 1];

		check[1] = 1;
		T.DFS(1);
		System.out.println(answer);
		
		sc.close();
	}
}
/** 입출력
5 9        // 정점 개수(N)=5, 간선 개수(M)=9
1 2        // 정점 1에서 정점 2로 가는 방향 간선
1 3        // 정점 1에서 정점 3으로 가는 방향 간선
1 4        // ...이하 동일한 형식으로 총 9개의 방향 간선 정보
2 1
2 3
2 5
3 4
4 2
4 5
=> 6       // 1번 정점에서 5번 정점으로 가는 모든 경로의 가짓수
*/

/** 배울점
1. ArrayList<ArrayList<Integer>> 구조와 활용
    - 인접 리스트를 구현하기 위한 2차원 동적 배열이 필요한 이유:
        * 각 정점마다 연결된 정점의 개수가 다를 수 있음
        * 배열로 구현하면 불필요한 공간이 낭비됨
        * 동적으로 간선을 추가/삭제하기 용이함
    - 구현 방법:
        * 외부 ArrayList: 각 정점을 표현 (크기가 N으로 고정)
        * 내부 ArrayList: 해당 정점과 연결된 정점들을 저장 (크기가 가변적)
        * graph.add(new ArrayList<Integer>())로 각 정점마다 빈 리스트 초기화
        * graph.get(a).add(b)로 a정점에서 b정점으로 가는 간선 추가
    - 장점:
        * 메모리 효율성: 실제 간선만큼만 저장
        * 특정 정점과 연결된 정점들을 빠르게 탐색 가능
        * 간선 추가/삭제가 O(1) 시간에 가능

2. DFS의 백트래킹 구현
    - check 배열의 역할:
        * 현재 탐색 중인 경로에서 방문한 정점을 표시
        * 무한 루프 방지
        * 이미 방문한 정점을 재방문하지 않도록 함
    - ** check[next] = 1, DFS(next), check[next] = 0 패턴의 중요성: **
        * check[next] = 1: 현재 경로에서 정점 방문 표시
        * DFS(next): 다음 정점으로 탐색 진행
        * check[next] = 0: 해당 경로 탐색이 끝나면 방문 표시 제거
        * 이를 통해 다른 경로에서도 해당 정점을 방문할 수 있음
    - 백트래킹이 없다면:
        * 한번 방문한 정점은 다시 방문할 수 없게 됨
        * 가능한 모든 경로를 탐색할 수 없음
        * 잘못된 결과가 도출됨

3. static 변수의 전략적 활용
    - static으로 선언해야 하는 변수들:
        * graph: 그래프 구조를 전역적으로 참조
        * check: 방문 여부를 모든 재귀호출에서 공유
        * answer: 경로 수를 누적하여 저장
        * N, M: 종료조건과 반복 범위로 사용
    - static 사용의 장점:
        * 메모리 효율성: 객체마다 변수를 생성하지 않음
        * 접근 용이성: 어떤 메서드에서도 접근 가능
        * 코드 간결성: 매개변수로 전달할 필요 없음
    - static 사용시 주의할 점:
        * 멀티스레드 환경에서 동기화 문제 발생 가능
        * 객체지향의 캡슐화를 해칠 수 있음

4. 그래프 탐색을 위한 반복문 최적화
    - for (int next : graph.get(v)) 형태의 향상된 for문 사용:
        * 더 간결하고 가독성 높은 코드
        * 인덱스 관리가 필요 없음
        * 실수를 줄일 수 있음
*/

/* 해설
1. 문제 접근 방법
    - 입력된 방향 그래프에서 1번 정점에서 N번 정점까지 가는 모든 경로의 수를 구하는 문제
    - DFS와 백트래킹을 이용하여 모든 가능한 경로를 탐색
    - 인접 리스트로 그래프를 구현하여 메모리 효율성 확보
    - 방문했던 정점도 다른 경로에서 재방문 가능해야 함 (백트래킹 필요)

2. 구현 과정 상세 설명
    (1) 그래프 초기화 단계
        - N개의 정점에 대해 각각 빈 ArrayList 생성
            * for (int i = 0; i < N; i++) graph.add(new ArrayList<Integer>());
        - M개의 간선 정보를 입력받아 저장
            * graph.get(a).add(b) 형태로 방향 간선 정보 저장
            * a번 정점에서 b번 정점으로 가는 단방향 간선
    
    (2) DFS 구현
        - 종료조건: if (v == N) answer++;
            * 현재 정점이 목표 정점(N)이면 하나의 경로를 찾은 것
            * answer를 증가시키고 해당 경로의 탐색 종료
        - 다음 정점 탐색: for (int next : graph.get(v))
            * 현재 정점 v와 연결된 모든 정점을 확인
            * 각 정점에 대해 방문 가능한지 체크
        - 방문 처리와 백트래킹
            * check[next] = 1로 방문 표시
            * DFS(next)로 다음 정점 탐색
            * check[next] = 0으로 방문 표시 해제

3. 실제 예시 (N=5일 때 경로 탐색 과정)
    시작: 정점 1에서 시작
    경로1: 1 -> 2 -> 3 -> 4 -> 5
        - 1방문 -> 2방문 -> 3방문 -> 4방문 -> 5도달 (answer++)
    경로2: 1 -> 2 -> 5
        - 1방문 -> 2방문 -> 5도달 (answer++)
    경로3: 1 -> 3 -> 4 -> 2 -> 5
        - 1방문 -> 3방문 -> 4방문 -> 2방문 -> 5도달 (answer++)
    경로4: 1 -> 3 -> 4 -> 5
        - 1방문 -> 3방문 -> 4방문 -> 5도달 (answer++)
    경로5: 1 -> 4 -> 2 -> 5
        - 1방문 -> 4방문 -> 2방문 -> 5도달 (answer++)
    경로6: 1 -> 4 -> 5
        - 1방문 -> 4방문 -> 5도달 (answer++)
    
    각 경로 탐색 후에는 check 배열을 초기화하여 다른 경로에서도 해당 정점들을 사용할 수 있게 함
    최종적으로 6개의 서로 다른 경로를 발견하여 answer = 6 출력
*/