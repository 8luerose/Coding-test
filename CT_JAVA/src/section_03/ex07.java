package section_03;
import java.util.*;

public class ex07 {
    public int solution(int N, int k, int[] arr) {
        int answer = 0, tmp = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) cnt++;
            // System.out.println("pre_cnt:" + " " + cnt);
            while (cnt > k) {
                if (arr[lt] == 0) cnt--;
                // System.out.println("post_cnt:" + " " + cnt);
                lt++;
            }
            tmp = rt - lt + 1;
            // System.out.println("dist:" + " " + tmp);
            answer = Math.max(answer, tmp);
            // System.out.println("max:" + " " + answer + "\n");
        }
        // System.out.println("result=" + " " + answer);
        return (answer);

    }
    public static void main(String[] args) {
        ex07 T = new ex07();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(N, k, arr));
        sc.close();
    }
}

/** 입출력
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
=> 8
*/


