package section_08;
import java.util.*;

public class ex06 {
	static int N, M;
	static int[] arr;
	static int[] check, result;
	public void DFS(int L) {
		if (L == M) {
			for (int x : result) System.out.print( x + " " );
			System.out.println();
		}
		else {
			for (int i = 0; i < N; i++) {
				if (check[i] == 0) {
					check[i] = 1;
					result[L] = arr[i];
					DFS(L + 1);
					check[i] = 0;
				}
			}
		}

	}
	public static void main(String[] args) {
		ex06 T = new ex06();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		check = new int[N];
		result = new int[M];
		T.DFS(0);
		sc.close();
	}
}
/** 입출력
▣ 입력
3 2
3 6 9

▣ 출력
3 6
3 9
6 3
6 9
9 3
9 6
*/

/** 배울점
1. DFS를 통한 순열 생성 원리
   - DFS 함수는 재귀적으로 호출되어, 깊이 L이 M에 도달하면 result 배열에 저장된 하나의 순열을 출력함.
   - result 배열은 현재까지 선택된 원소들을 순서대로 저장하며, check 배열은 arr 배열의 각 원소가 이미 사용되었는지를 관리함.

2. for 루프를 통한 원소 선택 및 재귀 호출
   - for (int i = 0; i < N; i++) 반복문은 현재 DFS 호출 단계에서 사용 가능한 모든 원소를 후보로 시도함.
   - if (check[i] == 0) 조건으로 아직 사용되지 않은 원소만 선택하여 result[L]에 할당.
   - 선택 후 DFS(L + 1)을 호출하여, 다음 위치에 대해 같은 과정을 반복하며 순열을 완성함.
   - DFS 호출 후에는 check[i] = 0으로 상태를 복원(백트래킹)하여 다른 경로에서도 해당 원소를 사용할 수 있게 함.

3. DFS 흐름 예시: result와 check 배열의 역할
   - 초기 상태 (N=3, M=2):  
       result = [ , ]  
       check = [0, 0, 0]
   - 첫 번째 경로:
       * DFS(0): for 루프 i=0 선택  
         → result[0] = 3, check = [1, 0, 0]
       * DFS(1): for 루프에서 i=1 선택  
         → result[1] = 6, check = [1, 1, 0]
       * DFS(2): L==M, 출력 "3 6"
       * Backtracking: DFS(1)에서 check[1] 복원 → check = [1, 0, 0]
   - 두 번째 경로:
       * DFS(1) 계속: for 루프에서 i=2 선택  
         → result[1] = 9, check = [1, 0, 1]
       * DFS(2): L==M, 출력 "3 9"
       * Backtracking: DFS(1)에서 check[2] 복원, 그리고 DFS(0)에서 check[0] 복원
   - 이후 DFS(0)에서 i=1, i=2를 선택하면서 [6,3], [6,9], [9,3], [9,6] 등의 모든 순열이 탐색되고 출력됨.
*/

/* 해설
[전체 동작 원리 및 DFS 흐름 상세 분석]
1. main 함수
   - 사용자로부터 순열 생성을 위한 자연수 N과 M, 그리고 N개의 원소(예: 3, 6, 9)를 입력받음.
   - 입력받은 원소들을 arr 배열에 저장하며, check 배열은 각 원소의 사용 여부를 0(미사용)으로 초기화.
   - result 배열은 길이 M으로 순열의 결과를 저장할 공간으로 할당됨.
   - DFS(0)을 호출하여, 깊이 0부터 순열 탐색을 시작함.

2. DFS 함수의 구조 및 작동 방식
   - Base Case: if (L == M)
       * DFS 함수의 깊이가 M에 도달하면, 현재까지 result 배열에 저장된 순열이 완성된 것으로 간주하고 이를 출력함.
   - Recursive Case:
       * for (int i = 0; i < N; i++) 반복문을 통해, arr 배열의 각 원소를 현재 위치(L)에 배치할 후보로 시도함.
       * if (check[i] == 0) 조건을 만족하는 경우에만, 해당 원소가 아직 사용되지 않았음을 확인하고 다음 단계를 진행함.
           - check[i] = 1로 설정하여, arr[i]가 현재 순열에 사용 중임을 표시.
           - result[L] = arr[i]로 현재 위치에 arr[i]를 배치.
           - DFS(L + 1)을 호출하여, 다음 위치(L+1)에서 같은 과정을 반복.
       * DFS 호출이 완료되면, 해당 재귀 단계에서 사용했던 원소의 상태를 check[i] = 0으로 복원(백트래킹)하여,
         다른 순열 조합에서도 해당 원소를 사용할 수 있도록 함.

3. DFS 흐름 예시 (N=3, M=2)
   - 초기 상태:  
       result = [ , ]  
       check = [0, 0, 0]
   - 경로 1:
       * DFS(0): i=0 선택 → result[0] = 3, check becomes [1, 0, 0]
       * DFS(1): i=1 선택 → result[1] = 6, check becomes [1, 1, 0]
       * DFS(2): 깊이가 M(2)에 도달 → 출력: "3 6"
       * Backtracking: DFS(1) 후 check[1]를 0으로 복원 → check = [1, 0, 0]
   - 경로 2:
       * DFS(1) 계속: i=2 선택 → result[1] = 9, check becomes [1, 0, 1]
       * DFS(2): 깊이가 M(2)에 도달 → 출력: "3 9"
       * Backtracking: DFS(1) 후 check[2] 복원, 그리고 DFS(0) 후 check[0] 복원
   - 경로 3:
       * DFS(0): i=1 선택 → result[0] = 6, check becomes [0, 1, 0]
       * DFS(1): i=0 선택 → result[1] = 3, check becomes [1, 1, 0]
       * DFS(2): 출력: "6 3"
       * Backtracking 후 다른 후보 선택 → i=2 선택, 출력: "6 9"
   - 경로 4:
       * DFS(0): i=2 선택 → result[0] = 9, check becomes [0, 0, 1]
       * DFS(1): i=0 선택 → result[1] = 3, check becomes [1, 0, 1]
       * DFS(2): 출력: "9 3"
       * Backtracking 후 → i=1 선택, 출력: "9 6"
4. 결론
   - 이 DFS와 백트래킹의 조합은 모든 가능한 순열을 체계적으로 탐색하면서, 
     중복 사용을 방지하기 위해 check 배열을 사용하고, 각 재귀 호출 후 상태를 복원함으로써
     효율적으로 순열을 생성하는 방법임.
   - result 배열은 각 DFS 호출 단계에서 현재까지 완성된 순열의 상태를 기록하는 핵심 역할을 함.
   - check 배열은 각 원소가 이미 사용되었는지를 관리하여, 동일한 원소가 중복되어 선택되는 것을 막음.
*/
