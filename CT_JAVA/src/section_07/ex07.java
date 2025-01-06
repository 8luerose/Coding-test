package section_07;
import java.util.*;

public class ex07 {
    int[] dist = {1, -1, 5};
    int[] check;
    Queue<Integer> Q= new LinkedList<>();

    public int BFS(int S, int E) {
        check = new int[10000 + 1];

        int level = 0;
        Q.offer(S);
        check[S] = 1;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int tmp = Q.poll();

                for (int j = 0; j < dist.length; j++) {
                    int next = tmp + dist[j];
                    if (next == E) return (level + 1);
                    if (next >= 1 && next <= 10000 && check[next] == 0) {
                        Q.offer(next);
                        check[next] = 1;
                    }
                }

            }
            level++;
        }
        return (0);
    }
    public static void main(String[] args) {
        ex07 T = new ex07();
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();
        System.out.println(T.BFS(S, E));
        sc.close();
    }
}
/** 입출력
5 14
=> 3

[입력값 설명]
- 현수의 시작 위치(S) = 5
- 송아지의 위치(E) = 14
- 직선상의 좌표 점은 1부터 10,000까지 가능

[출력값 설명]
- 점프의 최소횟수를 출력: 3번
- 구체적인 이동 경로 예시: 5 -> 10 -> 9 -> 14 (5칸 전진 -> 1칸 후진 -> 5칸 전진)
*/

/** 배울점
1. BFS 구현을 위한 필수 요소들
   - Queue<Integer> Q = new LinkedList<>(): 
     * BFS는 반드시 큐 자료구조를 사용하여 구현해야 함
     * 인터페이스는 Queue, 구현체는 LinkedList 사용
     * Integer 래퍼 클래스를 사용하여 위치값 저장
   
   - check[] 배열:
     * 방문 여부를 체크하는 배열로, 중복 방문 방지가 목적
     * 배열 크기는 문제의 범위보다 1 크게 설정 (10000 + 1)
     * 방문한 위치는 1, 방문하지 않은 위치는 0으로 표시
   
   - dist[] 배열:
     * 한 번의 점프로 이동할 수 있는 거리를 저장
     * {1, -1, 5}: 앞으로 1, 뒤로 1, 앞으로 5를 의미
     * 이동 거리가 고정적일 때 배열로 선언하여 사용
     * dist.length 로 for 돌려서 현재 레벨에 위치한 각각의 노드들이 점프해야 하는 횟수 지정

2. BFS의 레벨 단위 탐색 구현
   - ** len = Q.size()를 통한 현재 레벨의 노드 수 파악이 매우 중요 **
     * 현재 레벨에 있는 모든 노드를 처리하기 위해 필요
   
   - for(int i = 0; i < len; i++) 루프:
     * 현재 레벨의 노드들만 처리하기 위한 루프
     * 새로 추가되는 노드들은 다음 레벨에서 처리됨
   
   - level++ 의미:
     * 현재 레벨의 모든 노드 처리가 끝났음을 표시
     * 점프 횟수를 카운트하는 역할

3. 상태 관리의 중요성
   - if (next >= 1 && next <= 10000):
     * 좌표의 유효 범위 검사가 반드시 필요
     * 범위를 벗어난 위치는 무시
   
   - check[next] == 0:
     * 아직 방문하지 않은 위치만 큐에 추가
     * ** 중요: 큐에 위치를 추가할 때 즉시 방문 처리(check[next] = 1)를 해야 함 **
     * 방문 처리를 나중에 하면 중복 방문이 발생할 수 있음

4. 최단 거리 보장을 위한 구현 포인트
   - if (next == E) return (level + 1):
     * 목적지 도달 즉시 현재 레벨 + 1을 반환
     * BFS는 레벨 순서로 탐색하므로 처음 도달한 경로가 최단 경로
   
   - while (!Q.isEmpty()):
     * 큐가 비어있지 않은 동안 계속 탐색
     * 모든 가능한 경로를 탐색하여 최적해를 보장
*/

/* 해설
1. 전체적인 접근 방법
   - BFS를 사용하여 모든 가능한 이동 경로를 레벨(점프 횟수) 단위로 탐색
   - 큐를 사용하여 현재 위치에서 갈 수 있는 모든 다음 위치를 저장
   - 각 위치를 방문할 때마다 해당 위치까지의 최소 점프 횟수를 레벨로 관리
   - 송아지 위치에 처음 도달하는 순간이 최소 점프 횟수를 보장

2. 구체적인 진행 과정 (S=5, E=14 예시)
   [Level 0]: 시작점
   - 현수의 위치 5를 큐에 삽입
   - check[5] = 1로 방문 처리

   [Level 1]: 첫 번째 점프
   - 5에서 갈 수 있는 위치: 6(+1), 4(-1), 10(+5)
   - 큐 상태: [6, 4, 10]
   - check[6] = check[4] = check[10] = 1

   [Level 2]: 두 번째 점프
   - 6에서: 7(+1), 5(-1), 11(+5)
   - 4에서: 5(+1), 3(-1), 9(+5)
   - 10에서: 11(+1), 9(-1), 15(+5)
   - 큐에 새로운 위치들 추가 (이미 방문한 위치 제외)

   [Level 3]: 세 번째 점프
   - 이전 위치들에서 점프하여 14에 도달
   - 14 == E이므로 현재 level + 1 = 3 반환

3. 핵심 포인트
   - Queue와 check 배열을 통한 효율적인 상태 관리
   - 레벨 단위의 탐색으로 최단 거리 보장
   - 범위 체크와 방문 처리를 통한 불필요한 탐색 방지
   - dist 배열을 활용한 유연한 이동 거리 처리

4. 시간 복잡도
   - O(N): 각 위치를 최대 한 번씩만 방문
   - check 배열로 중복 방문을 방지하여 효율적인 탐색 가능
*/