package section_04;
import java.util.*;

public class ex05 {
    public int solution(int N, int K, int[] arr) {
        int answer = 0;
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    tset.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        answer = -1;
        int cnt = 0;
        for (int x : tset) {
            cnt++;
            if (cnt == K) {
                answer = x;
                break;
            }
        }
        return (answer);
    }
    
    public static void main(String[] args) {
        ex05 T = new ex05();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        System.out.print(T.solution(N, K, arr));
        sc.close();
    }
}


/** 입출력
10 3
13 15 34 23 45 65 33 11 26 42
=> 143
*/

/** 배울점
1. TreeSet은 set 자료구조로 이루어진 인터페이스이다.
    - 중복이 되지 않고 + 순서를 보장해준다(오름, 내림)
    - TreeMap은 키-값 쌍인데 반면, TreeSet은 오로지 단일 값만을 가진다

2. new TreeSet<>(Collections.reverseOrder())
   - Collections.reverseOrder()라는 걸 쓰면 reverse로 정렬해준다

3. TreeSet 사용법
   - TreeSet.add(): 중복이면 제거하고, 순서대로 정렬된 상태가 된다
   - TreeSet.remove(): 해당 값을 제거한다
   - TreeSet.size(): 개수 반환한다
   - TreeSet.first(): 정렬 상태 중 첫번째값 -> 오름차순 정렬되어 있으면 최소값, 내림차순 정렬되어 있으면 최대값
   - TreeSet.last(): 정렬 상태 중 마지막값
*/

/* 해설
1. ** 3중 for문 문제 **
    - 3개를 고르는 모든 경우의 수를 찾아서 + 합치는 문제이므로 -> Brute Force
    - A, B, C는 각각 i, j = i + 1, k = j + 1이다

2. 3중 for문 돌려서 모든 경우의 수에 대해 TreeSet.add( + + )로 삽입한다
3. for - each()로 일일이 돌려서 cnt K번째 것 return 처리하면 된다

4. TreeSet
    - 중복 제거 + 순서 보장 하므로 사용했음
    - 단일값이므로 해시맵(키-값 쌍)과 다름
*/