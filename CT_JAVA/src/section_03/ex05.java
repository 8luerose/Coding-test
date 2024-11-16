package section_03;
import java.util.*;

public class ex05 {
    public int solution (int n) {
        int cnt = 0, sum = 0, lt = 0;
        int half = n/2 + 1;
        int[] arr = new int[half];
        for (int i = 0; i < half; i++) arr[i] = i + 1;
        for (int rt = 0; rt < half; rt++) {
            sum += arr[rt];
            if (sum == n) cnt++;
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) cnt++;
            }
        }
        return (cnt);
    }
    public static void main(String[] args) {
        ex05 T = new ex05();
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
1. O(n) 최적화
    - '나누기 2'
    - 15를 2로 나누면 7 -> 그 다음인 8부터는 연속수 더하면 15이상이 나온다
    - 따라서 반절로 나누는데, 7이 아닌 7+1로 두어서 1~8까지 만들자
    - 왜? 7+8 = 15이기 때문
    - 그냥 외워라 일종의 공식 -> ** 반절이면 어디까지? == (n/2 + 1) **

2. 미리 원소 배열 만들자
    - 배열을 기준으로 순회할 거니까, 배열을 미리 만들어놓자
    - 앞으로 이렇게 연속수 문제처럼, 상식적으로 너무 커질 수 있으면 -> O(n) 최적화를 생각해보자
    - ** 배열을 n개 전부 만들지 말고, n/2 + 1까지만 만들어서 배열 만들어준다 **
 */

/** 해설
1. ex04 연속수와 풀이가 같음.
2. 다만, 원소를 담을 배열 n개 전부 만들지 말고 -> n/2 + 1까지만 만들어서 배열 만들어준다 -> O(n) 최적화
3. 순서: rt로 증가하면서, sum에 더하고, m과 같으면 cnt++, sum이 m보다 크거나 같아지면, sum에서 lt 빼주고, lt 증가하고, 한 번 비교해준다. sum이 m과 같으면 cnt++
4. arr는 지역함수에서 만들어서 원소값 추가해놓는다
*/