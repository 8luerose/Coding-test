'''
2강. 문법
#변수 입력과 연산자
'''

a=input()
print(a)

b=input("입력하세요: ")
print(b)

a,b=input("숫자를 입력하세요: ").split()
print(a,b)
print(a+b)  #문자형으로 인식하므로 붙어쓰기
c=a+b
print(c)    #a+b 이나 C이나 똑같은 문자형으로 인식

print(type(a))
print(type(a+b))
print(type(c))

d,e=input("정수형을 인식할겁니다: ").split()
print(type(d))

d=int(d)
e=int(e)
print(type(d))
print(d+e)  #print(int(d)+int(e))


#아니면 이렇게도 가능하다
#f,g=map(  int, input("map을 이용한 숫자 입력 시: ").split()   )
f,g=map(int,input("map을 이용한 숫자 입력: ").split())
print(f+g)
print(f-g)
print(f//g) #몫  5//3=1
print(f%g)  #나머지    5%3=2
print(f**g) #거듭제곱


h=4.3
i=5
j=h+i
print(j)    #실수형+정수형=실수형


