package section_02;
import java.util.*;

class ex04 {
    public int [] solution(int n) {
        int [] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return (arr);
    }
    public static void main(String[] args) {
        ex04 T = new ex04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }
    }
}

/** 입출력
 * 10
 * => 1 1 2 3 5 8 13 21 34 55
 */