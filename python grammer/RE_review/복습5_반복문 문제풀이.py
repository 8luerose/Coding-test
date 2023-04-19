'''
반복문을 이용한 문제풀이
1) 1부터 N까지 홀수 출력하기
2) 1부터 N까지 합 구하기
3) N의 약수 출력하기
'''

n = int(input())	#n = input() 하면 n에 문자형 담김. 따라서 range(정수,정수) 불가
for i in range(1, n + 1):
	print(i, end = ' ')
print()
