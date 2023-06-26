'''

개념
가장 가까운 두 말의 최대 거리를 출력하라
=가장 가까운 두 말의 거리가 최대여야 한다 + 3마리의 말이 배치되어야 한다

1. '(간격의)최대 거리' + '말 수' = 이분탐색 (결정 알고리즘)
2. 최대 거리 -> 간격 좁혀본다
3. 이분탐색으로 줄여가면서 3마리 배치 가능한 시점 + 그 케이스 중 최대 거리 찾아라
'''
def horse_cnt(len):
    start = arr[0]					#첫번째 말의 위치
    cnt = 1							#우선 말 하나 배치가능
    for i in range(1, n):			#아까 0부터 시작했으니, 1부터 시작
        if (arr[i] - start >= len):	#현재-첫 >= 말 사이 거리
              cnt += 1				#실제 간격이 거리보다 더 커도 말 배치는 가능하므로 cnt증가
              start = arr[i]		#다음 말 간격을 판단하기 위해 start 재지정
    return (cnt) 
            
n, c = map(int, input().split())
arr = []							#개행으로 입력되므로 for로 저장
for _ in range(n):
    tmp = int(input())
    arr.append(tmp)					#리스트에.append해서 정수 추가
arr.sort()							#리스트를 정렬해야 좌표를 순서대로 정렬 가능

i = 1
j = arr[n - 1]						#arr[n-1] = arr[마지막 인덱스(좌표)] 
while (i <= j):
    mid = (i + j) // 2
    if (horse_cnt(mid) >= c):		#거리 적용한 이론상 말 배치 수 >= 실제 말 배치해야되는 수
        result = mid				#해당되면 최대 거리 갱신 
        i = mid + 1					#현재 거리보다 더 클 수 있으므로 i증가해서 다시 판단
    else :
        j = mid - 1					#거리 적용한 이론상 말 배치 수가 실제 배치해야되는 수보다 적으면 거리를 줄여야 함
print(result)

'''
5 3
1
2
8
4
9

= 3
'''