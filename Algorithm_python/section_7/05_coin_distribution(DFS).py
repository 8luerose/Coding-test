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
	= back 을 하면 money[i] -= 8 이런 식으로 해줘야 한다
	= 왜? D(L + 1)로 가서 또 for 돌면서 누구한테 금액을 줄지 말지 정해야 하니까
**	= 빼앗고 다시 for i 돌려서 money[i+1] += 8 이런 식으로 해줘야 한다
**	= 즉, for - (money[i] += 코인) - D(L + 1) - (money[i] -= 코인) 이런 식
5. base case
	= if (L == n):
		= diff = max(money) - min(money)
		= if (diff < result):
			= tmp = set()
**			= '세 사람의 총액은 서로 달라야 합니다' 문제에서 요구 -> set()해서 중복 제거 + 초기화

6. 핵심
	= if (L == n):				레벨 종착점은 모든 코인을 다 나눠줬을 때임 
								-> 왜? 밑에 tmp = set()에 for 돌려서 .add() 박으면서 길이 다르면 다 다르게 나눠줬구나 싶은거임
**								즉, 아~ 일단 모든 코인 다 나눠줬을 때까지로 가정하고 재귀 다해봐~~ 이따 set()으로 중복 len 체크하면 되잖어 라는 뜻!!!
		= if (diff < result):	해당 레벨까지 간 [A][B][C] 케이스의 최대 - 최소
			= tmp = set()		세 사람 받은 총액 다르니까 중복 제거 + 초기화
			= for x in money: 	money [A][B][C] 한 번씩 중복인지 확인해준다
				= tmp.add(x)	중복이 있으면 set()에 추가 안됨
**			= if (len(tmp) == 3):	이렇게 만들어진 set()에 길이가 만약 3이 아니라면 '중복돼서 뭔가 제거 됐다'는 뜻!
				= result = diff		아하~ 이건 중복이 없는 result구나~ 갱신!!

+ set()은 .add()로 추가한다 <-> 리스트는 .append()로 추가한다
'''
def DFS(L):
	global result
	if (L == n): 							# base case: 0 ~ n-1 coin 전부다 나눠줬다면 종착점
		diff = max(money) - min(money)		# 해당 경우[A][B][C] 다 담은 최대값 - 최소값 = 차
		if (diff < result):					# 차가 최소값보다 작다면 갱신
			tmp = set()						# set() = 세 사람 받은 총액 다르니까 중복 제거 + 초기화
			for x in money: 				# money = [0] * n 이었는데 이는 [A][B][C]를 담은 리스트
				tmp.add(x) 					# set()은 .add()로 추가한다 <-> 리스트는 .append()로 추가한다
			if (len(tmp) == 3):				# 이렇게 만들어진 set()에 길이가 만약 3이 아니라면 '중복돼서 뭔가 제거 됐다'는 뜻!
				result = diff				# 아하~ 이건 중복이 없는 result구나~ 갱신!!
	else:
		for i in range(3):
			money[i] += coin[L]				# coin[L]: 해당레벨 = 8(0),9(1),11(2).. n번째 입력값
			DFS(L + 1)						# 다음 레벨로 가서 또 for 돌면서 누구한테 금액을 줄지 말지 정한다
			money[i] -= coin[L]				# 이 줄에 도착했다? DFS끝나고 back 한 상황. back을 하면 money[0] -= 8 이런 식으로 해줘야 한다


n = int(input())
coin = []
money = [0] * 3
result = 2147000000							# 최소값(총액이 가장 큰 사람 - 작은 사람)을 구해야 하니까, 최대값으로 초기화

for _ in range(n):
	coin.append(int(input()))				# 왜 이렇게 할까? 엔터치면서 coin을 받기 때문
DFS(0)
print(result)

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