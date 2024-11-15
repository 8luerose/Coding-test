package section_03;
import java.util.*;

public class ex04 {
    public int solution (int n, int m, int[] arr) {
        int cnt = 0, sum =0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) cnt++;
            while (sum >= m) {
                sum -= arr[lt];
                lt++;
                if (sum == m) cnt++;
            }
        }
        return (cnt);
    }
    public static void main(String[] args) {
        ex04 T = new ex04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.print(T.solution(n, m, arr));
        sc.close();
    }
}

/** 입출력
8 6
1 2 1 3 1 1 1 2
=> 3
*/

/** 배울점
1. 과정을 '분류'하자
    - 큰 규칙: 'rt 증가하면서' sum에 더하고, m과 같으면 cnt++
    - 작은 규칙: 근데 만약 sum이 m보다 크거나 같아지면, sum에 lt 빼주고, lt 증가++, 그 sum이 m과 같으면 cnt++
    - 이렇게 해서 O(n^2) 아닌, O(n) 선에서 가능해짐

2. while (sum >= m)
    - 만약 sum이 m보다 커지면, sum에 lt 빼주는 거 까진 ㅇㅋㅇㅋ
    - 그래서 만약에 while (sum > m)까지만 떠올렸다? 그러면 2가지 문제가 발생
        - 1. 계속 sum은 m인 상태에서 rt가 더해진다 -> ex) 6 + rt > m 이고 또 while로 들어가게 됨 -> 불필요한 lt작업 또 시킨다 -> O(n^2)
        - 2. if (sum == m) sum -= arr[lt], lt++ 한번 더 써줘야한 한다 -> 불필요한 코드
    - "되겠지 뭐~" 하는 순간 O(n^2) 되는 것 == 모든 경우를 for-for돌리는 꼴
    - ** O(n)은 순차 진행이다 최대한 '이줄 반복문'과 마주하는 일이 적어야 한다 **

3. lt는 기억하고 있다
    - 순서를 작성해보자. sum에 rt 더하기 -> rt 증가 -> 같으면 cnt++ -> sum >= m 이면 sum에서 lt 빼줘 -> lt증가 -> 같으면 cnt++
    - 여기서 막히는 부분은 while (sum >= m)일 것이다 -> sum에서 [lt]빼주고 lt증가된 상태에서 다시 while돌땐 ** 아까 lt적용돼서 ** 바로 sum-=arr[lt] 될 것이다
    - 즉, {뺴주고, 증가, == 체크} -> 아까 lt 적용돼서 {뺴주고, 증가, == 체크}
    - lt 빼먹지 말자
*/

/* 해설
1. 전체적인 과정
    - rt가 증가하면서 sum에 더하고, m(6)과 같으면 cnt++
    - 근데 이때! sum이 m보다 커지면!!!! -> sum에서 lt 빼주고, lt 증가하고, sum이 m과 같으면 cnt++
    - 이렇게 하면 O(n)으로 가능하다
*/