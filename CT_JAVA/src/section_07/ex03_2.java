package section_07;
import java.util.*;

public class ex03_2 {
    public int DFS(int N) {
        if (N == 1) return (1);
        else if (N == 2) return (1);
        else return (DFS(N - 2) + DFS(N -1));
    }
    public static void main(String[] args) {
        ex03_2 T = new ex03_2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) System.out.print(T.DFS(i) + " ");
        sc.close();
    }
    
}

/** 입출력
10
=> 1 1 2 3 5 8 13 21 34 55
*/