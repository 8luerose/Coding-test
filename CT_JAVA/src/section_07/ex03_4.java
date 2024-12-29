package section_07;
import java.util.*;

public class ex03_4 {
    public static int[] fibo;
    public int DFS (int N) {
        if (fibo[N] > 0) return (fibo[N]);

        if (N == 1) return (fibo[N] = 1);
        else if (N == 2) return (fibo[N] = 1);
        else return (fibo[N] = DFS(N - 2) + DFS(N - 1));
    }
    public static void main(String[] args) {
        ex03_4 T = new ex03_4();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fibo = new int[N + 1];
        T.DFS(N);
        for (int i = 1; i <= N; i++) {
            System.out.print(fibo[i] + " ");
        }
        sc.close();
    }
}
/** 입출력
10
=> 1 1 2 3 5 8 13 21 34 55
*/

/** 배울점
1. static 배열을 활용한 메모이제이션
   - static int[] fibo로 선언하여 전역으로 사용
   - 한 번 계산한 값을 배열에 저장해두고 재활용함으로써 중복 계산 방지
   - if (fibo[N] > 0) return (fibo[N]) 조건으로 이미 계산된 값은 바로 반환

2. DFS의 효율적 구현
   - 기존 재귀는 O(2^n)이지만, 메모이제이션으로 O(n)으로 최적화
   - return (fibo[N] = DFS(N-2) + DFS(N-1)) 형태로 계산과 저장을 동시에 수행
   - 베이스 조건(N==1, N==2)을 먼저 체크하여 불필요한 재귀 호출 방지

3. 배열 크기 설정
   - fibo = new int[N + 1] 로 선언하여 1부터 N까지 인덱스 사용
   - fibo[N]은 모두 0으로 초기화. 따라서 fibo[N] > 0 이라면 DFS(N)과정에서 한 번이라도 배열에 값이 담긴 것
   - 0번 인덱스는 사용하지 않음으로써 직관적인 인덱싱 가능
*/

/* 해설
1. 전체적인 접근 방법
   - 피보나치 수열을 재귀로 구현하되, 메모이제이션 기법 적용
   - 이미 계산된 값은 배열에서 바로 반환하여 중복 계산 방지
   - N번째 수를 구하면서 전체 수열도 배열에 저장

2. 구체적인 실행 과정 (N=5일 때)
   - DFS(5) 호출
     → DFS(3) + DFS(4) 필요
     → DFS(1) + DFS(2) = 1 + 1 = 2 (DFS(3) == 3번째 수)
     → DFS(2) + DFS(3) = 1 + 2 = 3 (DFS(4) == 4번째 수)
     → 최종적으로 2 + 3 = 5 (5번째 수)
   
3. 메모이제이션 효과
   - 예를 들어 DFS(4)를 계산할 때 이미 계산된 DFS(3)을 재활용
   - fibo 배열에 [0, 1, 1, 2, 3, 5, ...] 형태로 저장
   - 중복 계산이 없어져 실행 시간 대폭 감소
*/