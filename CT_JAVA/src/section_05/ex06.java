package section_05;
import java.util.*;

public class ex06 {
    public int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) q.offer(i);
        while (q.isEmpty() == false) {
            for (int i = 0; i < K - 1; i++) {
                Integer tmp = q.poll();
                q.offer(tmp);
            }
            q.poll();
            if (q.size() == 1) answer = q.poll();
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex06 T = new ex06();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.solution(N, K));
        sc.close();
    }
}

/** 입출력
8 3
=> 7
*/

/** 배울점
1. Queue는 인터페이스, 구현체는 LinkedList(), PriorityQueue(), ArrayDeque()가 있다
2. 원형 문제 나오면 queue일 가능성이 높다 ->  '요세푸스 순열' 또는 '원형 큐'라고도 불린다
3. Queue 사용법
    - q.poll(): 맨 앞 꺼낼 때 
    - q.offer(): 맨 뒤로 삽입할 때
    - q.size(): 사이즈
    - q.contain(x): 포함되어 있는지 여부
    - q.isEmpty()
4. q.offer(q.poll()) 도 가능하다
*/

/* 해설
1. 원형 문제다? -> Queue로 접근한다 -> q.poll(), q.offer(), FIFO 떠올리기
2. ** 문제 오류 **
    - 문제에서는 각각 왕자들이 번호를 부른다고 했지만, 하나의 고정된 값을 부르고 그 차례인 왕자가 빠진다고 생각하자
3. K가 3일 때
    - 1,2는 순서대로 빠지고 맨 뒤로 들어간다
    - 3일 때 poll해서 큐에서 완전히 빠지게 한다
    - 4,5는 빠지고 맨 뒤로 들어간다
    - 6은 poll해서 큐에서 완전히 빠지게 한다
    - 반복
4. 단, 2개 남았을 때 과정을 이해해야 한다
    - 예를 들어 K가 3일 떄 -> 2개 남았으면 순서대로 뒤로 들어가는 것을 반복 -> 3번 째 차례일 때 poll()해주는 것
5. 만약 1개가 남았다면 정답이 되어야 한다.
    - while(큐가 비어있지 않다면) - 만약 큐.size()가 1개 남았다면 = poll()해준다
6. 순서 중요
    - N개 만큼 큐에 넣어준다 -> for 로 i=1~N만큼
    - while로 큐에 남은 거 있을 떄까지 돌린다
    - for(K-1)까지 돌려준다 -> 예를 들어 i=0이라면, 0,1까지만 돌고 K-1인 '2'는 돌지 않는다
    - K-1까지 돌았으면 q.poll()해준다 -> 왜? K번째 차례니까 poll해줘야지
    - 만약 1개 남았으면 poll해서 정답 변수에 담는다
    - 이제 q비었으니까 while 탈출하고 정답 return
*/
