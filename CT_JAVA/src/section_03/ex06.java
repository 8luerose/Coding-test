package section_03;
import java.util.*;

public class ex06 {
    public int solution (int n) {
        int answer = 0, cnt = 1;
        n = n - cnt;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }
        return (answer);
    }
    public static void main(String[] args) {
        ex06 T = new ex06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
        sc.close();
    }
}

/** 입출력
15
=> 3
*/

/** 배울점
1. 수학적으로 접근할 수 있다
    - 사실 투포인터가 이해하기 더 쉬운듯..
    - 그럼 투포인터로 하자! 수학은 유형 접근에 대한 일관성이 없네..
*/

/* 해설
1. (N % cnt == 0) 원리부터 이해하자
    - 문제풀이 핵심 원리: 1, 2 두 개 있을 때 -> 1+2한 3을 N에서 뺀 12를 -> 두개(1,2)니까 2로 나누고 -> 각 2개가 6 6로 나뉜거니까 -> 1+6 , 2+6 = 7, 8 로 답이된다
    - 즉, N을 1부터 차례대로 빼면서, N에 Cnt개수를 나누었을 때, 나머지가 0이 되는 경우를 찾는다
    - (1) 시작은 1+2: N이 15 일 때, 1+2 한 3을 15-3 하면 12가 나오고, 12 % 2(1,2) == 0 이 되니까 답이 된다
    - (2) 그 다음부터 차례대로 빼기: N이 방금 12가 된 상태고, 1+2+'3'처럼 추가된 3을 12-3 하면 9이 나오고, 9 % 3(1,2,3) == 0 이 되니까 답이 된다
    - (3) 그 다음부터 차례대로 빼기: N이 방금 9가 된 상태고, 1+2+3+'4'처럼 추가된 4을 9-4 하면 5가 나오고, 5 % 4(1,2,3,4) != 0 이 되니까 답이 아니다
    - (4) 그 다음부터 차례대로 빼기: N이 방금 5가 된 상태고, 1+2+3+4+'5'처럼 추가된 5을 5-5 하면 0이 나오고, 0 % 5(1,2,3,4,5) == 0 이 되니까 답이 된다
    - n이 0보다 작으면 끝! (= While(n > 0))

2. 15 - 1 미리 하기
    - while() 안에서 해결 불가 -> 밖에서 미리 15 - 1 한 상태로 시작해야 한다. 그래야 1다음 수인 2를 빼고 14-2 = 12가 되고, 12 % 2 == 0 이 되니까 답이 된다
    - while()밖에서 n = n - cnt; 를 미리 해주자 그 다음 while로 들어오면 '모든 규칙을 적용할 수 있다'
    - 즉, 효율적 처리를 위해 처음 케이스는 while() 밖에서 처리하자
    - 그 다음 while로 들어오면, cnt++한 값을 빼주면 된다(n = n - cnt). '이때부터 반복규칙을 적용'할 수 있다는 뜻
*/