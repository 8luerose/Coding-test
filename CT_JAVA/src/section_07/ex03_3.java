package section_07;
import java.util.*;

public class ex03_3 {
    public static int[] fibo;
    public int DFS(int N) {
        if (N == 1) return (fibo[N] = 1);
        else if (N == 2) return (fibo[N] = 1);
        else return (fibo[N] = DFS(N - 2) + DFS(N - 1));
    }
    public static void main(String[] args) {
        ex03_3 T = new ex03_3();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fibo = new int[N + 1];
        T.DFS(N);
        for (int i = 1; i <= N; i++) System.out.print(fibo[i] + " ");
        sc.close();
    }
    
}

/** 입출력
10
=> 1 1 2 3 5 8 13 21 34 55
*/