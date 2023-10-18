'''
개념
1. "경로가 몇 가지인지 구하시오"
	= DFS
2. "그 구역의 위, 아래, 왼쪽, 오른쪽 중 더 높은 구역으로만 이동"
	= 나보다 높아? 현재 위치보다 높은 곳만 갈 수 있다는 뜻
3. 다 막히면 DFS 종료
	= back 하기 전에 체크 해제
**	= 체크 - DFS() - 체크 해제													# 대칭 구조!!
4. dx, dy
	= dx = [-1, 0, 1, 0]
	= dy = [0, 1, 0, -1]
	= 12 -> 3 -> 6 -> 9 시계방향
5. DFS base case
	= if (x == 도착지점x and y == 도착지점y):
	= cnt += 1

6. 문제 해석
	= 미로탐색(DFS 경로까지 가지수)과 동일+ 현재 위치보다 (시계방향으로 돌았을 때) 높은 곳만 갈 수 있다
	= 최초에, '맵에서 제일 낮은 지점 - 제일 높은 지점' 찾아야 한다
7. 미로탐색 문제와의 대표적인 차이점
	= 등산경로 문제: '현재 위치보다 높은 곳만 갈 수 있다'  <-> 미로탐색: 단순 가지수
	= if ( (0 <= next_x <= n - 1) and (0 <= next_y <= n - 1) 				# 벽 내부에 있고
**	= and (board[next_x][next_y] > board[x][y]) 							# 현재 위치보다 높은 곳만 갈 수 있다
	= and (check[next_x][next_y] == 0) ):									# 방문한 적 없을 때만
	=	):
	
	= 최초에 맵 중 max, min 구해줘야 한다
	= for i in range(n):
	= 	tmp = list(map(int, input().split()))								# 한 줄씩 받아주고
	= 	for j in range(n):
	= 		if (tmp[j] > max):
	= 			max = tmp[j]
*	= 		    start_x = i													# 시작지점 x
*	= 		    start_y = j													# 시작지점 y
	= 		if (tmp[j] < min):
	= 			min = tmp[j]
*	= 		    end_x = i
*	= 		    end_y = j
**	= board[i][j] = tmp[j]													# 맵에 넣어준다 -> 한줄 중에 하나씩

'''
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
	global cnt
	if (x == end_x and y == end_y):
		cnt += 1
	else:
		for k in range(4):
			next_x = x + dx[k]
			next_y = y + dy[k]
			if (0 <= next_x < n and 0 <= next_y < n and check[next_x][next_y] == 0 and board[next_x][next_y] > board[x][y]):
				check[next_x][next_y] = 1
				DFS(next_x, next_y)
				check[next_x][next_y] = 0



# if __name__ == "__main__":
n = int(input())
board = [[0] * n for _ in range(n)]
check = [[0] * n for _ in range(n)]

max = -2147000000
min = 2147000000

for i in range(n):
	tmp = list(map(int, input().split()))									# 한 줄씩 받아주고
	for j in range(n):														# 한 줄 중 하나씩
		if (tmp[j] > max):
			max = tmp[j]
			end_x = i
			end_y = j
		if (tmp[j] < min):
			min = tmp[j]
			start_x = i
			start_y = j
		board[i][j] = tmp[j]												# 맵에 넣어준다 -> 한줄 중에 하나씩

cnt = 0
check[start_x][start_y] = 1													# DFS() 전에 시작 지점 체크하고 시작한다
DFS(start_x, start_y)
print(cnt)

'''
5
2 23 92 78 93
59 50 48 90 80
30 53 70 75 96
94 91 82 89 93
97 98 95 96 100

=
5
'''