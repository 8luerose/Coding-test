package section_07;
import java.util.*;

public class ex01 {
    public void DFS(int N) {
        if (N == 0) return;
        else {
            DFS(N / 2);
            System.out.print((N % 2) + " ");
        }
    }
    public static void main(String[] args) {
        ex01 T = new ex01();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        T.DFS(N);
        sc.close();
    }
}
/** 입출력
11
=> 1 0 1 1
*/

/* 연습장
11 / 2 = 5 .. 1
5 / 2 = 2 .. 1
2 / 2 = 1 .. 0
1 / 2 = 0 .. 1

(5) 0      -> 0 return
(4) 1 .. 1 -> 위에 return하고 1로 회귀 -> 출력 나머지 1
(3) 2 .. 0 -> 위에 return하고 2로 회귀 -> 출력 나머지 0
(2) 5 .. 1 -> 위에 reutrn하고 5로 회귀 -> 출력 나머지 1
(1) 11 .. 1 -> 위에 return하고 11로 회귀 -> 출력 나머지 1

STACK (5)pop -> (4)pop -> (3)pop -> (2)pop -> (1)pop -> end
*/