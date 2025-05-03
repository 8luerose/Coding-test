package section_10;
import java.util.*;

public class ex05 {
	static int N, M;
	static int[] coinCntArr;
	public int solution(int[] coin) {
		Arrays.fill(coinCntArr, Integer.MAX_VALUE);
		coinCntArr[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= M; j++) {
				int nowCnt = coinCntArr[j - coin[i]] + 1;
				coinCntArr[j] = Math.min(coinCntArr[j], nowCnt);
			}
		}
		return (coinCntArr[M]);
	}
	public static void main(String[] args) {
		ex05 T = new ex05();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		M = sc.nextInt();
		coinCntArr = new int[M + 1];
		System.out.println(T.solution(arr));
		sc.close();
	}
}
/** 입출력  
입력 예:  
3  
1 2 5  
15  

출력 예:  
3  
→ 5원짜리 3개로 15원을 만들 수 있으므로 최소 동전 개수는 3.
*/

/** 배울점  
1. 동전 교환 문제는 "완전 냅색(무한히 반복 사용 가능)" 문제임  
   - 같은 동전을 여러 번 쓸 수 있기 때문에 완전 냅색 알고리즘을 적용함
   - 냅색이란? 배낭에 최대 혹은 최소 넣을 수 있는 값 찾는 것
   - dp 인데 -> 반복 사용 가능한 조합 최적화 문제는 냅색 으로 풀 수 있음 

2. dp[j - coin[i]] + 1 을 떠올리는 방식  
   → 예: 15원을 만들고 싶다  
   → 만약 마지막에 5원짜리를 썼다면?  
      → 15 - 5 = 10원을 먼저 만들 수 있어야 함  
      → 그 10원을 만들기 위한 최소 동전 개수는 이미 dp[10]에 있음  
      → 거기에 5원짜리 1개를 더하면 15원이 되므로 dp[15] = dp[10] + 1  
   → 이 방식은 "마지막 동전을 내가 직접 추가한다고 가정했을 때, 그 이전 상태(j - coin[i])를 활용"하는 구조임

3. 완전 냅색 이중 for
   - 바깥 루프가 '동전 종류별 반복'이고,  
   - 안쪽 루프가 '해당 동전으로 만들 수 있는 금액부터 M까지 반복'  
   - 이 순서를 유지하면 "같은 동전을 여러 번 쓰는 상황"이 반영된다  

4. 초기화
   - dp[0] = 0: 0원을 만들기 위해선 동전이 필요 없으므로 0  
   - 나머지 dp[i]들은 매우 큰 수(Integer.MAX_VALUE)로 초기화  
   - 그래야 min 비교를 통해 최소값을 올바르게 찾을 수 있음

5. 중요한 코드 문장 설명  
   - Arrays.fill(coinCntArr, Integer.MAX_VALUE): 이따 Math.min으로 더 작은 갯수 바꿀꺼니까 전부 Arrays.fill(arr, Max)로 바꿔놓는다
   - coinCntArr[0] = 0: 0원을 만들 땐 동전이 필요 없으므로 0  
   - for (int j = coin[i]; j <= M; j++): j는 현재 동전으로 만들 수 있는 최소 금액부터 시작  
   - coinCntArr[j] = Math.min(coinCntArr[j], coinCntArr[j - coin[i]] + 1);  
     → "j원을 만들 때 기존 방법과, 현재 coin[i]를 마지막에 추가한 방법 중 더 나은 걸 선택"하는 핵심 점화식

*/

/** 해설  
1. 문제 목표  
   - 여러 동전(1, 2, 5원 등)을 이용해 목표 금액 M(15원)을 만들 때  
   - 필요한 동전의 개수를 가장 적게 만드는 방법을 찾는 문제  

2. 완전 냅색 알고리즘 적용 이유  
   - 각 동전을 여러 번 사용할 수 있으므로 완전 냅색 구조를 사용  
   - 핵심 아이디어는:  
     → 'j원을 만들려면, j-coin[i]원을 먼저 만들 수 있어야 한다'  
     → 그리고 마지막에 coin[i] 동전 하나를 추가하는 방식  
     → 그래서 dp[j] = min(dp[j], dp[j - coin[i]] + 1)

3. 구체적인 동작 예시  
   - coin = {1, 2, 5}, M = 15일 때의 동작을 단계별로 살펴보자  
   
   1단계: coin = 1일 때  
   dp[1] = dp[0] + 1 = 1  
   dp[2] = dp[1] + 1 = 2  
   ...  
   dp[15] = dp[14] + 1 = 15  
   → 1원만으로 15원 만들면 동전 15개 필요

   2단계: coin = 2일 때  
   dp[2] = min(2, dp[0] + 1) = 1  
   dp[3] = min(3, dp[1] + 1) = 2  
   dp[4] = min(4, dp[2] + 1) = 2  
   dp[5] = min(5, dp[3] + 1) = 3  
   ...  
   dp[15] = min(15, dp[13] + 1) = 8  
   → 2원을 섞어서 쓰면 개수를 줄일 수 있음

   3단계: coin = 5일 때  
   dp[5] = min(3, dp[0] + 1) = 1  
   dp[10] = min(5, dp[5] + 1) = 2  
   dp[15] = min(8, dp[10] + 1) = 3  
   → 최종적으로 dp[15] = 3 (5원짜리 3개)

4. 최종 출력  
   - coinCntArr[15] = 3
   - 최소 동전 개수Arr[15원일때] => 3개
   - 이 값을 정답으로 출력
*/
