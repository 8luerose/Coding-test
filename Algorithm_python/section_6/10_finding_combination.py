'''
개념

1. 상태트리 기존것과 약간 다름
2. D(L,S) = L은 레벨, S는 누적합.
	= S는 1부터 시작한다
	= D(L, S) 중 S는 'i + 1' 
3. D(0, 1)부터 시작하는데, S를 시작으로 for문이 N만큼 돈다
	= 즉, D(0, 1)이면 i는 1~4
4. res리스트는 M개 존재하고, res[L] = i 가 된다
	= 즉, res[0] = 1, res[0] = 2, res[0] = 3, res[0] = 4
	= 이후에 res[M-1]도 동일
5. 과정: D(0, 1) -> L증가 -> D(1, ) -> i중 1 선택 -> D(1, i + 1)
	= D(1, 2) -> L증가 -> D(2, ) -> i중 2 선택 -> D(2, i + 1)
6. D(1, 2)라면 S를 시작으로 for문이 N만큼 돈다
	= 따라서, 갈래가 2, 3, 4
7. D(L, ) L이 M이 되면 res[ ] 출력

8. 포인트
	= D(L, S) 중 S는 'i + 1'
	= D(L, ) 파고들려고 하면 for 쭈르륵 펼쳐지고,
	= i 골라서 밑으로 내려가면 L증가, S는 쭈르륵 i 중 i + 1
	= res 저장해줘야한다. res[L] = i
	= D(L, ) L이 M이 되면 res[ ] 출력
	= 즉, 선택했던 i 들 출력

9. 주의할점
	= DFS(L+1, 'i + 1') S는 'i + 1' 증가
'''
def DFS(L, S):
	global cnt
	if (L == M):
		for j in range(L):				# L-1 까지 == M-1 까지   ex)4 2 면 2개만 출력하라
			print(res[j], end = ' ')	# 쌓아놓았던거 모두 출력
		cnt += 1						# 맨 마지막 총 경우의 수 출력을 위함
		print()
	else :
		for i in range(S, N + 1):	 	# S부터 뻗는다 어디까지? N까지
			res[L] = i					# res[0] = 1, res[0] = 2, res[0] = 3, res[0] = 4 for대로
			DFS(L + 1, i + 1)			# L증가, S는 i + 1

N, M = map(int, input().split())
res = [0] * N						 	# 출력할(선택한) 리스트
cnt = 0
DFS(0, 1)
print(cnt)								# DFS 다 끝났으면 총 경우의 수 출력


'''
4 2
=
1 2
1 3
1 4
2 3
2 4
3 4
6
'''