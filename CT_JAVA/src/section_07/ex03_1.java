package section_07;
import java.util.*;

public class ex03_1 {
    public int[] solution(int N) {
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < N; i++)
            arr[i] = arr[i - 2] + arr[i - 1];
        return (arr);
    }
    public static void main(String[] args) {
        ex03_1 T = new ex03_1();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int x : T.solution(N)) System.out.print(x + " ");
        sc.close();
    }
}
/** 입출력
10
=> 1 1 2 3 5 8 13 21 34 55
*/