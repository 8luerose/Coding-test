n = int(input())
arr = list(map(int, input().split()))

cnt = 0
sum = 0
for x in arr:
    if x == 1:			
        cnt += 1		# 발견횟수 누적 증가 	ex) 111 = 1,2,3
        sum += cnt		# 즉시 반영
    else:
        cnt = 0			# 0 발견 시 누적된 거 초기화  
print(sum)

'''
10
1 0 1 1 1 0 0 1 1 0
=10
'''