'''
개념
1. 파이썬에서는 que를 deque라는 라이브러리로 지원한다
2. popleft(), append()를 이용해서 LIFO를 구현한다
	=스택은 FIFO
3. popleft() = 빠지고 -> append() 시켜준다
4. 이때, K 이면 '그냥 popleft() 해서 que에서 사라지게 한다'
	= K면 que에서 삭제 시킨다
5. 큐에 마지막 하나 남을 때 답이 된다 
'''
from collections import deque		#자료구조 쓰고 싶으면 from collections에서 import한다
n, k = map(int, input().split())
arr = list(range(1, n + 1))			#1~n 범위까지 리스트화() 된다
arr = deque(arr)					#리스트가 -> 자료구조화 된다
while arr:
    for _ in range(k - 1):			#k-1 = k가 3이라면 0, 1 뺄때까지 반복한다
        tmp = arr.popleft()			#하나 뺴서
        arr.append(tmp)				#맨 뒤에 다시 넣는다
    arr.popleft()					#k가 3이면(for다 돌고) 그냥 popleft()시킨다
    if len(arr) == 1:				#arr가 하나 남았을 때 그게 정답
        print(arr[0])
        break						#혹은 arr.popleft()해서 위에 while문 거짓하여 정지


'''
8 3
= 7
'''