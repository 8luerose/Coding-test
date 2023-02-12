'''
2강 변수 입력과 연산자
'''

a = input() #input()함수는 문자형으로 인풋된다
print(a)

b = input("1개만 입력: ")
print(b)
print(type(b))

a,b=input("숫자를 나눠서 두개 입력: ").split()
print(a,b)
print(a+b)  #문자형으로 인식하므로 붙어쓰기
print(type(a))
print(type(a+b))
c = a+b
print(c)    #a+b이나 C나 똑같은 문자형으로 인식
print(type(c))

d,e = input("일단 2개를 input()으로 입력: ").split()
print("타입 어떻게 받음?:", type(d))

print("문자->숫자로 변환 중")
d=int(d)
e=int(e)
print("변환 결과: ", type(d))
print(d+e)  #print(int(d) + int(e)) 이렇게도 가능하다

#input()은 문자형을 받지만, map(int,input())은 정수형을 받는다
f, g = map (int, input("map을 이용한 숫자 2개 입력: ").split())
print(f+g)
print(f-g)
print(f//g) #몫 5//3 = 1
print(f % g)    #나머지
print(f**g) #거듭제곱
