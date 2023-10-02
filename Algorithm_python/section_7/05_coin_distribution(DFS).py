'''
개념
1. DFS 같다? '상태트리로 구한다' -> 코드 구현
2. money = [0] * n
	= 예시: money = [A][B][C] 이렇게 세명
3. for i in range(3):
	= D(L) 에서 시작해서 money[i]인 0 1 2 중 누구에게 금액을 줄것인가 정한다
	= 예시로 0번에게 준다고 하면, money[i] += 8
	= D(L + 1)로 가서 또 for 돌면서 누구한테 금액을 줄지 말지 정한다
4. 주의
	= back 을 하면 money[0] -= 8 이런 식으로 해줘야 한다
	= 왜? D(L + 1)로 가서 또 for 돌면서 누구한테 금액을 줄지 말지 정해야 하니까
	= 빼앗고 money[1] += 8 이런 식으로 해줘야 한다
5. base case
	= if (L == n):


'''
def DFS(L):
	global result
	if (L == n): 							# base case: 0 ~ n-1 coin 전부다 나눠줬다면 종착점
		diff = max(money) - min(money)		# 해당 경우[A][B][C] 다 담은 최대값 - 최소값 = 차
		if (diff < result):					# 차가 최소값보다 작다면 갱신
			tmp = set()						# set() = 중복을 허용하지 않는다. 중복 제거
			for x in money:
				tmp.add(x)					# tmp에 money를 넣는다
			if (len(tmp) == 3):				# tmp에 3개가 들어있다면, 중복이 없다면
				result = diff				# 갱신
	
	else:
		for i in range(3):
			money[i] += coin[L]				# coin[L]: 해당레벨 = 8(0),9(1),11(2).. n번째 입력값
			DFS(L + 1)						# 다음 레벨로 가서 또 for 돌면서 누구한테 금액을 줄지 말지 정한다
			money[i] -= coin[L]				# 이 줄에 도착했다? DFS끝나고 back 한 상황. back을 하면 money[0] -= 8 이런 식으로 해줘야 한다


n = int(input())
coin = []
money = [0] * n
result = 2147000000							# 최소값(총액이 가장 큰 사람 - 작은 사람)을 구해야 하니까, 최대값으로 초기화

for _ in range():
	coin.append(int(input()))				# 왜 이렇게 할까? 엔터치면서 coin을 받기 때문
DFS(0)

'''
7
8
9
11
12
23
15
17
=
5
'''