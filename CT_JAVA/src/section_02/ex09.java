package section_02;
import java.util.*;

class ex09 {
	public int solution(int n, int [][] arr) {
		int answer = Integer.MIN_VALUE;
		// 각 행, 각 열의 합 계산
		int sum1, sum2;
		for (int i = 0; i < n; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];							// 해당 행의 합
				sum2 += arr[j][i];							// 해당 열의 합
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}

		// 대각선 합 계산
		int sum3 = 0, sum4 = 0;
		for (int i = 0; i < n; i++) {
			sum3 += arr[i][i];								// 왼쪽 대각선
			sum4 += arr[i][n -1 - i];						// 오른쪽 대각선
		}
		answer = Math.max(answer, sum3);
		answer = Math.max(answer, sum4);

		// 각 행 + 각 열 + '두' 대각선 -> 최대값
		return (answer);
	}
	public static void main(String[] args) {
		ex09 T = new ex09();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
		sc.close();
	}
}

/** 입출력  
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
=> 155
*/

/** 배울점
1. 각 행의 합: sum1 += arr[i][j]; == [고정][행 이동]
2. 각 열의 합: sum2 += arr[j][i]; == [열 이동][고정]

3. 왼쪽 대각선: sum3 += arr[i][i]; == \
	- ex) 0,0 / 1,1 / 2,2 / 3,3 / 4,4 ... == 행,열 같이 증가

4. 오른쪽 대각선: sum4 += arr[i][n -1 -i]; == /
	- ex) 0,4 / 1,3 / 2,2 / 3,1 / 4,0 ... == [i][n -1 -i]
	- "n-1-i" == 행 제일 끝에서 점차 감소
	- "i" == 열 제일 처음부터 점차 증가

5. Math.max(,): 인자 2개 중 큰 수 반환
6. Integer.MIN_VALUE: 정수형의 최소값 반환
*/

/* 해설
1. 이중 for 돌려서 쉽게 해결
2. '두' 대각선의 합이라고 했고, 모든 대각선의 경우를 구하는 것이 아니다. == 대각선은 딱 두개

3. ** 풀이순서 **: sum1,2 행,열 먼저 for - for -> 그리고 sum3,4 대각선 -> 최대값 반환
4. '한 행열 씩' (= 한 for마다) 이동할 때마다 Math.max()로 최대값 갱신

5. 대각선 까먹지 말기! -> 왼쪽 대각선: [i][i] / 오른쪽 대각선: [i][n -1 -i]
	- i,i -> i+1,i+1 / n-l -0 -> n-1 -1
	- \ == 같이 증가
	- / == 행은 감소, 열은 증가
6. 대각선은 for 한번으로 가능!!
 */