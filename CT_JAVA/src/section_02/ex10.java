package section_02;
import java.util.*;

class ex10 {
	int [] dx = {-1, 0, 1, 0};
	int [] dy = {0, 1, 0, -1};
	public int solution(int n, int [][] arr) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = true;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
						arr[nx][ny] >= arr[i][j]) {
							flag = false;
							break;
					}
				}
				if (flag == true) cnt++;
			}
		}
		return (cnt);
	}

	public static void main(String[] args) {
		ex10 T = new ex10();
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
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
=> 10
 */

 /** 배울점
1. 2차원 배열 탐색방법
	- dx: x축 이동 방향 == {-1, 0, 1, 0}
	- dy: y축 이동 방향 == {0, 1, 0, -1}
	- 4방향 탐색은 'k' 값으로 같이 간다
2. int nx = i + dx[k]
	- nx: next x == 현재 i위치 + direction x[k]
	- ny: next y == 현재 j위치 + direction y[k]
3. 봉우리 기준: 나보다 '크거나 같으면' 안됨 == if (arr[nx][ny] >= arr[i][j]) - false & break
4. Bound Check
	- (1) 행이 0보다 작으면 ㄴㄴ == nx >= 0
	- (2) 행이 n보다 작아야함! == nx < n
	- 열 동일
*/

/* 해설
1. 2차원 배열 만들고, dx, dy 만들어서 사방향 탐색하는 문제
2. 나보다 크거나 같은 것이 있다면, 봉우리가 아니라고 판단하면 됨
3. 2차원 돌면서 + nx, ny로 다음 위치를 계산하고, 그 위치가 범위(Bound) 안에 있는지 확인
4. 총 4방향 이므로, k < 4 까지 확인해준다
5. 만약, 하나라도 인덱스를 벗어나거나 + arr[nx][ny] >= arr[i][j] 이면, 봉우리가 아니므로 flag 세워준다
6. 4방향 탐색 + if(Bound check) 회절 후, flag가 여전히 true 상태면 cnt++
 */