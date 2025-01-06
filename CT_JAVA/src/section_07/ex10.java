package section_07;
import java.util.*;

public class ex10 {
    static int n, m;
    static int answer = 0;
    static int[][] graph;
    static int[] check;

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int i = 0; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        ex10 T = new ex10();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        check[1] = 1;
        T.DFS(1);
        System.out.println(answer);
        sc.close();
    }
}

/** 입출력
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
=>
6

[입력값 설명]
- 첫 줄: 정점의 수(n=5)와 간선의 수(m=9)
- 다음 9개의 줄: 각 간선의 방향 정보
  1 2 (1→2 방향)
  1 3 (1→3 방향)
  1 4 (1→4 방향)
  2 1 (2→1 방향)
  2 3 (2→3 방향)
  2 5 (2→5 방향)
  3 4 (3→4 방향)
  4 2 (4→2 방향)
  4 5 (4→5 방향)

[출력값 설명]
- 1번에서 5번 정점으로 가는 모든 경로의 수: 6
- 가능한 모든 경로:
  1. 1→2→3→4→5
  2. 1→2→5
  3. 1→3→4→2→5
  4. 1→3→4→5
  5. 1→4→2→5
  6. 1→4→5
*/

/** 배울점
1. 인접행렬을 이용한 그래프 구현
    - graph[n+1][n+1] 크기로 선언하는 이유:
      * 정점이 1번부터 시작하므로 0번 인덱스는 사용하지 않음
      * graph[1][2]=1은 1번에서 2번으로 가는 경로가 있다는 의미
      * 예: graph[1][4]=1은 1→4 경로 존재
    
2. ** 백트래킹의 동작 원리 **
    - check 배열의 역할:
      * check[i]=1: i번 정점을 현재 경로에서 방문했다는 표시
      * check[i]=0: i번 정점을 현재 경로에서 방문하지 않았다는 표시
    - 사이클 방지: 이미 방문한 정점은 재방문하지 않음
    - 예: 2번에서 1번으로 가면(2→1) 다시 2번으로 돌아오는 무한루프 방지
    
    - 백트래킹 과정 예시(1→4→2→5 경로):
      (1) 시작: check[1]=1 표시
      (2) 4로 이동: check[4]=1 표시
      (3) 2로 이동: check[2]=1 표시
      (4) 5에 도착: answer 증가
      (5) 복귀: check[2]=0으로 복구
      (6) 다른 경로 탐색을 위해 준비
      * 이렇게 하지 않으면 1→4→2→5 경로 탐색 후 2가 방문된 상태로 남아
        1→4→5 같은 다른 경로를 찾지 못함

3. DFS 재귀호출의 특징
    - void DFS(int v)에서 v는 현재 정점
    - if (v == n): 목적지(5번 정점)에 도달했는지 체크
    - for문: 현재 정점에서 갈 수 있는 모든 정점 확인
    - graph[v][i] == 1: v에서 i로 가는 경로가 있는지 확인
    - check[i] == 0: i번 정점을 아직 방문하지 않았는지 확인
*/

/* 해설
1. 전체적인 구현 과정
    (1) 그래프 초기화
        - n+1 크기의 2차원 배열 생성
        - 입력받은 간선 정보로 graph[a][b]=1 설정
        
    (2) DFS 탐색 시작
        - check[1]=1로 시작점 방문 표시
        - DFS(1) 호출로 탐색 시작

2. 백트래킹 동작 방식
    [Step 1] DFS(1) 시작
    - check[1]=1 
    - for문으로 i=4를 만남
    - graph[1][4]=1이고 check[4]=0이므로 DFS(4) 호출

    [Step 2] DFS(4) 진행
    - check[4]=1
    - for문으로 i=2를 만남
    - graph[4][2]=1이고 check[2]=0이므로 DFS(2) 호출

    [Step 3] DFS(2) 진행
    - check[2]=1
    - for문 진행:
      * i=1: graph[2][1]=1이지만 check[1]=1이라서 못감
      * i=3: graph[2][3]=1이고 check[3]=0이므로 DFS(3) 호출
      * i=5: graph[2][5]=1이고 check[5]=0이지만 아직 i=3 처리 중

    [Step 4] DFS(3) 진행
    - check[3]=1
    - for문 진행:
      * i=4: graph[3][4]=1이지만 check[4]=1이라서 못감
      * 더 이상 갈 수 있는 경로가 없음
    - DFS(3) 종료되며 check[3]=0으로 복구

    [Step 5] DFS(2)로 돌아옴
    - 이제 i=5로 진행:
      * graph[2][5]=1이고 check[5]=0이므로 DFS(5) 호출
      * 목적지 도달하여 answer 증가

    이처럼 DFS(3)에서:
    - 3→4로만 갈 수 있는데
    - 이미 check[4]=1인 상태
    - 다른 갈 수 있는 경로 없음
    - 따라서 DFS(3) 종료되며 check[3]=0으로 복구
    - DFS(2)로 돌아와서 5로 가는 경로 탐색 -> if (v == n) answer++

3. 핵심 포인트
    - 방문 체크(check[i] = 1)와 해제(check[i] = 0)가 정확히 이루어져야 모든 경로 탐색 가능
    - DFS 함수는 현재 정점에서 목적지까지 가능한 모든 경로 탐색
    - ** 백트래킹: 각 정점에서 갈 수 있는 모든 경로를 시도하되, 이미 방문한 정점은 제외하고, 더 이상 갈 수 없으면 돌아와서 다른 경로를 탐색 **
*/
