'''
개념

1. 오름차순 정렬
2. 가장 무거운 사람 + 가장 가벼운 사람 = 끝과 끝
3. 만약 제한을 넘어가면, 가장 무거운 사람은 혼자 타고 간다
4. 그 다음 무거운 사람 + 가벼운 사람 = 가능 = 둘 다 타고 간다 (=pop)
5. 모두 비면 break
6. ! 근데 마지막 딱 한 명 남았을 때
	= arr 길이가 1일 때 cnt +=1 하고, break
7. ! list 자료형의 한계
	= pop() 시키면 한 칸씩 당겨지는 연산을 한다
    = 시간복잡도 문제 발생
    = 따라서 deque 구조로 쓰면 pop()시켜도 한 칸씩 당겨지지 않는다
    = 헤더에 from collections import deque 선언한다
    = 데크 자료구조로 변경: arr = deque(arr)
    = 맨 앞자료 꺼낼 때: arr.popleft()
'''
from collections import deque		#데크 자료구조
n, limit = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
arr = deque(arr)					#리스트 = deque(리스트)

cnt = 0
while (arr):
    if (len(arr)) == 1:				#만약 한 명만 남았을 때
        cnt += 1
        break
    if (arr[0] + arr[-1] > limit):	#맨 앞 + 맨 뒤 > 탑승 무게
        arr.pop()					#그냥 마지막 한 명만 간다
        cnt += 1
    else:							#맨 앞 + 맨 뒤 < 탑승 무게
        arr.popleft()				#맨 앞 (데크 자료구조 시 pop(0) 대신 쓰임)
        arr.pop()					#맨 뒤 같이 간다
        cnt += 1
print(cnt)

'''
5 140
90 50 70 100 60
=3
'''

#리스트 Ver (deque 자료구조 아닌 일반 버전)
# arr.sort()

# cnt = 0
# while (arr):
#     if (len(arr)) == 1:				#만약 한 명만 남았을 때
#         cnt += 1
#         break
#     if (arr[0] + arr[-1] > limit):	#맨 앞 + 맨 뒤 > 탑승 무게
#         arr.pop()					#그냥 마지막 한 명만 간다
#         cnt += 1
#     else:							#맨 앞 + 맨 뒤 < 탑승 무게
#         arr.pop(0)					#맨 앞
#         arr.pop()					#맨 뒤 같이 간다
#         cnt += 1
# print(cnt)

