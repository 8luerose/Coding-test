'''
개념
1. 단지번호 붙이기와 차이점
	= 단지번호: 한번 찾고 끝 -> check 배열 필요 없이 그냥 board[][]=0 == 덮어쓰기 가능(O)
	= 안전지대: 높이를 달리해서 안전영역 '계속 찾아준다' -> 별도의 check 배열 필요 == 덮어쓰기 불가능(X)
		= 높이가 정해지면 매번 check 배열 초기화 되어야 한다
2. if (cnt == 0):														# **이게 포인트** 0~100까지 모든 높이 돌아보면서 n x n 만들고, 맵 안 돌아봐도 돼. 언제까지?? '안전지대 못 찾을 때까지'(==높이가 높으면 물에 다 잠기니까 cnt = 0)

**
3. 재귀 Time Limit
	= 재귀 함수로 돌리는 문제일 때 Time Limit 발생할 수 있다
	= import sys - sys.setrecursionlimit(10 ** 6)						# <- 이거 추가해주면 된다
'''
import sys
sys.setrecursionlimit(10 ** 6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

def DFS(x, y, h):
	check[x][y] = 1															# 방문했으니까 그 xy 좌표 방문체크
	for i in range(4):
		xx = x + dx[i]
		yy = y + dy[i]
		if (0 <= xx < n and 0 <= yy < n and check[xx][yy] == 0 and board[xx][yy] > h):	# 벽 내부에 있고, 방문한 적 없고, 높이가 h보다 높은 곳만 갈 수 있다
			DFS(xx, yy, h)


result = 0
cnt = 0
# for h in range(1, 101):													# 1~100이거 아니야!!!!!!!!!!백준에선 (100)이어야 한다
for h in range(100):														# 높이가 0~99까지
	check = [[0] * n for _ in range(n)]										# 높이가 증가할 때마다 새로운 check 배열을 초기화 -> n x n
	cnt = 0
	for i in range(n):
		for j in range(n):
			if (check[i][j] == 0 and board[i][j] > h):						# board[][] > h == 높이가 'h보다 높은 곳'일 때 안전지대
				cnt += 1													# 안전지대 찾았다! -> 일단 그 주위 다 DFS로 돌아볼거니까 cnt++
				DFS(i, j, h)												# 그 주위를 DFS로 돌아준다
	result = max(result, cnt)											# 기존 result vs cnt 중 큰 것으로 갱신
	if (cnt == 0):														# **이게 포인트** 0~100까지 모든 높이 돌아보면서 n x n 만들고, 맵 안 돌아봐도 돼. 언제까지?? '안전지대 못 찾을 때까지'(==높이가 높으면 물에 다 잠기니까 cnt = 0)
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