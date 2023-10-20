'''
개념
1. 문제 푸는법
	= 먼저, board에 위치한 익은 토마토를 탐색한다
	= 탐색한 토마토를 Q에 넣는다
	= Q에서 하나씩 빼면서 상하좌우로 탐색한다
	= 만약 익은 토마토가 생기면, Q에 넣는다
	= 1_동시에, board에 해당 좌표 1로 표기한다
	= 2_동시에, dis 배열에 날짜를 기록한다
	= 예를 들어 1,3 위치에 익은 토마토가 있으면, 'Q에 (1,3)을 넣고, dis[1][3] = 1'
**	= dis 배열에 넣을 때는 '부모값 + 1'
	= '전체적으로 상태트리로 뻗는다'고 생각하면 된다
	= 서로 다른 위치에서 시작했다고 해서 서로다른 Q에 들어가는 것이 아니다
	= 부모값 + 1에 주목하자, 서로 다른 위치에서 시작했으니 Q에 들어가는 순서는 앞이거나 뒤일 수 있다.
**	= 하지만, 부모값 + 1이라는 점에서 같은 날짜(동시에)에 익는다 고 볼수 있다

2. 전체적인 요약
	= Q에서 pop
	= pop한 좌표 1에서 0으로 향하고, board[] = 0->1 로 변함
	= Q에 1로 변환한 해당 좌표 넣어준다
	= 동시에, dis 배열에 부모값 + 1
	= 반복

	= Q 꺼내고 -> 4방향 탐색 -> 발견 -> (board[][] = 1 중복 방지 -> dis 배열 표기 -> 배열 표기끝나면, 이제 Q에 넣기)

3. 주의
	= 열, 행 순
'''
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())										# n: 열(세로), m: 행(가로)
board = [list(map(int, input().split())) for _ in range(m)]				# m 만큼 받는다 == 행만큼 받는다

dis = [[0] * n for _ in range(m)]										# m x n 만큼 dis 배열 0으로 초기화
Q = deque()
for i in range(m):
	for j in range(n):
		if (board[i][j] == 1):
			Q.append((i, j))


while (Q):
	tmp = Q.popleft()
	for i in range(4):
		xx = tmp[0] + dx[i]
		yy = tmp[1] + dy[i]
		if (0 <= xx < m and 0 <= yy < n and board[xx][yy] == 0):  		# board[][] 해당 좌표가 '안익으면 토마토일 경우 == 0'
			board[xx][yy] = 1											# 해당 위치 갈거니까 0 -> 1로 변환
			dis[xx][yy] = dis[tmp[0]][tmp[1]] + 1						# 부모값 + 1
			Q.append((xx, yy))

flag = 1
for i in range(m):
	for j in range(n):
		if (board[i][j] == 0):                							# 안 익은 토마토 하나라도 있으면 안된다! -> 왜? 모두 익어야 한다했기 때문
			flag = 0													# 만약에, 안 익은 토마토 하나라도 있으면 토마토가 익지 못하는 상황이므로 flag = 0

result = 0
if (flag == 1):															# flag = 1이면 모두 익은 상황 <-> flag = 0이면 안 익은 토마토가 하나라도 있는 상황
	for i in range(m):
		for j in range(n):
			if (dis[i][j] > result):									# 토마토가 '모두 익을 때까지의 날짜' dis 배열에서 '가장 큰 값이 모두 익은 날짜'
				result = dis[i][j]										# dis 배열 다 돌면서 토마토가 모두 익은 날짜를 갱신해준다
	
	print(result)
else:																	# 안 익은 토마토가 하나라도 있으면 flag = 0 이므로, -1 출력
	print(-1)

'''
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
=
4

'''