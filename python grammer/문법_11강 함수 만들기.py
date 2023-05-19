'''
함수 만들기
'''

print("예시 1.")  #예시1
print("프린트 add 함수")
def add(a,b):
    c=a+b
    print(c)        #인자 받아서 프린트만 하는 함수

add(3,2)


print('\n',"반환 add 함수",sep='')
def add(a,b):
    c=a+b
    return c

print(add(4,5))     #바로 프린트 가능 return c 니까

x=add(3,2)          #변수에 함수 값 담고, 그 변수 프린트
print(x)




print('\n',"응용 1.",sep='')  #응용1

print("반환값 프린트 콤마 찍어서:",end=' ')
print(add(1,2),add(2,3))

print("함수를 인자로 받아서 함수 호출:",end=' ')
y=add(add(add(add(1,2),3),4),5) #이론 상:1+2 +3 +4 +5=15
print(y)




print('\n',"예시 2.",sep='')  #예시2
def add(a,b):
    c=a+b
    d=a-b
    return c,d      #파이썬은 반환값 2개 가능하다= 단, 튜플 형태로 반환 /ex(5, 1)
print(add(3,2))




print('\n',"예시 3.",sep='')  #예시3
def isPrime(x):     #소수 구분 함수 True, Fasle 형태로
    for i in range(2,x):    #2부터 x-1까지
        if x%i==0:          #2부터 x-1 사이 값이 i인데, x가 나눠진다면 자기 자신 빼고도 나눠지는 것
            return False    #'자기 자신 외에도 나눌 수 있으면' 소수가 아님
    return True             #자기 자신으로만 나눌 수 있으면 소수임  (정의: 1과 자기 자신만 유일)

a=[12,13,7,9,19]
for y in a:         #a에서 원소 하나 가져와서 y에 담고
    if isPrime(y):  #y가 소수라면, True 반환될 것(반복문 돌면서 한 번도 False가 나오지 않았던 것)
        print(y, end=' ')   #출력될 다음 값을 end=' '로 한 줄로 표현


