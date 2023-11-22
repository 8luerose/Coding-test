'''
개념

1. 약수 빠르게 구하는 법
	= 16의 약수는 1, 2, 4, 8, 16
	= 즉, 16에 '루트'를 씌우고 int()하면 4가 된다
	= 어떤 수를 가져와도, 루트까지만 계산하면 된다 == int(n ** 0.5)
	= 기존 반복문 'for i in range(1, n+1) - if n % i == 0' 보다 빠르다
	= for i in range(1, int(n ** 0.5) + 1) - if n % i == 0
'''
# 화면 송출용 코드
# n = int(input())

# for i in range(1, int(n ** 0.5) + 1):
# 	if (n % i == 0):						# 나누어 떨어지면 == 약수면
# 		print(i, n // i)					# 나누어 떨어뜨리는 수, 떨어지는 결과 출력 ex) 1 18, 2 9, 3 6

# 실제 코드
n = int(input())
arr = []

for i in range(1, int(n ** 0.5) + 1):
    if n % i == 0:
        arr.append(i)
        if i != n // i:						# 4 * 4 = 16이면, 4는 한번만 리스트에 담겨야 한다
            arr.append(n // i)

print(len(arr))								# 약수 개수
arr.sort()
for i in arr:
    print(i, end = ' ')
# print(arr)								# 리스트 원형 출력됨: '[]' ex) [1, 2, 4, 8, 16] 



'''
15
=
2
3 5
'''