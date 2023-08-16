'''
개념

1. 최대힙은 최소힙과 상당히 비슷하다
2. import heapq (as hq 이름 붙여도 된다)
3. **중요**
	= heapq는 기본적으로 '최소힙'으로 동작한다
    = hq.heappop(arr) or hq.heappush(arr, n)는 최소힙 방식
    = 따라서, '최대힙은 - 부호를 붙여주기만 하면 된다'
    = ex 3, 4 중 큰 수는 4. 따라서 -3, -4 마이너스 부호 붙여주면 -4, -3 순
4. 최대힙 중요한 코드 두 줄
	= hq.heappush(arr, '-'n)
    = '-'hq.heappop(arr)		출력할 때 음수화됐던 걸 다시 -붙이는 것
'''
import heapq as hq

arr = []
while (True):
    n = int(input())
    if (n == -1):
        break
    if (n == 0):
        if (len(arr) == 0):			#print 조건 상황인데, heap에 아무것도 없으면 에러
            print(-1)
        else :
            print(-hq.heappop(arr))
    else :
        hq.heappush(arr, -n)		#n == 0 아닐 때는, input()받은 n을 heap arr에 넣어준다
 

'''
5
3
6
0
5
0
2
4
0
-1

=
6
5
5
'''