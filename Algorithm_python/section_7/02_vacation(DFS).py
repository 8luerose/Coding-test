'''
개념

1. 문제는, 'N + 1일 째 되는 날 종료된다. 그 전에 최대한 많은 상담을 해서 최대 수익을 구하라' 이다.
2. 상태트리로 구한다
3. 상태트리는, '상담을 할 것인가, 말 것인가' 두 가지 갈래로 뻗어나간다
	= DFS(한다) \n DFS(하지 않는다) == (했을때 -> 한다 or 했을 때 -> 하지 않는다) || (안 했을때 -> 한다 or 안 했을 때 -> 하지 않는다)
4. 포인트 '인덱스 번호를 날짜로 사용하겠다'
	= 1일부터 시작하니까, 처음에 리스트 .append() 하고 -> .insert(0, 0) 해준다
	= 이렇게 하면 0번 인덱스에 0이 들어가고, 1번 인덱스부터 1일부터 시작하게 된다
	= 1일부터 시작하므로 DFS(1, 0)이 된다
	= DFS(L, sum) == L: 날짜, sum: 수익
5. 포인트 'base case는 L == n + 1이다'
	= if (L == n + 1):
6. 포인트 '갈래를 뻗어나가려는데, 상담일이 n + 1(종료일)을 넘어가면 안된다'
	= else:
	=	 if (L + T[L] <= n + 1):	# 상담일이 n + 1(종료일)을 넘어가면 안된다
	= ex) 7일째 종료되어야 하는데, 상담 마친 기간이 8일이면 ㄴㄴ 안됨. 이게 아닐 때만 상담하자~
7. 상담을 한다, 안한다 두 가지 갈래로 뻗어나간다
	= if (L + T[L] <= n + 1):				상담을 한다 (상담일이 n + 1(종료일)을 넘어가면 안될때만)
	=		DFS(L + T[L], sum + P[L])		
	= DFS(L + 1, sum)						상담을 안한다
'''
def DFS(L, sum):
	global result
	if (L == n + 1):						# base case
		if (sum > result):					# 최대값 갱신 ->하고 마침
			result = sum					# 지역변수 result 찾는데 없다? -> 오류ㄴㄴ 전역변수 result 찾아서 갱신
	else :									# 갈래 뻗어나가기
		if (L + T[L] <= n + 1):				# 상담을 하려고 한다 (조건: 상담일이 n + 1(종료일)을 넘어가지 않을때만)
			DFS(L + T[L], sum + P[L])		# 시뮬레이션: 상담 끝난일, 그동안의 누적 수익
		DFS(L + 1, sum)						# 패스하고 상담을 안한다 ex) 1일째 패스하고 2일째부터 하자~

n = int(input())							# n = 상담을 할 수 있는 날짜 수
T = list()									# T = time. 상담에 걸리는 시간를 리스트로
P = list()									# P = pay. 상담하고 받는 금액을 리스트로

for i in range(n):
	a, b = map(int, input().split())
	T.append(a)		 	 					# 상담에 걸리는 시간를 리스트로
	P.append(b)								# 상담하고 받는 금액을 리스트로
result = -2147000000						# 최대값을 구해야 하니까, 최소값으로 초기화
T.insert(0, 0)								# 0번 인덱스에 0을 넣어준다. 1일부터 시작하니까
P.insert(0, 0)								
DFS(1,0)									# DFS(1,0)으로 시작. 1일부터 시작하니까
print(result)

'''
7
4 20
2 10
3 15
3 20
2 30
2 20
1 10
=
60
'''