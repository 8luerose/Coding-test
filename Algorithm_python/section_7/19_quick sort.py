'''
개념

1. 전위 순회 방식
	= merge sort의 경우 분할 - 본연 순의 후위 순회 였다면
	= 본연 - 분할 순으로 진행한다
2. 피벗
	= 피벗을 기준으로 왼쪽은 피벗보다 작은 값, 오른쪽은 피벗보다 큰 값으로 정렬한다
	= 즉 본연의 일인 정렬을 먼저 한다. 피벗을 기준으로 작은건 왼쪽 큰건 오른쪽
	= Q() 넘어갈 때서야 왼쪽, 오른쪽으로 분할
	= 순서: 본연 - Q() - Q()
	= 최종 1개까지로 쪼개고 합친다
	= *참고* 가장 많이 쓰는 것은 맨 뒤의 값이다
	= pivot = arr[rt]

'''

arr = [45, 21, 23, 36, 15, 67, 11, 60, 20, 33]
print("Before sort: ", end = '')
print(arr)
Qsort(0, 9)
print("After sort: ", end = '')
print()