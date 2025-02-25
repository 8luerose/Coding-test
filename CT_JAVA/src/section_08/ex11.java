package section_08;
import java.util.*;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ex11 {
    static int[][] arr, dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        arr[x][y] = 1;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0) {
                    dist[nx][ny] = dist[tmp.x][tmp.y] + 1;
                    Q.offer(new Point(nx, ny));
                    arr[nx][ny] = 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        ex11 T = new ex11();
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];
        dist = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        T.BFS(1, 1);        
        if (arr[7][7] == 0) System.out.println(-1);
        else System.out.println(dist[7][7]);
        sc.close();
    }
}

/** 입출력
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
=>
12
*/

/** 배울점
1. BFS를 통한 최단 경로 탐색
   - 이 코드는 7x7 미로에서 (1,1)에서 (7,7)까지의 최단 거리를 BFS로 계산
   - BFS(너비 우선 탐색)는 큐를 사용해 레벨별로 탐색
   - 특징:
     * 같은 거리(레벨)에 있는 위치를 먼저 모두 탐색
     * 최단 경로를 보장 (가중치 없는 그래프에서)

2. "dist[nx][ny] = dist[tmp.x][tmp.y] + 1"의 동작
   - dist 배열은 각 위치까지의 최단 거리를 저장
   - 초기값: 모두 0
   - 동작:
     * 현재 위치(tmp)의 거리에서 1을 더해 다음 위치(nx,ny)의 거리 계산
     * 예: dist[1][1]=0 → dist[1][2]=1 → dist[1][3]=2
   - BFS 특성상 처음 도달한 경로가 최단 경로

3. "arr[nx][ny] = 1"과 방문 체크
   - arr 배열은 미로 상태와 방문 여부를 동시에 관리
     * 0: 통로, 이동 가능
     * 1: 벽 또는 방문한 곳
   - arr[nx][ny]=1로 방문 표시해 중복 탐색 방지
   - 예: (1,1) 방문 후 arr[1][1]=1 → 재방문 불가

4. "int nx = tmp.x + dx[i]; int ny = tmp.y + dy[i];"의 역할
   - dx, dy 배열로 상하좌우 이동 정의:
     * 상(-1,0), 우(0,1), 하(1,0), 좌(0,-1)
   - nx, ny는 다음 탐색 위치 계산
   - 예: (2,1)에서:
     * 상: (1,1)
     * 우: (2,2)
     * 하: (3,1)
     * 좌: (2,0)

5. BFS 초기 동작 추적 (입력 예시 기준)
   - BFS(1,1):
     * Q=[(1,1)], arr[1][1]=1, dist[1][1]=0
     * tmp=(1,1):
       - 상: (0,1) → 범위 밖
       - 우: (1,2) → 벽(1)
       - 하: (2,1) → arr[2][1]=0, Q=[(2,1)], dist[2][1]=1, arr[2][1]=1
       - 좌: (1,0) → 범위 밖
     * tmp=(2,1):
       - 상: (1,1) → 방문함
       - 우: (2,2) → arr[2][2]=0, Q=[(2,2)], dist[2][2]=2, arr[2][2]=1
       - 하: (3,1) → 벽(1)
       - 좌: (2,0) → 범위 밖
   - 이 과정이 (7,7)까지 진행
*/

/* 해설
1. BFS 동작 원리를 중심으로 전체적인 동작 원리 설명
   - 이 프로그램은 BFS를 사용해 7x7 미로의 최단 경로를 찾음
   - BFS 동작 원리:
     * 큐를 활용해 현재 위치에서 갈 수 있는 모든 곳을 탐색
     * 레벨 단위로 진행 → 같은 거리의 위치를 먼저 처리
     * 최단 경로 보장: 더 긴 경로로 덮어쓰지 않음
   - 전체 과정:
     1) main에서 7x7 미로 입력 받음 (arr 초기화)
     2) dist 배열로 각 위치까지 거리 저장 (초기값 0)
     3) BFS(1,1) 호출로 탐색 시작
     4) 큐에 시작점(1,1) 추가, 방문 표시
     5) 큐가 빌 때까지:
        - 현재 위치 꺼내고(tmp), 네 방향 탐색
        - 이동 가능하면 거리 계산(dist), 큐에 추가, 방문 표시
     6) (7,7) 도달 여부 체크 후 거리 출력

2. dist와 arr 배열의 역할
   - dist:
     * 각 좌표까지의 최단 거리를 기록
     * 예: dist[7][7]=12는 (1,1)에서 (7,7)까지 12칸 이동
     * BFS로 처음 도달 시 값이 설정되며, 이후 갱신 없음
   - arr:
     * 미로 정보(0: 통로, 1: 벽)와 방문 상태 관리
     * BFS 진행 중 0→1로 바뀌며 방문 표시
     * 예: arr[2][2]=0 → BFS로 방문 시 arr[2][2]=1

3. "nx, ny" 계산과 이동 과정
   - "int nx = tmp.x + dx[i]; int ny = tmp.y + dy[i];":
     * 현재 위치(tmp)에서 네 방향으로 이동 시도
     * 조건: "nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0"
       - 격자 내, 통로(0)인 경우만 이동
   - 예: tmp=(3,3):
     * 상: (2,3)
     * 우: (3,4)
     * 하: (4,3)
     * 좌: (3,2)
   - 이동 가능 시: dist 갱신, 큐 추가, 방문 표시

4. 큐에 담기는 과정
	- 처음에 [1][1] 부터 Q.offer 해주고 -> While (Q) 시작
	- Q에 담겨있는 [ (1,1) ]을 '하나' poll해서 -> for 돌려서 nx, ny 구하고 -> nx,ny바탕으로 다음칸에 들어갈 수 있는지 판단
	- 들어갈 수 있으면, 다음[nx][ny]에 '기존거리 + 1로 거리 작성' + ** Q에 해당 nx,ny를 Q.offer(new Point(nx, ny)) 로 담아주고 ** + 다시 못 가게 arr[nx][ny] = 1
	- for 계속 돌아서 4방향 다 끝나면 Q에 다 담겨있을 것 -> for 끝나고 다시 Q로 접근
	- 이때 Q에는 [  (0,3) (1,2) ...  ] 이런식으로 담겨있을 것 -> 하나 poll해서 또 for 돌린다

5. ** 주의 **
	- '어? 최단거리 구하는 건데 덮어쓰기 되는 건가?' -> NO!!!
	- Why?? : 방문한 칸 arr[nx][ny] = 1 해놓다보면 '더 빨리 간 것이 먼저 진입하고 문 닫은 거라 덮어쓰기는 커녕 해당 칸 진입 불가'
*/