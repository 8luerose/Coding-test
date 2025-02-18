package section_08;
import java.util.*;

public class ex02 {
	static int C, N;
	static int answer = Integer.MIN_VALUE;

	public void DFS(int L, int sum, int[] arr) {
		if (sum > C) return;
		if (L == N) {
			answer = Math.max(answer, sum);
		}
		else {
			DFS(L + 1, sum + arr[L], arr);
			DFS(L + 1, sum, arr);
		}
	}
	public static void main(String[] args) {
		ex02 T = new ex02();
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		N = sc.nextInt();
		int[] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
259 5
81
58
42
33
61
=> 242

[입력값 설명]
- C = 259 (트럭의 제한 무게)
- N = 5 (바둑이의 수)
- 바둑이들의 무게: 81, 58, 42, 33, 61

[출력값 설명]
- 242 (트럭에 태울 수 있는 가장 무거운 무게)
- 실제로 242는 81 + 58 + 42 + 61로 만들어진 값
*/

/** 배울점
1. DFS에서 핵심 조건문의 동작 원리
   - if (sum > C) return:
     * '백트래킹'의 핵심 부분
     * sum이 C보다 커지는 순간 해당 경로는 더 이상 유효하지 않음
     * 예: sum = 275 (81+58+42+61+33) > C = 259 일 때
     * 이미 이 시점에서 무게를 초과했으므로 이후 어떤 선택을 하더라도 답이 될 수 없음
     * 따라서 즉시 중단하고 이전 분기점으로 되돌아감
     * ** 이 조건이 있어야만 다음 조건문에서 sum ≤ C 임을 보장받을 수 있음 **
   
   - if (L == N) { answer = Math.max(answer, sum); }:
     * '정답 갱신'의 핵심 부분
     * L == N은 모든 바둑이에 대한 '선택 완료'를 의미
     * 예: N=5일 때, [O,X,O,X,O] 같은 선택 조합이 완성된 상태
     * 이전 조건문에서 이미 sum ≤ C 임을 보장받았으므로
     * 이 시점의 sum은 '실현 가능한' 무게 조합
     * answer와 비교하여 더 큰 값으로 갱신
     * ** 이 조건문은 반드시 if (sum > C) 뒤에 위치해야 정확성 보장 **

2. 조건문 순서의 중요성
   - if (sum > C)가 먼저 체크되어야 하는 이유:
     * 무게 제한 있음 C보다 크면 안된다고 했음
     * 이를 만족하지 못하면 다른 조건을 볼 필요가 없음
     * 시간 복잡도 개선에 크게 기여
   
   - if (L == N)이 나중에 체크되어야 하는 이유:
     * 거를 거 거르고 (sum ≤ C)만 정답 후보로 고려
     * O,X 든 어쨌든 배열 조합 모두 하나씩 체크해봤으면 마지막 리프 노드까지 도달 -> Math.max() 판단 시점
*/

/* 해설
1. DFS 탐색 과정의 자세한 예시 (C=259일 때)
   [첫 번째 바둑이(81) 선택 O]
   - DFS(0, 0) → DFS(1, 81)
   - sum = 81 < C 이므로 계속 진행
   
   [두 번째 바둑이(58) 선택 O]
   - DFS(1, 81) → DFS(2, 139)
   - sum = 139 < C 이므로 계속 진행
   
   [세 번째 바둑이(42) 선택 O]
   - DFS(2, 139) → DFS(3, 181)
   - sum = 181 < C 이므로 계속 진행
   
   [네 번째 바둑이(33) 선택 X, 다섯 번째(61) 선택 O]
   - DFS(3, 181) → DFS(4, 181) → DFS(5, 242)
   - sum = 242 < C 이고 L == N 이므로 정답 갱신
   
   [다른 조합 시도 - 실패 예시]
   - 81+58+42+33+61 = 275
   - sum = 275 > C 이므로 즉시 return
   - 이 경로는 더 이상 탐색하지 않음

2. 정답 도출 과정
   - 가능한 모든 조합 중 가장 큰 값을 찾음
   - 242(81+58+42+61)가 C(259)를 넘지 않는 최대값
   - 다른 모든 가능한 조합들은 242보다 작거나, C를 초과

3. 최적화 포인트
   - 첫 번째 조건문으로 불가능한 경우를 빠르게 가지치기
   - 두 번째 조건문에서는 실현 가능한 경우만 처리
   - L과 N의 비교로 모든 선택이 완료된 시점 정확히 포착
*/