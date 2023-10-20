'''
개념
1. 12_단지 번호 붙이기 문제: '단순 가지수' -> DFS
2. 13_섬나라 아일랜드: 8방향 + BFS
3. 4방향
	= dx = [-1, 0, 1, 0]
	= dy = [0, 1, 0, -1]
4. 8방향
	= dx = [-1, -1, 0, 1, 1, 1, 0, -1]
	= dy = [0, 1, 1, 1, 0, -1, -1, -1]
	= 상 우상 우 우하 하 좌하 좌 좌상
	= 시계방향
5. 해당 지점에서 BFS로 다 퍼져나갔으면 끝난 것!
'''
from collections import deque										# BFS는 deque 사용

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

cnt = 0
Q = deque()
for i in range(n):
	for j in range(n):
		if (board[i][j] == 1):										# 섬 찾았으면 시작
			board[i][j] = 0											# 8방향 다시 못 찾게 0으로 바꿈
			Q.append((i, j))										# 이제 시작지점에서 BFS 돌아야 하니까 Q에 넣어준다
			while (Q):
				tmp = Q.popleft()									# Q에서 하나 꺼내서 BFS
				for k in range(8):
					x = tmp[0] + dx[k]
					y = tmp[1] + dy[k]
					if (0 <= x < n and 0 <= y < n and board[x][y] == 1):	# 8방향 돌다가 섬 발견하면
						board[x][y] = 0								# Q에 담긴 것 다음 BFS 이동을 위한 0 설정
						Q.append((x, y))						 	# Q에 해당 좌표 넣어서, BFS 대비한다

			cnt += 1												# BFS 끝나면 섬(묶음) 하나 찾은 것이니까 cnt += 1
print(cnt)




'''
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

=
5
'''