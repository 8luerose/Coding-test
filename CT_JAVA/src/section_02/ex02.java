package section_02;
import java.util.*;

class ex02 {
    public int solution(int n, int [] arr) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                cnt++;
                max = arr[i];
            }
        }
        return (cnt);
    }
    public static void main(String[] args) {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}

/** 입출력
 * 8
 * 130 135 148 140 145 150 150 153
 * => 5
 */

/* 해설
1. 이중 for로 앞에 있는 것을 하나씩 확인하면, O(n^2)의 시간복잡도 걸림.
2. 나보다 큰 사람이 앞에 있었는지 기억하면 O(n)으로 줄일 수 있음.
3. 기억하기 위해 'max'라는 변수를 만들어서, 내가 max보다 크면 cnt++ && max = arr[i] 갱신
4. 처음에 max를 Integer.MIN_VALUE로 초기화해놓으면, 처음 arr[0] cnt++ 가능해짐
5. 그러나, 처음에 max를 arr[0]으로 놓고, 처음 학생이 무조건 카운트 된다고 가정한다면 for (int 'i = 1'부터) 해야함
    - int cnt = 1, max = arr[0]
    - for(int i=1; i<n; i++)
    - 첫번째 학생은 무조건 cnt++ 이니까, '두번째 학생부터 세겠다'는 뜻이 됨
 */