'''

개념
1. pop()한 것이 위험도가 높으면 cnt 1증가
2. cnt가 M번째일때 break
3. 60 50 70 80 90을 큐 라는 자료구조에 넣을 것이다
	= arr.popleft()하면 60빠지고, arr.append(x)하면 맨 뒤에 넣어진다
4. arr를 튜플값으로 변환 시켜준다 [(a,b) for a, b in enumerate()]
	= in enumerate(arr) = (0, 60) -> for a = 0, b = 60
    = (a, b) for a, b = 0, 60 을 (0.60)으로
5. Q = deque(Q) 이런 식으로 collections 사용 가능
6. deque는 양방향 pop가능하므로 .popleft(), .append() 가능
7. 튜플 값은 x = (0, 60) 이고, x[0]=0, x[1]=60 이 된다
8. if any()= '하나라도 참이면 실행'
'''

from collections import deque

n, m = map(int, input().split())
arr = list(map(int, input().split()))
Q = [(i, value) for i, value in enumerate(arr)]		#enumerate(arr) -> 0, 60 (튜플화) ->(i, value)처리 가능
# print("test1", Q)
Q = deque(Q)
# print("test2", Q)

cnt = 0
while (True):
    tmp = Q.popleft()								#튜플 상태인 Q를 pop()하면 (0, 60) 한 번에 tmp에 담긴다
    # print("test3", tmp)
    if any(tmp[1] < i[1] for i in Q):				#tmp[1] = (0, 60) 중 60, any: 하나라도 참이면 실행
        Q.append(tmp)
    else :
        cnt += 1
        if tmp[0] == m:								#tmp가 튜플형이라 tmp[0] = (0, 60) 중 0
            break
print(cnt)											#튜플 tmp의 (i, value) 중 tmp[0]인 i가 == m 일 때 cnt가 멈춰졌다

'''
5 2
60 50 70 80 90
= 3

6 0
60 60 90 60 60 60
= 5
'''