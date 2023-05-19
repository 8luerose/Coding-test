
x=7
if x==7:
    print("if문 == 같을 때 참")
    print("!=이면 다를 때 참")
    
y=input("y값 한 개를 입력하시오: ")
if y!=0:
    print("입력한 y값은 0이 아닙니다")

a=13
if a>=10:
    if a%2==1:
        print("a, 10이상의 홀수")   #조건에 들지 않으면 출력안됨

b=10
if b>0:
    if b<0:
        print("b, 10보다 작은 자연수")    #b가 10이므로 조건에 해당 안됨

c=7
if c>0 and c<10:        # c>0 and c<10 이런 식으로 비교
    print("c, 10보다 작은 자연수")

d=7
if 0<d<10:
    print("d, 10보다 작은 자연수")    #대소비교 파이썬 이런식으로도 가능
    

e=input("정수를 입력하세요: ")
e=int(e)
if e>0:
    print("양수")
else:
    print("음수")


print("if elif else 조건문 시작")
f=input("성적 한 개를 입력하시오: ")
f=int(f)
if f>=90:
    print('A')
elif f>=80:
    print("B")
elif f>=70:
    print("C")
elif f>=60:
    print('D')
else:
    print("F")


print("if elif else 조건문 시작")
g=input("성적 한 개를 입력하시오: ")
g=int(g)
if g>=90:
    print('A')
elif g>=80:
    print("B")
elif g>=70:
    print("C")
elif g>=60:
    print('D')

    
if g>=50:
    print("elif 아닌 if 절1 ")
if 40<g:
    print("elif 아닌 if 절2 ")

    
else:
    print("F")





