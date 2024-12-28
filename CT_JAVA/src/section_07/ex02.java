package section_07;
import java.util.*;

public class ex02 {
    public int DFS(int N) {
        if (N == 1) {
            // System.out.print(N);
            return (1);
        }
        else {
            // System.out.print(N + " ");
            return (N * DFS(N - 1));
        }
    }
    public static void main(String[] args) {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = T.DFS(N);
        // System.out.println();
        System.out.println(answer);
        sc.close();
    }  
}

/** 입출력
5
=> 120
*/

/** 해설
1. 5 4 3 2 1 == 팩토리얼 문제 == 재귀
    - 1까지 갔다가 5로 나와야 한다
    - 1 * 2 * 3 * 4 * 5 순으로 가야한다
    - ** 근데 어떻게 차곡차곡 기억하지? "N x (재귀)" **
    - {(재귀 펑 == 기존 값들) x N } == 이것또한 재귀로 생각한다
    - {{재귀 == 기존값들} x N} x N == "N x (재귀)"

2. 잘 떠올리기 힘들면 그냥 팩토리얼은 재귀겠구나 생각하자
    - 5! = 5 x (재귀) 라고 생각하자
    - ** 명시적 일반화 하자 N x (재귀) **

3. base case는 꼭 만들자
    - 탈출 조건 명시해야 재귀 끝남
    - 1까지 가면 펑 터지고 1리턴 한다 == if(N == 1) return (1)
*/