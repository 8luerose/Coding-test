'''
함수 만들기
'''

#예시 1
print("프린트 add 함수")
def add(a, b):
    c = a + b
    print(c)		#인자 받아서 프린트만 하는 함수
add(3, 2)

print('\n', "반환 add 함수.", sep = '')
def add(a, b):
    c = a + b
    return(c)
print(add(4, 5))	#바로 프린트 가능 return c 니까
print()

print("예시")
x = add(3, 2)		#변수에 반환값 담고, 그 변수 프린트
print(x)

#응용 1
print('\n', "응용 1.", sep = '')
print("반환값 프린트 해보기(콤마로 2개 print()도 가능):", end = ' ')
print(add(1, 2), add(2, 3))

print("함수를 인자로 받아서 함수 호출:", end =' ')
y = add(add(add(add(1, 2),3),4),5)	
print(y)

#예시 2
print('\n', "예시 2", sep = '')
def add(a, b):
    c = a + b
    d = a - b
    return (c, d)	#파이썬은 반환값 2개 가능하다 = 단, 튜플 형태로 반환 / ex(5, 1)
print(add(3, 2))

#예시 3
print('\n', "예시 3.", sep = '')
def isPrime(x):					#소수 구분 함수 True, False 형태로
    for i in range(2, x):		#2부터 x - 1 까지
        if (x % i == 0):		#2부터 증가하여 x - 1까지 i로 나눴을 때, 하나라도 나눠지는 게 있으면 -> 참.
            return (False)		#'나눌 수 있으면' = 소수가 아님
        else:
            return (True)		#'나눌 수 없으면' if(0)이므로 = 소수임
print(isPrime(4))
print()

a = [12, 13, 7, 9, 19]
for y in a:						#a에서 원소 하나 가져와서 y에 담고
    if isPrime(y):				#y가 소수라면, isPrime()은 True로 반환될 것. 즉 소수일 경우를 뜻함
        print(y, end = ' ')		#출력될 다음 값을 end = ' '로 한 줄로 표현
print()