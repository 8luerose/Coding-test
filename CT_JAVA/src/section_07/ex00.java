package section_07;
import java.util.*;

public class ex00 {
    public void DFS(int N) {
        if (N == 0) return;
        else {
            DFS(N - 1);
            System.out.print(N + " ");
        }
    }

    public static void main(String[] args) {
        ex00 T = new ex00();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        T.DFS(N);
        sc.close();
    }
    
}

/** 입출력
3
=>1 2 3
*/