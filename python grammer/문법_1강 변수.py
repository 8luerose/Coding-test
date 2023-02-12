
'''
1강 문법
'''

#1변수와 출력함수
a=1
b=2
c=3
print(a,b,c,c+a)

d,e,f=4,5,6
print(d,e,f)


g,h=7,8
print(g,h)
g,h=h,g     #값 교환
print(g,h)

#변수 타입
a=12
print(a)
print(type(a))

a=12.345
print(a)
print(type(a))

a='12.345'
print(a)
print(type(a))


#출력방식
print("number")
a,b,c=1,2,3
print(a,b,c)
print("number",a,b,c)

print(a,b,c, sep=', ')  #sep은 ' ' 따옴표를 기준으로 변수 구분해라
print(a,b,c, sep='')
print(a,b,c, sep='\n')

print(a, end=' ')   #end 는 \n을 자동으로ㄴㄴ 대신 ' ' 따옴표 안의 값 넣어라
print(b, end='')
print(c)











