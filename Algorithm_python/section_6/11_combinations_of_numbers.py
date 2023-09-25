'''
개념
1. 상태트리
2. DFS = D(L, S, sum)
3. nCr = n! / (r! * (n - r)!)
	= 5C3 = 5! / (3! * (5 - 3)!) = 5 * 4 * 3!/ 3! * 2 = 5 * 4 / 2
4. 5,3 이면 5개 중 3개를 뽑는다 = 5C3
	= 이 조합 중 M의 배수는 몇 개냐 = M으로 나누었을 떄 떨어지면 배수
5. 2 4 5 8 12 중 3개를 뽑는 경우 = 5C3
	= 2 4 5, 2 4 8, 2 4 12, 2 5 8, 2 5 12, 2 8 12, 4 5 8, 4 5 12, 4 8 12, 5 8 12
	= 이 중 6으로 나누어 떨어지는 배수는 몇 개?
	= 2, 4, 12 = 18이므로 배수 확정 -> cnt++
6. DFS(L, S, sum) 중 S는 'i + 1'
	= for 문으로 N까지 돌려서 i 만든다. N이 5일 때 가닥은 0 ~ 4까지
	= D(1, i+1, sum)
7. DFS(L + 1, i + 1, sum + a[i]) 
	= sum + a[i]은 arr[2,4,5,8,12]를 의미
'''
def DFS(L, S, sum):
	global cnt
	if (L == K):							# L이 K개 뽑았으면 이제 누적해온거 검사
		if (sum % M == 0):					# sum + arr[i] 누적합이 M으로 나누어 떨어지면 배수
			cnt += 1
	else: 									# 가지가 뻗어나간다
		for i in range(S, N):				# S부터 뻗는다 어디까지? arr의 인덱스 갯수 즉, N-1까지
			DFS(L + 1, i + 1, sum + arr[i])	# L증가, S는 i + 1(= 가지 뻗는거), sum + arr[i] 누적합


N, K = map(int, input().split())			# N개 중 K개를 뽑는다
arr = list(map(int, input().split()))		# N개의 정수
M = int(input())							# 배수
cnt = 0
DFS(0,0,0)
print(cnt)

'''
5 3
2 4 5 8 12
6
=
2
'''