'''
개념
1. 순열, 조합의 경우 itertools 라이브러리를 사용해서 구할 수 있다.
	= import itertools
	= 순열은 permutations, 조합은 combinations
	= 이 문제는 조합이므로 combinations

'''
import itertools as it

n, k = map(int, input().split())
arr = list(map(int, input().split()))
m = int(input())

cnt = 0
for x in it.combinations(arr, k):			# itertools는 순열, 조합 구해주는 것. 조합은 combinations
	if (sum(x) % m == 0):					# x = {4, 8, 12} , sum(x) = 24 / 6의 배수 == m의 배수
		cnt += 1
print(cnt)

'''
5 3
2 4 5 8 12
6
=
2
'''