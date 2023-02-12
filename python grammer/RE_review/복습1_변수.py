'''
1강 문법
'''

#변수와 출력함수
a = 1
b = 2
c = 3
print(a, b, c, c + a)

d, e, f = 4, 5, 6
print(d, e, f)

g, h = 7, 8
print(g,h)
g, h = h, g     #값 교환
print(g, h)

#변수 타입
a = 12
print(a)
print(type(a))

a = 12.345
print(a)
print(type(a))

a = "12.345"
print (a)
print(type(a))

#출력방식
print("number")
a, b, c = 1, 2, 3
print(a,b,c)
print("number", a, b, c)

#출력 옵션
print(a,b,c, sep=', ')  #sep은 ' '이렇게 따옴표를 기준으로 변수 구분하는 표시자를 출력
print(a,b,c, sep='')
print(a,b,c, sep='\n')

print(a, end=' ')   #end는 출력 다음줄 \n대신에 ' ' 따옴표 안의 값으로 대체
print(b, end='')    
print(c)