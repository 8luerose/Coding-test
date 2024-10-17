package section_02;
import java.util.*;

class ex11 {
	public int solution(int n, int [][] arr) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= 5; k++) {
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if (cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		return (answer);
	}
	public static void main (String[] args) {
		ex11 T = new ex11();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[n + 1][6];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
		sc.close();
	}
}

/** 입출력
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2
=> 4
*/

/** 배울점
1. 2차원 배열 만들 때, new int[n+1][6]의 의미는?
	- 예를 들어, 5x5 배열을 만들 때, 5x5 배열이 아니라 6x6 배열을 만든다
	- 왜냐하면, 0행, 0열을 사용하지 않고, 1행, 1열부터 사용하기 때문
	- [1][1] 부터 시작하기 위함이라는 뜻!
	- 그럼 왜 이렇게 하냐? '[n번학생][n학년]'을 위함

2.max = Integer.MIN_VALUE 로 초기화
	- max를 Integer.MIN_VALUE로 하면 (-2147483648) 무조건 처음 cnt보다 큼
*/

/* 해설
1. 2차원 배열 만들 때, new int [n명][n학년]을 위해,
	- 실제인원을 위해 인덱스보다 큰 [n+1], 실제학년 수를 위해 제시된 5학년보다 큰[6] 으로 한다

2. *핵심 로직*
	- '쟤랑 같은 반이었던 사람있어?'
	- '너 1~5학년까지 각각 무슨 반이었어?' -> '나랑 같은 반이었던 적 있어?' 를 위해 [i][k] == [j][k]로 둔다
	- [i번학생 기준][1~5학년] 과 [j번학생 기준][1~5학년]으로 비교해서 같은 반이었던 적 있으면 cnt++
	- 즉, (세로방향)행은 '몇 번째 학생'인지, (가로방향)열은 '몇 학년'인지를 나타내므로 '한 행의 열 변천사를 보면 된다'
	- ex) [1번][1~5학년] / [2번][1~5학년] / [3번][1~5학년] ... 이런식으로 한 줄씩 내려가면서 가로 방향으로 비교한다

3. break
	- '너 1~5학년까지 나랑 한 번이라도 같았던 반이었던 적있어?' 있으면 PASS해~
	- 다만, cnt 초기화는 이루어지지 않는다. cnt 초기화는 'i번째 학생에 대한 비교'가 끝나면 이루어진다
	- ex) "선생님 1번부터 5번까지 학생 중에[i][k] == [j][k], 'i번 학생이랑 같은 반이었던 사람 cnt명'이래요~"
	- 따라서 cnt 초기화는 'i번째 학생에 대한 비교'가 끝나면 이루어진다 (== for(i) 회차 끝나면)
*/