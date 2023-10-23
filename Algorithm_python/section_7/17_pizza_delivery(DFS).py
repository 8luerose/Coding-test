'''

'''
def DFS(L, s):													# L: level, s: start
	global result
	if (L == m):
		sum = 0
		for j in range(len(house)):
			x1 = house[j][0]
			y1 = house[j][1]
			dis = 2147000000
			for x in combination:
				x2 = pizza[x][0]
				y2 = pizza[x][1]
				dis = min(dis, abs(x1 - x2) + abs(y1 - y2))
			sum += dis
		if (sum < result):
			result = sum
		
	else:
		for i in range(s, len(pizza)):
			combination[L] = i
			DFS(L + 1, i + 1)


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
house = []
pizza = []
combination = [0] * m											# Pizza C m 개의 피자집이 선택됐을 때 조합

for i in range(n):
	for j in range(n):
		if (board[i][j] == 1):
			house.append((i, j))
		if (board[i][j] == 2):
			pizza.append((i, j))

result = 2147000000												# 최소 피자배달 거리
DFS(0, 0)
print(result)

'''
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
=
6
'''