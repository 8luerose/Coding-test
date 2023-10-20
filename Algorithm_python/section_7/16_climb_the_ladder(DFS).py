'''
개념
1. 문제 풀이
	= 마지막 9번 '도착 지점'에 열을 탐색하면 된다
	= 2가 발견되면 '거기서 부터 역으로 DFS'
	= 0번행으로 왔을 때 '그때의 열 번호가 정답'
	= if (x == 0) - print(y)

	= 맨 마지막 9행 쭉 돌면서 2발견하면 좌,우 살핀다 -> 없으면 위로 -> 있으면 그 방향으로 이동 + check[][] = 1 -> 이동하다가 x == 0이면 그때의 y출력

2. 주의
	= 행 고정, 열만 이동
	= if (board[9][y] == 2): - DFS(9, y)
'''
def DFS(x, y):
	check[x][y] = 1
	if (x == 0):
		print(y)
	else:
		if (y - 1 >= 0 and board[x][y - 1] == 1 and check[x][y - 1] == 0):				# 좌
			DFS(x, y - 1)
		elif (y + 1 < 10 and board[x][y + 1] == 1 and check[x][y + 1] == 0):			# 우
			DFS(x, y + 1)																
		else :																			# 좌(x) 우(x) -> 위(o)
			DFS(x - 1, y)



board = [list(map(int, input().split())) for _ in range(10)]
check = [[0] * 10 for _ in range(10)]
for y in range(10):
	if (board[9][y] == 2):
		DFS(9, y)



'''
1 0 1 0 0 1 0 1 0 1
1 0 1 1 1 1 0 1 0 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 1 0 1 1 1
1 0 1 0 0 1 0 1 0 1
1 0 1 1 1 1 0 1 0 1
1 0 1 0 0 1 0 1 1 1
1 1 1 0 0 1 0 1 0 1
1 0 1 0 0 1 1 1 0 1
1 0 1 0 0 2 0 1 0 1
=
7
'''