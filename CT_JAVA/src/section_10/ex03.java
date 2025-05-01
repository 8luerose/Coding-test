package section_10;
import java.util.*;

public class ex03 {
	static int[] arr;
	static int[] dy;
	public static int solution() {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
			}
			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution());
		sc.close();
	}
}
/** 입출력  
입력 예:  
8  
5 3 7 8 6 2 9 4  

출력 예:  
4  
*/

/** 배울점  
1. 동적 프로그래밍(DP) 기초  
   - dy[i]는 i번째 숫자를 마지막으로 포함하는 증가 부분 수열의 최대 길이.  
   - 예: dy[2]=2이면, arr[2]=7까지 고려했을 때 만들 수 있는 최대 증가 부분 수열은 길이 2.

2. 점화식 핵심  
   - dy[i] = (i 앞에서 arr[i]보다 작은 값들 중 dy[j] 최댓값) +1  
   - i 앞에서 나보다 작은 숫자 중, dy[j] 값이 큰 걸 찾아 내가 이어붙는다고 생각하면 된다.

3. 최대값 관리  
   - answer 변수는 dy[i] 값들을 하나하나 비교하면서 현재까지 찾은 최장 길이를 계속 갱신한다.

4. 역순 루프 이유  
   - j=i-1에서 0까지 거꾸로 탐색하면 큰 dy[j]를 더 빨리 만나 break 같은 최적화가 가능하다.  
   - 순방향(0 → i-1)으로 돌려도 정답은 같다.

5. 초기값 설계  
   - dy[0]=1로 초기화 → 자기 자신만으로 길이 1 수열이 가능하도록.  
   - max=0으로 초기화 → 앞에 작은 값이 하나도 없으면 dy[i]=1로 계산.

*/

/** 해설  
1. 문제 목표  
   - 주어진 수열에서 순서를 지키며 만들 수 있는 가장 긴 증가 부분 수열의 길이를 구한다.  
   - 예: [5,3,7,8,6,2,9,4] 전체에서 최장 증가 부분 수열은 [3,7,8,9], 길이 4.

2. dy 배열 의미와 계산 흐름  
   - dy[i]=arr[i]로 끝나는 증가 부분 수열의 최대 길이.  
   - 예:  
     → i=2(arr=7) → 앞에서 5,3 둘 다 7보다 작음, dy=1 둘 다 → max=1 → dy[2]=2  
     → i=3(arr=8) → 앞에서 7(2),5(1),3(1) 중 dy 최댓값=2 → dy[3]=3  
     → i=6(arr=9) → 앞에서 8(3),7(2),6(2),5(1),3(1),2(1) 중 dy 최댓값=3 → dy[6]=4

3. +1 이유  
   - i 앞에서 찾은 최장 증가 부분 수열에 arr[i] 자신을 추가하므로 길이 +1.

4. 내부 루프 동작  
   - i 앞쪽 j들 중 arr[j]<arr[i]인 것들을 보고, dy[j] 최댓값을 찾아 max에 저장.  
   - dy[i]=max+1로 계산.

5. 최종 출력  
   - dy 배열에서 가장 큰 값이 최종 답이 된다.  
   - 예: dy=[1,1,2,3,2,1,4,2] → 최댓값=4 → 출력 4.
*/