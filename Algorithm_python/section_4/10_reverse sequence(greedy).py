'''

개념
1. 역수열이란? 내 앞에 있는 것보다 큰 수의 갯수를 세고 + 그걸 나열한 수열
	=1앞에는 5개 (4 8 6 2 5), 2앞에는 3개(4 8 6), 3앞에는 4개(4 8 6 5)...
    =5 3 4 ..

'''
n = int(input())
arr = list(map(int, input().split()))
arr.insert(0, 0)
result = [0] * n

for i in range(1, n + 1):
    for j in range(n):
        if arr[i] == 0 and result[j] == 0:
            result[j] = i
            break
        elif result[j] == 0:
            arr[i] -= 1

for i in result:
    print(i, end = ' ')



'''
8
5 3 4 0 2 1 1 0

=4 8 6 2 5 1 3 7
'''