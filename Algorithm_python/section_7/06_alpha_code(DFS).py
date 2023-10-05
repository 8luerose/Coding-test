'''
개념
1. 상태트리 == DFS용
2. 문제 설명
	= 25114가 들어왔을 때 -> [2][5][1][1][4] 이렇게 저장
	= D(L,P)부터 시작해서 L=0 -> +1, P=0 -> +1
	= for 1(A) ~ 26(Z)까지 주르륵 뽑는데, 2, 25 일 때 이 안에 포함된다
	= 따라서, i = 2 or 25 일 때 다시 레벨 증가 -> 다시 for 쭈르륵
	= 마지막에 result = [25][1][1][4] 이렇다?
	= 그러면 정답은 YAAD 가 된다. 이런 식이다
3. 
'''
def DFS(L, P):
	global cnt
	if (L == n):										# 종착점 온 경우
		cnt += 1										# 완성된 알파벳 갯수 +1
		for j in range(P):								# 완성된 알파벳 출력 
			print(chr(result[j] + 64), end = '')		# 
		print()
	else:												# 가지 뻗기
		for i in range(1, 27):							# 1 ~ 26까지 뻗기 위해
			if (code[L] == i):							# 25114 중 2(1~26)와 일치하는가? 이런 식
				result[P] = i							# [' '][][][][] 이 자리에 i가 2면 '2' 들어온다
				DFS(L + 1, P + 1)						# 2 or 25 중 한자리 숫자가 걸렸을 때 + 여기서 P가 i 인덱스 역할
			elif (i >= 10 and code[L] == i // 10 and code[L + 1] == i % 10):		# 2 or 25 중 25 같은 두자리 수
				result[P] = i
				DFS(L + 2, P + 1)


code = list(map(int, input()))							# code = 암호화된 숫자 리스트 2 5 1 1 4
n = len(code)											# n = 종착점 0 ~ n-1까지
code.insert(n, -1)										# code.insert(어디에, 뭐를) -> n, -1
cnt = 0
result = [0] * (n + 3)
DFS(0, 0)
print(cnt)
'''
25114
=
BEAAD
BEAN
BEKD
YAAD
YAN
YKD
6
'''