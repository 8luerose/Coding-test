'''
킬링포인트

1. .sort() vs sorted()
	1.sort: 기존 리스트를 변경한다
		ex) arr.sort() -> arr 변경됨
	2.sorted: 기존 리스트를 변경하지 않는다
		ex) new_arr = sorted(arr) -> 기존 arr 변경되지 않음

2	.sort() 이후에 -> a,b,c = map() 
	정렬 후에 map해야 a,b,c에 각각 매핑됨
    =그러면 가장 오름차순으로 1~6 값 정렬됨
** .sort()함수는 문자, 정수 모두 정렬 가능 **     
'''

n = int(input())

result = 0									#가장 큰 금액 저장용 (0으로 초기화)
for i in range(n):
    arr = list(map(int, input().split()))
    arr.sort()								#정렬 먼저
    a, b, c = map(int, arr)					#정렬된 것을 map()
    if a == b and b == c:
        money = 10000 + a * 1000
    elif a == b or a == c:					#2개가 같은 경우
        money = 10000 + a * 100
    elif b == c:							#2개가 같은 경우
        money = 10000 + b * 100
    else:
        money = c * 100						#모두 다른 경우, (그 중 가장 큰 눈) * 100 
    if money > result:						#가장 큰 금액이면 저장
        result = money
print(result)

#이렇게도 가능
	# tmp = input().split()					#input(): ['3','3','6'] 이렇게 '문자형'으로 입력받게 됨
	# tmp.sort()							#문자형도 정렬 가능
	# a, b, c = map(int, tmp)				#map(int, )로 정수 타입 a,b,c 매핑

'''
3
3 3 6
2 2 2
6 2 5

= 12000
'''