'''
개념

1. 최소힙은 왼쪽, 오른쪽 노드보다 부모 노드가 제일 작다
2. 왼쪽 노드 먼저 방문
3. 자식 노드가 부모 노드 보다 작으면 바꿔준다
4. 1레벨 2레벨.. 아래로 내려간다
5. 하나 채워질 때마다 부모노드와 비교, 자식 노드가 작으면 바꿔준다
6. 올라가는 것 = up heap 내려가는 것 =down heap
7. pop하면 제일 작은 것인 '루트 노드 pop'된다
	= 빈 상태가 되고, 이후에 이 빈곳은 '가장 아래쪽 레벨에 제일 오른쪽 것이' 들어간다
    = 채워졌으면, 자식 노드 중 더 작은 것과 비교한다 -> 자식 더 작으면 서로 swap
8. 파이썬에서는 heapq 로 한다
'''
import heapq as hq						#as 는 약자로 하겠다라는 뜻 = as hq

arr = []								#heap이 될 리스트
while (True):
    n = int(input())
    if (n == -1) :						#종료 시 -1
        break
    if (n == 0) :						#pop 조건 n == 0일때
        if (len(arr) == 0):				#pop하려는데 만약 heap에 아무것도 없다면(=len(arr) == 0)
            print (-1)					#오류
        else :
            print(hq.heappop(arr))		#arr에서 루트 노드를 heap pop한다 (= heapq.heappop(리스트))
    else :								#pop조건은 n이 0인데, 이게 아닐 경우
        hq.heappush(arr, n)				#heapq에 heap push 해준다 arr에 n을
        
        
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
3 
5 
2
'''