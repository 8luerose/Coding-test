'''
개념

1. 왼쪽 다 끝나고
2. 오른쪽 다 끝나고
3. "--여기서부터 이제 본연의 일--"
	= 본연의 일 == p1, p2 비교해서 tmp에 삽입

5. -> 본연의 일 끝나면 왼쪽 재귀 끝 -> 오른쪽 재귀 끝 -> 본연의 일

6. 이때, 임시변수 tmp에 복사해놓고 다시 꺼낸다

* 주의 *
tmp를 arr에 복사할 때, lt부터 시작해야 한다
이때 lt 부터 시작하는 이유는? 
	= Dsort(4, 7)이렇게 4에서부터 시작할 수 있기 때문
	= 만약, arr i = 0 부터 넣으면 Dsort(4, 7)앞에 있는 것을 덮어씌우는 상황이 생긴다

따라서 arr [lt + i] = tmp[i]로 해야 한다
	= len(tmp) 는 병합정렬한 만큼이니까
	= lt 뒤부터 ~ (병합정렬한 만큼) 들어가는것!
'''
def Dsort(lt, rt):
	if (lt < rt):
		mid = (lt + rt) // 2
		Dsort(lt, mid)							# 왼쪽 재귀
		Dsort(mid + 1, rt)						# 오른쪽 재귀
		p1 = lt									# 왼쪽 재귀 배열 인덱스 첫번째
		p2 = mid + 1							# 오른쪽 재귀 배열 인덱스 첫번째
		tmp = []								# 임시 배열
		while ((p1 <= mid) and (p2 <= rt)):
			if (arr[p1] < arr[p2]):
				tmp.append(arr[p1])
				p1 += 1
			else :
				tmp.append(arr[p2])
				p2 += 1
		if (p1 <= mid):							# 왼쪽 재귀가 끝나지 않았다면
			tmp = tmp + arr[p1 : mid + 1]
		if (p2 <= rt):							# 오른쪽 재귀가 끝나지 않았다면
			tmp = tmp + arr[p2: rt + 1]
		for i in range(len(tmp)):				# 임시 배열을 원래 배열에 복사
			arr[lt + i] = tmp[i]



arr = [23, 11, 45, 36, 15, 67, 33, 21]
print("Before sort:", end = '')
print(arr)
Dsort(0, 7)										# 병합정렬
print()
print("After sort:", end = ' ')
print(arr)