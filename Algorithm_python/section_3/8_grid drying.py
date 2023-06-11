'''
핵심 개념

1. list.pop(idx) 실행 시, 자동으로 앞으로 당겨진다
ex) 3 1 2 4 -> pop(0) -> ' ' 1 2 4 -> 1 2 4 ' '

2. 이후 
- list.append(value) 실행 시, 뒤에 덧붙여진다
ex)list.append(list.pop(0))

- list.insert(idx, value) 실행 시, idx에 삽입된다
ex)list.insert(0, list.pop())

3. +사과나무 개념
n // 2 까지는 start += 1, end -= 1
n // 2 이후는 start -= 1, end += 1

n = 5 일때, n // 2 =2 이므로 0 1 까지는 start,end 변화되고
따라서, 2 부터 start,end 다시 범위 변화 됨
'''

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
m = int(input())

for i in range(m):
    a, b, c = map(int, input().split())
    if (b == 0):
        for _ in range(c): 
            arr[a - 1].append(arr[a - 1].pop(0))
    else:
        for _ in range(c):
            arr[a - 1].insert(0, arr[a - 1].pop())
            
result = 0
start = 0
end = n - 1
for i in range(n):
    for j in range(start, end + 1):		#start ~ end 까지 범위 지정 j로
        result += arr[i][j]
    if (i < n // 2):					#n//2까지는 좁히고
        start += 1
        end -= 1
    else:								#n//2 이후부터는 넓히고
        start -= 1
        end += 1
print(result)

'''
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
3
2 0 3
5 1 2
3 1 4

=362
'''