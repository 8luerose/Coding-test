'''
해당 sec_7 12번 부터는 문제 먼저 풀도록 할 예정입니다
개념 정리의 경우 누락되오니 참고해주세요
'''
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x ,y):
	global cnt
	cnt += 1																# if (board[i][j] == 1) 일 때 DFS() 들어갔음. 따라서 cnt += 1
	board[x][y] = 0															# 방문한 곳은 0으로 바꿔주기 -> 왜? 4방향 돌면서 board[][] = 1 이면 '다시 나의 자리로 돌아올 수 있기 때문'
	for i in range(4):
		next_x = x + dx[i]
		next_y = y + dy[i]
		if (0 <= next_x < n and 0 <= next_y < n and board[next_x][next_y] == 1):
			DFS(next_x, next_y)




n = int(input())
board = [list(map(int, input())) for _ in range(n)]							# 1011 띄어쓰기 안 되어있는 거 한번에 받기
result = []

for i in range(n):
	for j in range(n):
		if (board[i][j] == 1):
			cnt = 0															# DFS 들어가기 전에 cnt 초기화
			DFS(i, j)
			result.append(cnt)												# cnt를 리스트에 넣어주기

print(len(result))
result.sort()
for x in result:
	print(x)


'''
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

=
3
7
8
9
'''