N = int(input())
for _ in range(N):
	number = int(input())

	for i in range(2, 1_000_001):		# 2 ~ 1000000
		if (number % i == 0):		# 100만 이하의 약수가 존재한다
			print("NO")
			break
		if (i == 1_000_000):
			print("YES")

'''
3
1000036000099
1500035500153
20000000000002

'''