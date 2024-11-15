package section_03;
import java.util.*;

public class ex03 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];

        answer = sum;
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex03 T = new ex03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(T.solution(n, k, arr));
        sc.close();
    }
}

/** 입출력
10 3
12 15 11 20 25 10 20 19 13 15
=> 56
*/

/** 배울점
1. 슬라이딩 윈도우
    - 여러개의 미닫이 샷시를 그대로 쭉 미는 것을 뜻함 [ ] [ ] [ ] -> [ ] [[ ] -> [[[ ]
    - ex) 3개 원소 배열값 합을 구하고 -> 그것을 기반으로, 4번째 것을 더하고 1번째 것을 빼면 똑같이 3개 sum 값 나온다
    - sum += (arr[i] - arr[i - k])

2. 둘 중에 뭐가 더 큰데?
    - 아주 기본적인 문제. if (a > b) 대신 Math.max(a, b) 이런 식으로 가능
    - for () - sum 나올 때마다 answer = Math.max()로 비교해서 답을 갱신해놓는다

3. 초기화를 습관으로 하자
    - 'answer = sum' or 'answer = 0' 처럼 for 돌리기 전 습관화 해두자
    - (int b = 0) - for() 순으로
 */

/* 해설
1. A + B + C -> B + C + D
    - 3개의 합을 구하는 문제
    - 3개 구하고, (+다음거 더하고) - (첫번째꺼 빼면) => 3개 합이 나온다
    - sum += (arr[i] - arr[i - k])

2. O(n)
    - for문 한 번만 돌면서 sum을 구하면 된다
    - 만약, O(n^2)으로 풀면 잘못됐다
    - 예를 들어, for(전체) - for(1~3) 이중 돌리고, index i를 기준으로 n번 돌리면 O(n^2)이다
    - 이 문제는, for(전체) - for(1~3) 이중 돌리지 않고, for(전체) 한 번만 돌리면 된다 -> O(n)
*/