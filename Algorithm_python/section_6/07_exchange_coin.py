'''

'''
def DFS(L, total):
	global result
	if (total > m):
		return
	if (total == m):
		if (L < result):
			result = L
	else :
		for i in range(n):
			DFS(L + 1, total + arr[i])


n = int(input())
arr = list(map(int, input().split()))
m = int(input())
result = 2147483647
arr.sort(reverse=True)
DFS(0, 0)
print(result)



'''
3
1 2 5
15

=
3
'''