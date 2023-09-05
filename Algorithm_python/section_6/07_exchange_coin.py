'''
개념
1. D(L)은 사용한 동전 갯수를 의미한다
2. 종류개수가 주어질 뿐 D(L)은 조건을 만족할 때까지 계속 증가한다
3. 거슬러줄 금액을 달성하면서, 이를 달성하는 것중 최소개수를 사용할 때를 고르는 문제
4. 따라서, 제일 큰 값부터 시작하면 시간 복잡도를 줄일 수 있게 된다
5. D(L, sum) = sum은 그동안 더한 동전의 금액을 의미한다
6. 그렇게 했을 때, sum이 만약 거슬러줄 금액에 달성하면, 'result = L'(달성했을 때의 동전의 갯수)
7. 만약에 가장 작은 동전 금액부터 진행한다면 너무 깊이 내려간다.
	= 따라서 내림차순으로 정렬해서 진행한다
	= sum이 만약 거슬러줄 금액 m 보다 커지면 더이상 볼 필요가 없이 return
8. result 가 이미 최소값을 산정했으면 그 이상은 볼 필요 없다
'''
def DFS(L, total):
	global result
	if (L > result):								#우리가 찾은 result(레벨)이 현재 레벨보다 작으면 '최소개수(레벨)' 찾을 필요 없어짐
		return
	if (total > m):									#거슬러줄 금액 초과하면 따질 필요 없음 
		return										# base case
	if (total == m):								#거슬러줄 금액과 total sum이 같을경우
		if (L < result):							#result 최신화 (더 낮은 레벨로)
			result = L
	else :
		for i in range(n):
			DFS(L + 1, total + arr[i])				#total에 5,2,1 중 선택한 동전 추가


n = int(input())
arr = list(map(int, input().split()))
m = int(input())
result = 2147483647									#최소 금액 비교해서 넣어야 하니까 제일 큰 값으로 초기화
arr.sort(reverse=True)								# Cut edge: 내림차순으로 정렬해서 진행한다
DFS(0, 0)
print(result)



'''
3
1 2 5
15

=
3
'''