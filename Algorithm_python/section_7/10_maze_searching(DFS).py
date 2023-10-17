'''
개념

1. 방법의 수 = DFS  <-> 최단 거리 = BFS
2. DFS는 'back'하는 게 특징인데, 이때 '방문 체크'는 다시 풀어준다
	= 체크 - DFS() - 체크 해제
3. DFS는 if - else
	= if (L == m):
	= else: for i in range(1, n + 1):
4. DFS는 재귀 함수
	= 따라서 새로운 함수를 만들어줘야 한다
'''
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
	global cnt															# cnt는 함수 밖에 있는 변수로, 전역 변수 처리해서 가져온다
	if (x == 6 and y == 6):
		cnt += 1
	else:
		for i in range(4):
			next_x = x + dx[i]
			next_y = y + dy[i]
			if ( (0 <= next_x <= 6) and (0 <= next_y <= 6) and (board[next_x][next_y] == 0) ):
				board[next_x][next_y] = 1
				DFS(next_x, next_y)
				board[next_x][next_y] = 0								# DFS 끝 -> 방금꺼 '미리' 방문 체크 해제


if __name__ == "__main__":
	board = [list(map(int, input().split())) for _ in range(7)]
	cnt = 0

	board[0][0] = 1														# DFS 전 '첫 시작점' 방문 미리 체크
	DFS(0, 0)
	print(cnt)

'''
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

=
8
'''