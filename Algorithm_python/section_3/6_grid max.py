'''
개념

파이썬 2차원 리스트
arr = [list(map(int,input().split())) for _ in range(n)]
= [[...],[...],[...],[...]]		#한 줄

#한 줄 -> 두 줄로 하고싶을 때
for x in arr:
	print(x)
=
[...]
[...]
[...] 
'''
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

max = -2147000000
for i in range(n):
    sum1 = sum2 = 0
    for j in range(n):
        sum1 += arr[i][j]			#행 고정, 열 변경 = 행
        sum2 += arr[j][i]			#행 변경, 열 고정 = 열
    if max < sum1:
        max = sum1
    if max < sum2:					 
        max = sum2

sum1 = sum2 = 0
for i in range(n):
    sum1 += arr[i][i]
    sum2 += arr[i][n-1 -i]
if max < sum1:
    max = sum1
if max < sum2:
    max = sum2

print(max)

# *중요*
# 1. #if(sum1 case) - if(sum2 case) 두개 쓰면은, for 안에 한 번만 돌면서 max 판별, 저장
# =i 기준 1행 전부(sum1), 1열 전부(sum2) 이렇게 한 바퀴 돌고 max보다 크면 값 바꿔줌
# 2. 대각선은 for 한번으로도 가능 
# = 한 행에 (1,1)	(1,5) 존재하고, (2,2)(3,3)..	(2,4)(3,3)...
# 이렇게 한 줄에 2가지 케이스 존재하므로 for i in range(n) 하나로 sum1,sum2 각각 저장
# if - if 두개 써서 정대각선(sum1), 역대각선(sum2) 각각 모두 max와 비교가능

# 정리하면, sum1,sum2 = (행,열), (정대,역대) 케이스 저장 후
# -> if - if 두개로 판별 가능   

# + 2차원 리스트: 리스트 = [리스트맵() for _ in range(n)]
# arr = [list(map(int,input().split())) for _ in range(n)]
# = [[...],[...],[...],[...]]		#한 줄로 저장

'''
5
10 13 10 12 15 
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
=155
'''