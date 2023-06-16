n, m = map(int, input().split())
arr = list(map(int, input().split()))
i = 0							#좌
j = n - 1						#우

arr.sort()

while (i <= j):
    mid = (i + j) // 2
    if (arr[mid] == m):
        print(mid + 1)			#mid는 인덱스(위치)이므로 실제값은 mid + 1
        break
    elif (arr[mid] > m):		#찾고자 하는 것보다 arr[mid]가 클 경우
        j = mid - 1				#범위를 벗어났으므로, mid보다 -1인 곳이 j의 범위로 재지정
    else :						#찾고자 하는 것보다 arr[mid]가 작을 경우
        i = mid + 1				#mid보다 +1인 곳이 i의 범위로 재지정
    
'''
8 32
23 87 65 12 57 32 99 81

=3
'''