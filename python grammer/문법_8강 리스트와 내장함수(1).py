'''
리스트와 내장함수(1)
'''

#import random as r
a=[]
b=list()
print(a,b)

a=[1,2,3,4,5]
print(a)
print(a[0])
print()

b=list(range(1,11)) #1~10까지 리스트출력
print(b,'\n')

c=a+b               #1~5 + 1~10 까지 출력. 왜? 리스트끼리니까
print(c)

d=[1]               #리스트
c=a+b+d             #리스트+리스트+리스트
print(c)
print()

print(a)        
a.append(6)         #1~5에서 6을 추가(append)
print(a,'  len:',len(a))

a.insert(3,'a')       #a 리스트[3]에 정수or문자를 삽입, 나머지는 뒤로 밀림
print(a,'len:',len(a),'\n',sep='__')

a.pop()             #기본형: 가장 마지막꺼 pop
print(a)             
a.pop(2)            #pop(N) 인덱스 N번째꺼 pop하라
print(a)
a.remove('a')       #a리스트에 ( )괄호 안에 있는 값 발견되면 삭제
print(a)

print(a.index(5))   #리스트 a중 ( )괄호 안에 있는 값에 해당하는 인덱스 발견하라
print(a.index(2))   #리스트 중 2에 해당하는 인덱스 발견하라
print()

print(min(7, 5))    #min( ): 괄호 안에 중 가장 작은 정수
print(min(7,3,5))
print()

a=list(range(1,11))
print(a)
print(sum(a))
print(max(a))       #max(): 괄호 안에 중(지금 같은 경우는 a리스트) 가장 큰 정수
print(min(a))
print()

import random
random.shuffle(a)
print(a)

import random as r  #이름 설정은 ' as ~ '
r.shuffle(a)
print(a)

a.sort(reverse=True)    #True를 1로 바꿀 수 있으나 true 소문자로 변경할 수 없음
print(a)

a.sort()            #오름차순(기본형)
print(a)

a.clear()
print(a)
