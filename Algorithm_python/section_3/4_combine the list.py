'''
개념

3 + 5 리스트를 합치고 (arr = [] + []) -> sort() 하면 오름차순 정렬된다
그러나, sort()는 퀵정렬로써 nlog n 의 시간복잡도가 소요된다.
이 문제는 '정렬'된 상태이므로 O(n)만에 해결할 수 있다.
'''

n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

p1 = p2 = 0								#포인터(인덱스) 초기화
c = []									#리스트 초기화

while (p1 < n and p2 < m):				#하나라도 끝에 왔다면 끝
    if a[p1] <= b[p2]:					#작으면 오름차순에 도입
        c.append(a[p1])					#c.append() = 리스트 유지하며 추가
        p1 += 1
    else:
        c.append(b[p2])
        p2 += 1
										# (p1 < n and p2 < m) 중 먼저 끝난 게 있을 때
if p1 < n:								#p1이 아직 n까지 안갔다면
    c = c + a[p1:]						#리스트 + 리스트(a[idx: ])
if p2 < m:
    c = c + b[p2:]

for x in c:
    print(x, end = ' ')


# *중요 개념*
# 1.리스트[idx]끼리 비교해가며 작은 배열 값 부터 넣어준다
# 2.리스트.append(값): 리스트 유지하며 추가
# 3.리스트 = 리스트 + 리스트
# 4.리스트[idx:]: idx 부터 끝까지 // [:idx] idx-1까지 // [:] 리스트 전체 
# 5.리스트.insert(idx, 값): 리스트 idx 위치에 추가

'''
3
1 3 5
5
2 3 6 7 9

=1 2 3 3 5 6 7 9
'''