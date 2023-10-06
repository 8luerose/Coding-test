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
3. '2'5114 중 2라면 DFS(L + 1, P + 1)
	= '25'114 같이 25라면 DFS(L + 2, P + 1)
	= 어? 그러면 i가 25라면 어떻게 해?
	= elif (i >= 10 and code[L] == i // 10 and code[L + 1] == i % 10):
	= i가 10보다 크고, 25/10 == 2 and 25%10 == 5 이면 DFS(L + 2, P + 1)
4. code.insert(n, -1)
	= 25114: L이 4이고 i가 4라면
	= code[L] == i//10 할때 '4//10 = 0이므로'code[4] == 0 이 된다.
	= 0이라고 했지만 실제로 code[4]의 값은 2511'4' 4이다
	= 따라서 틀렸다고 판단하고 'and code[L + 1] == i % 10' 와 'DFS(L + 2, )' 넘어가지 않는다

	= 그러나
	= 25112: L이 4이고 i가 20라면
	= code[L] == i//10 할때 '20//10 = 2이므로' code[4] == 2 이 된다.
	= 2라고 했고 실제로도 code[4]의 값은 2511'2' 2이다
	= 따라서 맞았다고 판단하고 'and code[L + 1] == i % 10' 와 'DFS(L + 2, )' 넘어간다
	= 이때 segafault 즉, 'list index out of range' 가 발생한다

**	= 20//10 인것과 14//10 일때 실제로 2, 4였기 떄문에 발생한것!
	
	= 따라서 마지막 n에 -1넣어줘서 코드를 보완해주고 index out of range를 해결한다

5. chr(result[j] + 64)
	= 숫자를 ASCII 알파벳으로 바꿔주는 방법
	= chr() + 65부터가 대문자 A
	= 'result[]에서 range(1,) 1부터 시작'했으므로 result는 최소 1부터 시작한다
	= chr(1 + 64) = chr(65) = A
	
**	= 처음부터 바로 chr(result[j] + 64) 떠올리지 말고 그냥 result[]부터 해서 숫자부터 출력해봐라
'''
def DFS(L, P):
	global cnt
	if (L == n):										# 종착점 온 경우
		cnt += 1										# 완성된 알파벳 갯수 +1
		for j in range(P):								# 담아놨던 result 배열 출력
			print(chr(result[j] + 64), end = '')		# 
		print()
	else:												# 가지 뻗기
		for i in range(1, 27):							# 1 ~ 26까지 뻗기 위해
			if (code[L] == i):							# 25114 중 2(1~26)와 일치하는가? 이런 식
				result[P] = i							# [' '][][][][] 이 자리에 i가 2면 '2' 들어온다
				DFS(L + 1, P + 1)						# 2 or 25 중 한자리 숫자가 걸렸을 때 + 여기서 P가 i 인덱스 역할
			elif (i >= 10 and code[L] == i // 10 and code[L + 1] == i % 10):		# 25(>=10) 중 각각 25/10 and 25%10
				result[P] = i							# ['25'][][][][] i 가 25일 때 해당 배열칸의 값은 25가 올 수 있다
				DFS(L + 2, P + 1)						# 25 가 2자리 숫자니까 L + 2, P는 결과값 배열의 인덱스니까 +1


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