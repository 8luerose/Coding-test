'''
해당 버전은 BFS Ver.
'''
import sys
from collections import deque

sys.setrecursionlimit(10 ** 6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

def BFS(x, y, h):
    queue = deque()
    queue.append((x, y))
    check[x][y] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if (0 <= xx < n and 0 <= yy < n and check[xx][yy] == 0 and board[xx][yy] > h):
                check[xx][yy] = 1
                queue.append((xx, yy))

result = 0
cnt = 0
for h in range(100):	
    check = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if (check[i][j] == 0 and board[i][j] > h):
                cnt += 1
                BFS(i, j, h)
    result = max(result, cnt)
    if (cnt == 0):
        break

print(result)


'''
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
=
5
'''