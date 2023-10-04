'''


'''
def DFS(L, P):
	global cnt
	if (L == n):
		cnt += 1
		for j in range(P):
			print(chr(result[j] + 64), end = '')
		print()
	else:
		for i in range(1, 27):
			if (code[L] == i):
				result[P] = i
				DFS(L + 1, P + 1)
			elif (i >= 10 and code[L] == i // 10 and code[L + 1] == i % 10):
				result[P] = i
				DFS(L + 2, P + 1)


code = list(map(int, input()))
n = len(code)
code.insert(n, -1)
result = [0] * (n + 3)
cnt = 0
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