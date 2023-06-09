'''
문제
(1, 2) (2, 1) (3) (1,1,1) (1,2)
=5개


개념
1.예상치보다 합이 작을 때
=j 증가
2.예상치보다 합이 같거나, 클 때
=i 증가

ex)
a d 
= a ~ 'd이전(앞)까지' 합

a b . d = (a + b + .) < d 이면 -> i 증가
= a b c 상태

a b c d = (a + b + c) > d 이면 -> a 빼주고 (b + c)
= i 증가, b c 상태

a b c d = (a + b + c) = d 이면 -> 결과 cnt 증가 -> a 빼주고 (b + c) 
= i 증가, b c 상태

코드로 해결해야하는 사고력 문제
'''
n, m = map(int, input().split())
arr = list(map(int, input().split()))

i = 0
j = 1
total = arr[0]
cnt = 0
while (True):
    if total < m:
        if j < n:						#j가 n보다 작을 때만 더한다
            total += arr[j]
            j += 1						#더해주고 -> j 미리 증가(다음을 위해)
        else:							#j가 n보다 크다??
            break						#바로 반복문 중지
    elif total == m:
        cnt += 1						#예상치와 같으면 cnt 증가
        total -= arr[i]					#아까 total값에서 빼주고
        i += 1							#i 미리 증가(다음을 위해)
    else:
        total -= arr[i]					#합이 예상치보다 크면 아까 total에서 빼주고
        i += 1							#i 미리 증가(다음 반복문 위해)
print(cnt)
        
            

'''
8 3 
1 2 1 3 1 1 1 2
= 5
'''