'''
개념
1. 노드 -> 간선 -> 그래프
	= (무방향) 그래프 -> 방향 그래프 -> 가중치 방향 그래프
2. 2차원 리스트를 이용해서 그래프를 표현할 수 있다.
	= 0이면 연결되지 않은 것, 1이면 연결된 것
	= 행열 순: 1 -> 2 갈 수 있다면 (1,2) 에 1 체크
	= arr[a][b] = 1 => arr[1][2] = 1 이런 식으로
3. [0] * (n + 1): 0 ~ n까지 생긴다
	= 왜냐? 0번 인덱스는 비워둔다
	= 노드가 1 ~ n까지 있으므로 1번부터 사용한다
	= for i in range(1, n + 1) 이런 식으로 만들어놓고 1부터 쓰면 그만이야~
**	= ex) arr = [[0] * (n+1) for _ in range(n + 1)]	

4. 인접행렬 만드는 법
	= for i in range(m):
	= 	a, b = map(int, input().split())
	= 	arr[a][b] = 1
	= 	arr[b][a] = 1
5. 방향 그래프 만드는법
	= for i in range(m):
	= 	a, b = map(int, input().split())
**	= 	arr[a][b] = 1	# a -> b
6. 가중치 방향 그래프 만드는법
	= for i in range(m):
**	=  	a, b, c = map(int, input().split())
**	= 	arr[a][b] = c	# a -> b, 가중치 c
'''
n, m = map(int, input().split())
arr = [[0] * (n + 1) for _ in range(n+1)]		# [0] * (n + 1): 1~N까지 노드가 있으므로 + 인덱스 0은 비워둔다
for i in range(m):								# m번의 걸쳐 '주어진'간선 정보(연결 정보)를 입력받는다
	a, b, c = map(int, input().split())
	arr[a][b] = c

for i in range(1, n + 1):						# 행렬(위에서 만들어둔 인접행렬) 출력
	for j in range(1, n + 1):
		print(arr[i][j], end = ' ')
	print()										# 다음행

'''
N = 노드 수
M = 간선 수 (m번의 걸쳐 간선 정보(연결 정보)를 입력받는다)
6 9  
1 2 7
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

=
0 7 4 0 0 0
2 0 5 0 5 0
0 0 0 5 0 0
0 2 0 0 5 0
0 0 0 0 0 0
0 0 0 5 0 0
'''