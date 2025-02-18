package section_08;
import java.util.*;

public class ex01 {
	static String answer = "NO";
	static int N, arrSum = 0;
	static boolean flag = false;
	public void DFS(int L, int dfsSum, int[] arr) {
		if (flag == true) return;
		if (dfsSum > arrSum / 2) return;

		if (L == N) {
			if ((arrSum - dfsSum) == dfsSum) {
				answer = "YES";
				flag = true;
			}
		}
		else {
			DFS(L + 1, dfsSum + arr[L], arr);
			DFS(L + 1, dfsSum, arr);
		}
	}

	public static void main(String[] args) {
		ex01 T = new ex01();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arrSum += arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
6
1 3 5 6 7 10
=> YES

[입력값 설명]
- 첫 번째 줄: 원소의 개수 N = 6
- 두 번째 줄: N개의 원소 = 1 3 5 6 7 10

[출력값 설명]
- "YES" 출력: 두 부분집합 {1, 3, 5, 7} = {6, 10}으로 나누어 각각의 합이 16으로 동일
*/

/** 배울점
1. DFS 종료 조건 최적화
    - (1) flag를 통한 조기 종료: 이미 정답을 찾았다면 더 이상의 탐색이 불필요
    - 답을 찾은 후의 불필요한 재귀호출을 막아 실행시간 단축
    - static으로 선언하여 모든 재귀에서 동일한 flag 값 공유
	- (2) 기본 base case: if (L == N) 해서 마지막 N 레벨까지 갔으면 그동안 진행했던 DFS SUM 값을 확인한다
	- 이후에 answer 를 true로 바꿔주고, flag도 바꿔준다 -> dfs 아랫줄 x 케이스로 갔을 때도 flag 확인해서 return 시키는 용도

2. 가지치기(Pruning) 기법
    - if (dfsSum > arrSum / 2) return
    - 현재까지의 부분합이 전체 합의 절반보다 크면 더 진행할 필요가 없음
    - 시간복잡도를 O(2^n)에서 상당 부분 감소시키는 핵심 최적화

3. 상태트리 구현 방식
    - DFS(L + 1, dfsSum + arr[L], arr): 현재 원소를 선택하는 경우
    - DFS(L + 1, dfsSum, arr): 현재 원소를 선택하지 않는 경우
    - 이진트리 형태로 모든 부분집합의 경우의 수를 탐색

4. static 변수 활용
    - answer, N, arrSum을 static으로 선언
    - 재귀 호출 시마다 매개변수로 전달할 필요 없이 공통으로 사용 가능

---
5. if (flag == true) return 조건의 중요성
	DFS는 스택처럼 쌓이는데, 만약 return을 base case에서만 때리면,
	'DFS(L + 1, dfsSum + arr[L], arr)' 이 부분만 return으로 끝나고
	-> 'DFS(L + 1, dfsSum, arr)' 바로 아래 부분으로 넘어가게 됨
	= 따라서 어떤 DFS 순간에서도 가장 먼저 flag 확인해서, return 되어 아래로 넘어가더라도 -> 바로 return 계속 때릴 수 있게 하는 것임! ㅇㅇ

	예시: {1, 3, 5, 6, 7, 10}에서
	- 만약 {1,3,5,7}을 찾아서 합이 16인 것을 발견했다고 가정
	- flag가 없다면:
	L=4에서 {1,3,5,7} 발견 → YES 설정
	하지만 여기서 끝나지 않고:
	{1,3,5,7,10}, {1,3,5,6}, {1,3,5,6,7}, {1,3,5,6,7,10}...
	이런 식으로 불필요한 조합을 계속 검사

	- 시간복잡도 차이:
	flag 있을 때: 답 발견 즉시 O(1)로 종료
	flag 없을 때: 남은 모든 조합을 검사해야 함 → O(2^n)
---

---
6. dfsSum > arrSum / 2 조건의 중요성

	예시: {1, 3, 5, 6, 7, 10}의 전체 합은 32, 절반은 16

	- 이 조건이 없다면:
	{1,3,5,6,7} → 합이 22
	{1,3,5,6,7,10} → 합이 32
	이런 명백히 실패할 조합도 끝까지 탐색

	- 조건이 있을 때:
	{1,3,5,6} → 합이 15, 계속 진행
	{1,3,5,6,7} → 합이 22 > 16, 즉시 return
	7,10은 아예 시도하지 않음

	- 시간복잡도 개선:
	기존: 모든 부분집합 확인 O(2^n)
	가지치기 후: 합이 16 이하인 경우만 확인 
	예를 들어 {1,3,5,6,7}에서 7을 더하자마자 
	16을 넘어가므로 10은 시도조차 하지 않음
---

*/

/* 해설
1. 전체적인 접근 방법
    - 입력받은 배열의 모든 원소에 대해 '선택' 또는 '미선택' 두 가지 경우를 DFS로 탐색
    - 전체 합의 절반이 되는 부분집합이 존재하는지 확인
    
2. 핵심 구현 포인트
    - flag 변수: 답을 찾으면 true로 설정하여 추가 탐색 중단
    - dfsSum: 현재까지 선택한 원소들의 합
    - arrSum: 전체 배열의 합

3. 동작 과정 예시 (입력: 1 3 5 6 7 10)
    Level 0: 1을 선택할지 말지 결정
    Level 1: 3을 선택할지 말지 결정
    ...
    찾은 경우: {1,3,5,7} 선택 시 합이 16
              {6,10} 미선택 시 합이 16

4. 최적화 설명
    - "if (flag == true) return"
        * 이미 답(YES)을 찾았다면 더 이상의 탐색은 불필요
        * 예: {1,3,5,7}을 찾은 후 다른 조합은 확인할 필요 없음
    
    - "if (dfsSum > arrSum / 2) return"
        * 현재 합이 전체 합의 절반을 넘어가면 실패
        * 예: 1,3,5,7을 선택하여 이미 16(전체 합의 절반)을 넘어가면 탐색 중단

5. 두 최적화 조건의 차이점
    - flag는 "답을 이미 찾은 경우" 전체 종료
    - dfsSum 체크는 "가능성이 없는 경로" 조기 종료

6. base case
	- 최초에 if (L == N) - if ((arrSum / 2) == dfsSum) 라고 작성했으나, 이는 오답임
	- 홀수일 경우에 나머지는 무시되고, 몫 값만 따지기 때문임
	- 예를 들어 total(arrSum) 값이 125이고, dfsSum이 62라면 -> 125/2 == 62로써 62.5임에도 무시되고 몫만 판단됨
	- 따라서 그냥 /2 하지말고 (total(arrSum) - dfsSum == dfsSum) 하는 게 맞는듯!
*/