'''
개념
1. 문제: 금액과 동전 갯수 주어지고, 그 동전으로 만들 수 있는 경우의 수 몇가지인가?
2. 예시: 20 = (10x1) + (5x1) + (1x5)
3. 과정:
	= 0원에서 출발 -> 해당 레벨의 동전 갯수만큼 가닥 i개 뻗고
	= -> 해당 레벨의 동전 x i = sum 만듦
	= -> sum이 m보다 작으면 다음 레벨로 가서 또 가닥 뻗고
	= -> 다음 레벨 가서 기존 sum + (가닥 뻗은 i * 동전 = sum)
	= 해당 L의 sum 만들어진다 -> 반복해서 최종 금액 완성
4. 어떻게 D(L, sum) 재귀문 써야 할까?
	= DFS(L + 1, sum + (coin[L] * i))		# 해당 레벨의 동전 x i = sum 만듦
5. 주의
	= 1. 주어진 동전 갯수만큼 가닥을 뻗는데, 0~N까지 뻗는다
	= 2. 0부터 가지가 뻗어나가니까, 재귀의 흐름상 한줄로 적어도 괜찮다 for: DFS()
	= 3. if (L==k): 하지 않으면, L이 계속 증가하고 if (sum == T) 만 맞으면 된다는 식이 된다.
	= 	그럼 arr[L]인덱스 초과한다

6. Time limit exceeded
	= cut edge 해줘야 한다
	= if (sum > T):
		return
	= 기존 sum + 새로운 sum 한 값이 T보다 크면 그 가닥 사용 x
	= + 이 방식도 괜찮으나 참고만해라 	
	=	if (sum + (coin_value[L] * i) > T):	break
	= 1. 깔끔하지 않다. 2. L == k 안해주면 인덱스 초과

7. DP vs DFS
	= DFS에서는 모든 가능한 동전의 조합을 탐색하려고 한다
	= 반면 DP는 이미 계산된 부분 문제의 답을 재활용할 수 있다
	= 따라서, 이런 유형의 문제에서는 중복 계산을 피하기 위해 DP를 사용하는 것이 좋다
'''
def DFS(L, sum):
	global cnt
	if (sum > T):									# cut-edge: DFS()타고 들어왔는데 sum > T이면 바로 return
		return
	if (L == k):									# base case: 말단 노드까지 왔다	
		if (sum == T):
			cnt += 1
	else :
		for i in range(coin_num[L] + 1):			# 해당 코인 가지수 0 ~ N까지 가닥
			# if (sum + (coin_value[L] * i) > T):		# 기존 sum + 새로운 sum 한 값이 T보다 크면 그 가닥 사용 x
			# 	break
			DFS(L + 1, sum + (coin_value[L] * i))	# 해당 코인 금액 * i = sum, 그리고 다음 레벨


T = int(input())									# T = 지폐의 금액(최종금액)
k = int(input())									# k = 동전의 가지수
coin_value = list()									# coin_value = 동전의 금액 리스트화 쭈르륵 담겠다
coin_num = list()									# coin_num = 동전의 갯수 리스트화 쭈르륵 담겠다

for i in range(k):									# 동전의 가지수만큼 입력 받겠다
	a, b = map(int, input().split())
	coin_value.append(a)							# 동전의 금액 리스트에 해당 동전 넣음
	coin_num.append(b)								# 동전의 갯수 리스트에 해당 동전 갯수 넣음

cnt = 0
DFS(0, 0)
print(cnt)

'''
20
3
5 3
10 2
1 5
=
4
'''