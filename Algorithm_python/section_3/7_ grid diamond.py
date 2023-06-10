'''
개념

start = end = n // 2
0~2) s -= 1, e += 1		옆으로 퍼짐
3~4) s += 1, e -= 1		가운데로 작아짐
'''
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

result = 0
start = end = n // 2
for i in range(n):
    for j in range(start, end+1):
        result += arr[i][j]			# 색칠된 부분 모두 덧셈 누적
    if (i < n // 2):				# n//2 이전까진 옆으로 퍼짐
        start -= 1					# 왼쪽으로
        end += 1					# 오른쪽으로
    else:							# n//2 이후부턴 가운데로 모임
        start += 1					# 오른쪽으로
        end -= 1					# 왼쪽으로
print(result)


# *주의*
# for -> (if - else) 순: for j로 누적 다 끝나고, for i 돌면서 벌려주기
# for - else 구문이라는 것도 존재 (=for가 아니면 else다~)
'''
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
=379
'''