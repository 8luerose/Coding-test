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

public class ex12 {
    static int M, N;
    static int[][] arr, dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();
    public void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dist[nx][ny] = dist[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ex12 T = new ex12();
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) Q.offer(new Point(i, j));
            }
        }
        T.BFS();

        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0) flag = false;
            }
        }
        
        if (flag == true) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    answer = Math.max(answer, dist[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
        sc.close();
    }
}

/** 입출력
▣ 입력
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
=> ▣ 출력
4
*/

/** 배울점
1. BFS를 활용한 토마토 익히기 문제 해결
   - 이 코드는 NxM 격자에서 익은 토마토(1)가 인접한 익지 않은 토마토(0)를 익히는 최소 일수를 계산
   - BFS(너비 우선 탐색)는 레벨 단위로 탐색하며, 동시에 여러 시작점에서 진행 가능
   - 핵심:
     * 모든 익은 토마토에서 동시에 시작
     * 하루마다 인접한 0을 1로 바꾸며 거리(dist) 기록

2. "static Queue<Point> Q"와 초기 설정의 연관성
   - "static Queue<Point> Q = new LinkedList<>();"가 static인 이유:
     * BFS 메서드 외부에서 초기 익은 토마토 위치를 큐에 저장하기 위함
   - "if (arr[i][j] == 1) Q.offer(new Point(i, j));":
     * 입력받을 때 1(익은 토마토)을 발견하면 즉시 Q에 추가
     * 예: 입력에서 (2,3)과 (4,6)에 1 → Q=[(2,3), (4,6)]
   - BFS가 시작될 때 모든 시작점을 이미 큐에 가지고 있음

3. BFS 탐색 과정의 상세 동작
   - BFS 시작:
     * Q에 초기 익은 토마토 위치가 들어감
     * while (!Q.isEmpty())로 큐가 빌 때까지 탐색
   - 각 단계:
     * tmp = Q.poll(): 현재 익은 토마토 위치
     * 네 방향(nx, ny) 탐색 → 0이면 1로 바꾸고 큐에 추가
     * dist[nx][ny] = dist[tmp.x][tmp.y] + 1로 일수 계산
   - 예: Q=[(2,3)] → tmp=(2,3):
     * 상: (1,3) → arr[1][3]=0, dist[1][3]=1
     * 우: (2,4) → arr[2][4]=0, dist[2][4]=1

4. "flag"와 "answer" 계산 로직 분석
   - "boolean flag = true; for (...) if (arr[i][j] == 0) flag = false;":
     * 모든 토마토가 익었는지 체크
     * 0이 남아있으면 flag=false → -1 출력
   - "if (flag == true) { for (...) answer = Math.max(answer, dist[i][j]); }":
     * 모든 토마토가 익었으면 dist 배열에서 최대값(최소 일수) 찾음
     * 예: dist[1][1]=4가 최대 → 4일 걸림
   - 모두 익은 상태에서 0 출력 처리:
     * 처음부터 0이 없으면 BFS에서 dist 값이 갱신되지 않음
     * dist 최대값이 0으로 유지 → 0 출력
*/

/* 해설
1. BFS 동작 원리를 중심으로 전체적인 동작 원리 설명
   - 이 프로그램은 BFS를 사용해 토마토가 모두 익는 최소 일수를 계산
   - BFS 동작 원리:
     * 큐를 활용해 레벨별(하루 단위)로 동시에 확산
     * 여러 시작점(익은 토마토)에서 동시에 진행
     * 최단 거리 계산(dist)으로 최소 일수 보장
   - 전체 과정:
     1) M(가로), N(세로) 입력받고 arr, dist 초기화
     2) arr 입력받으며 1(익은 토마토)을 Q에 추가
     3) BFS 호출로 모든 익은 토마토에서 확산 시작
     4) BFS 종료 후 arr 체크 → 0 남아있으면 -1
     5) 모두 익었으면 dist에서 최대값 출력

2. "static Queue<Point> Q"와 "if (arr[i][j] == 1) Q.offer(...)"의 연관성
   - Q가 static인 이유:
     * BFS 메서드와 main 메서드 간 데이터 공유 필요
     * 입력 단계에서 모든 시작점(1)을 Q에 미리 넣어야 함
   - 동작:
     * 입력 중 arr[i][j]=1 발견 시 Q.offer로 즉시 추가
     * 예: (2,3), (4,6)에 1 → Q=[(2,3), (4,6)]
     * BFS 시작 시 Q가 이미 모든 초기 익은 토마토 포함
   - 장점: BFS를 한 번 호출로 모든 시작점 처리 가능

3. "flag"와 "answer" 계산의 구체적 설명 및 "모두 익은 상태에서 0 출력"
   - "boolean flag = true; ... if (arr[i][j] == 0) flag = false;":
     * BFS 후 arr을 순회하며 0(익지 않은 토마토) 확인
     * 0이 하나라도 있으면 flag=false → 모두 익지 않음
     * 예: BFS 후 arr[1][1]=0 남으면 flag=false
   - "if (flag == true) { ... answer = Math.max(answer, dist[i][j]); }":
     * flag=true면 모든 토마토 익음 → dist에서 최대값 계산
     * dist는 각 위치까지의 일수 → 최대값이 최소 일수
     * 예: dist[1][1]=4, dist[4][4]=3 → answer=4
   - "모두 익은 상태에서 0 출력" 처리:
     * 입력 시 모든 칸이 1(익은 토마토) 또는 -1(빈 칸)이면:
       - arr에 0이 없음 → BFS에서 Q는 비어있거나 0을 만나지 않음
       - dist 배열은 초기값 0 유지 (갱신 없음)
       - flag=true로 유지 → answer = Math.max(Integer.MIN_VALUE, 0) = 0
     * 예: 2x2 격자 "1 1, 1 1":
       - Q=[(1,1), (1,2), (2,1), (2,2)], BFS 실행
       - arr에 0 없음, dist 모두 0 → answer=0 출력
   - 출력:
     * flag=false → -1 (모두 익지 않음)
     * flag=true, dist 최대값=0 → 0 (모두 익음)
     * flag=true, dist 최대값>0 → 최소 일수

4. 입력 예시에 대한 BFS 진행
   - 초기: Q=[(2,3), (4,6)], dist[2][3]=0, dist[4][6]=0
   - tmp=(2,3):
     * 상: (1,3) → arr[1][3]=1, dist[1][3]=1
     * 우: (2,4) → arr[2][4]=1, dist[2][4]=1
   - tmp=(4,6):
     * 좌: (4,5) → arr[4][5]=1, dist[4][5]=1
   - 다음 레벨: Q=[(1,3), (2,4), (4,5)] → 계속 확산
   - 최종: dist[1][1]=4 (최대값), 모든 0이 1로 바뀜 → 4 출력

*/