package section_08;
import java.util.*;

public class ex03 {
	static int N, M;
	static int answer = Integer.MIN_VALUE;
	public void DFS (int L, int sum, int time, int[] scoreArr, int[] timeArr) {
		if (time > M) return ;
		if (L == N) {
			answer = Math.max(answer, sum);
		}
		else {
			DFS(L + 1, sum + scoreArr[L], time + timeArr[L], scoreArr, timeArr);
			DFS(L + 1, sum, time, scoreArr, timeArr);
		}

	}
	public static void main(String[] args) {
		ex03 T = new ex03();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] score = new int[N];
		int[] time = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
			time[i] = sc.nextInt();
		}
		T.DFS(0, 0, 0, score, time);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
5 20
10 5
25 12
15 8
6 3
7 4
=> 41 

[입력값 설명]
	- 첫 줄: N=5(문제 개수), M=20(제한시간)
	- 다음 N줄: 각 문제의 점수와 시간
	- 예) 첫 번째 문제는 10점, 5시간 소요
[출력값 설명]
	- 41: 제한시간(20) 내에 얻을 수 있는 최대 점수
	- 선택된 문제들: 10점(5시간) + 15점(8시간) + 6점(3시간) + 7점(4시간) = 41점(20시간)
*/

/** 배울점
1. DFS의 상태트리 설계
    - L: 문제 인덱스(깊이), sum: 누적 점수, time: 누적 시간
    - ** 상태트리가 2갈래로 뻗어나가는 이유: 각 문제를 '풀거나(O)' '안 풀거나(X)'의 선택을 해야 하기 때문 **
    - DFS(L+1, sum+score[L], time+time[L]): 현재 문제를 푸는 경우
    - DFS(L+1, sum, time): 현재 문제를 안 푸는 경우

2. 제한조건 처리
    - if (time > M) return: 시간 초과시 더 진행하지 않음
    - ** 시간 체크를 'time == M'이 아닌 'time > M'으로 하는 이유: 정확히 M시간을 사용하는 경우도 허용하기 위함 **

3. 최댓값 갱신 로직
    - static int answer = Integer.MIN_VALUE로 초기화하는 이유: 
      * 어떤 경우의 수든 첫 번째 완성된 조합과 비교가 가능하도록 함
      * Integer.MIN_VALUE는 가능한 가장 작은 정수값
    - Math.max(answer, sum): 새로운 조합의 점수와 기존 최댓값을 비교하여 더 큰 값을 선택
*/

/* 해설
1. 전체적인 접근 방법
    - 각 문제별로 풀지 않풀지 결정하는 이진트리 구조로 접근
    - 제한시간을 초과하지 않는 범위 내에서 가능한 모든 조합을 탐색
    - 끝까지 탐색(L == N)했을 때 최대 점수를 갱신

2. 구체적인 진행 과정 예시 (첫 번째 문제부터)
    [1] 첫 번째 문제(10점, 5시간)
        - O: sum=10, time=5로 다음 단계
        - X: sum=0, time=0로 다음 단계
    [2] 두 번째 문제(25점, 12시간)
        - O: 위 두 경우에서 각각 진행
        - X: 위 두 경우에서 각각 진행
    ...계속해서 모든 가능한 조합 확인

3. 최적해 도출 과정
    - 모든 가능한 조합을 확인하며 제한시간(20시간) 내의 최대 점수를 찾음
    - 예제의 경우 10+15+6+7=41점이 최적해
    - 시간은 5+8+3+4=20시간으로 제한시간에 정확히 맞음
*/