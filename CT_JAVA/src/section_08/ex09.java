package section_08;
import java.util.*;

public class ex09 {
	static int N, M;
	static int[] combi;
	public void DFS(int L, int start) {
		if (L == M) {
			for (int x : combi) System.out.print( x + " ");
			System.out.println();
		}
		else {
			for (int i = start; i <= N; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}
	public static void main(String[] args) {
		ex09 T = new ex09();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		combi = new int[M];
		T.DFS(0, 1);
		sc.close();
	}
}
/** 입출력
4 2
=>
1 2
1 3
1 4
2 3
2 4
3 4
*/

/** 배울점
1. 조합 생성의 재귀적 접근
   - 이 코드는 1부터 N까지의 숫자 중 M개를 선택하는 모든 조합을 생성
   - DFS(깊이 우선 탐색)를 사용해 재귀적으로 구현
   - 기본 아이디어:
     * L: 현재 몇 번째 숫자를 채우고 있는지 (레벨)
     * start: 선택 가능한 숫자의 시작점
     * combi 배열에 숫자를 하나씩 채우며 조합 완성

2. "for (int i = start; i <= N; i++)"의 역할 상세 분석
   - 이 for 루프는 현재 레벨(L)에서 선택할 수 있는 숫자들을 순회
   - start부터 시작하는 이유:
     * 이전에 선택한 숫자보다 큰 숫자만 선택 → 중복 방지 및 오름차순 보장
   - 예: N=4, M=2일 때
     * L=0, start=1: i=1,2,3,4 가능
     * i=1 선택 후 DFS(1,2) 호출 → L=1, start=2: i=2,3,4 가능
   - 동작 과정:
     * combi[L] = i로 현재 숫자 저장
     * DFS(L+1, i+1)로 다음 레벨로 이동, start를 i+1로 증가시켜 중복 제거

3. 재귀 호출의 전체 흐름 (N=4, M=2 기준)
   - DFS(0,1) 시작:
     * L=0, start=1
     * for i=1 to 4:
       - i=1: combi[0]=1, DFS(1,2)
         * L=1, start=2
         * for i=2 to 4:
           - i=2: combi[1]=2, L=2==M → 출력 "1 2"
           - i=3: combi[1]=3, L=2==M → 출력 "1 3"
           - i=4: combi[1]=4, L=2==M → 출력 "1 4"
       - i=2: combi[0]=2, DFS(1,3)
         * L=1, start=3
         * for i=3 to 4:
           - i=3: combi[1]=3, L=2==M → 출력 "2 3"
           - i=4: combi[1]=4, L=2==M → 출력 "2 4"
       - i=3: combi[0]=3, DFS(1,4)
         * L=1, start=4
         * for i=4 to 4:
           - i=4: combi[1]=4, L=2==M → 출력 "3 4"
       - i=4: combi[0]=4, DFS(1,5) → i<=N 조건 불만족, 종료

4. 종료 조건의 동작
   - "if (L == M)"은 조합이 완성된 시점을 체크
   - M개의 숫자를 모두 채웠을 때 combi 배열 출력
   - 예: combi=[1,2]가 완성되면 "1 2" 출력 후 개행
   - 이후 재귀가 종료되며 이전 레벨로 돌아감
*/

/* 해설
1. 전체적인 동작 원리 상세 설명
   - 이 프로그램은 1부터 N까지의 숫자 중 M개를 선택하는 모든 조합을 사전순(오름차순)으로 출력
   - 동작 과정:
     1) main에서 N, M 입력 (예: 4, 2)
     2) combi 배열을 M 크기로 초기화 (int[M])
     3) DFS(0,1) 호출로 조합 생성 시작
     4) 재귀적으로 숫자를 하나씩 선택하며 combi 채움
     5) L==M에 도달하면 조합 출력
     6) 모든 경우 탐색 후 종료
   - DFS는 깊이 우선 탐색으로, 한 경로를 끝까지 탐색 후 백트래킹

2. "for (int i = start; i <= N; i++)"의 중심적 역할
   - 이 루프는 조합 생성의 핵심
   - 각 레벨에서 선택 가능한 숫자를 순차적으로 탐색
   - 상세 동작 (N=4, M=2):
     * DFS(0,1):
       - i=1: combi[0]=1, DFS(1,2)
         * i=2: combi[1]=2 → "1 2"
         * i=3: combi[1]=3 → "1 3"
         * i=4: combi[1]=4 → "1 4"
       - i=2: combi[0]=2, DFS(1,3)
         * i=3: combi[1]=3 → "2 3"
         * i=4: combi[1]=4 → "2 4"
       - i=3: combi[0]=3, DFS(1,4)
         * i=4: combi[1]=4 → "3 4"
   - start 증가로:
     * 중복 선택 방지 (예: "2 1" 불가)
     * 사전순 출력 보장 (1→2, 1→3 등)

3. 재귀 트리와 백트래킹 이해
   - 재귀 호출은 트리 구조를 형성:
     * 루트: DFS(0,1)
     * 1단계: i=1,2,3,4 분기
     * 2단계: 각 분기에서 남은 숫자 탐색
   - 백트래킹:
     * L==M 도달 후 출력하고 이전 레벨로 복귀
     * combi[L] 값을 덮어쓰며 다음 경우 탐색
   - 예: "1 2" 출력 후:
     * L=1로 돌아와 i=3으로 진행 → "1 3"

4. 입력값(4,2)에 대한 분석
   - N=4, M=2는 4개 중 2개를 뽑는 조합
   - 총 경우의 수: 4C2 = 6
   - 코드가 정확히 6줄 출력:
     * 1 2, 1 3, 1 4, 2 3, 2 4, 3 4
   - 각 줄은 오름차순이며, 모든 조합 포함
*/