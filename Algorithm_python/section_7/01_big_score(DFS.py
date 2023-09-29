'''
개념
1. 상태 트리로 구한다
2. 다만, 점수 더한다 or 더하지 않는다 두 갈래씩 뻗어나갈 것이다
3. 이때, 점수를 더한다면, 더한 점수를 누적한다
4. 점수 더하지 않는다면 다음 가닥으로 넘어갈 것이다.
5. 끝까지 도착했다면(if L == M), 누적된 점수를 출력한다
6. 포인트
	= else :
			DFS(L + 1, sum + pv[L], time + pt[L])		# 문제를 풀었을 때: 점수 더한다면, 더한 점수를 누적한다
			DFS(L + 1, sum, time)						# 문제를 풀지 않았을 때: 점수 더하지 않는다면 다음 가닥으로 넘어갈 것이다.
'''
def DFS(L, sum, time):					# L = 노드 번호. sum = 누적 점수. time = 누적 시간
		global result
		if (time > m):					# 제한시간 m분 내로 풀어야 하므로 제약 조건
			return
		if(L == n):						# 끝까지 도착했다면
			if (sum > result):			# 누적 점수가 최대값보다 크다면
				result = sum			# 갱신해준다
		else :
			DFS(L + 1, sum + pv[L], time + pt[L])
			DFS(L + 1, sum, time)

n, m = map(int, input().split())
pv = list()								# pv = point value. 점수 리스트
pt = list()								# pt = point time. 시간 리스트
for i in range(n):
	a, b = map(int, input(). split())
	pv.append(a)						# 점수 리스트
	pt.append(b)						# 플리는시간
result = -21000000						# 최대값을 구해야 하니까, 최소값으로 초기화
DFS(0,0,0)								# DFS(0,0,0)으로 시작. 0번 노드부터 시작하니까
print(result)

'''
5 20
10 5
25 12
15 8
6 3
7 4
=
41
'''