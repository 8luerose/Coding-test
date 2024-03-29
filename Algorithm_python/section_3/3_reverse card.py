arr = list(range(21))					#[0, ~ ,20] 리스트 생성

for _ in range(10):
	a, b = map(int, input().split())
	for i in range((b - a + 1) // 2):	#'구간'만큼 돌아라
		arr[a + i], arr[b - i] = arr[b - i], arr[a + i]		#교환
arr.pop(0)								#arr.pop() = 마지막 pop, (idx)은 해당 idx pop

for x in arr:							# [0, ~ , 20] -> 0 1 2 3.. 출력하기 위함
	print(x, end = ' ')


# *중요 개념*
# 1. a, b = b, a						#파이썬에서 '교환'하는 방법 (=swap)

# 2. 구간 교환 방법: (b - a + 1) // 2
# =ex)2 ~ 7 구간 변경 시 {2,7  3,6  4,5} 3번, 3 ~ 7 변경 시 {3,7  4,6  5} 2번
# 왜? 1 ~ 3 까지 몇개 있어? = 1,2,3 "3개" -> 즉, 1 자기 자신도 포함
# 따라서, 1 ~ 3까지 (3 - 1) + 1 = '3개 존재'
# 이와 같이, 2 ~ 7까지 (7-2)+1 =6개 존재 -> 2로 나누기 = 3번 교환

# 3. arr.pop() = arr 마지막 pop()
# arr.pop(idx) = 해당 idx를 pop 한다.

# *주의*
# ((b - a) + 1 // 2) -> 1 // 2 먼저 하므로 주의

'''
5 10
9 13
1 2
3 4 
5 6
1 2 
3 4
5 6 
1 20 
1 20

=1 2 3 4 10 9 8 7 13 12 11 5 6 14 15 16 17 18 19 20
'''