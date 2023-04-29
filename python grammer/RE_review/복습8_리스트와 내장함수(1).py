'''
리스트와 내장함수(1)
'''

print("빈 리스트")
a = []			#a는 [] 빈 리스트
b = list()		#b는 [] 빈 list()
print(a, b)		#빈 리스트 출력 시, []만 출력
print()



print("리스트 선언1")
a = [1,2,3,4,5]
print(a)		#리스트 a를 print(리스트)한 것. 따라서 [ ~ ] 이렇게 값들 출력
print(a[0])		#print(리스트[인덱스]) 가능
print()			


print("리스트 선언2")
b = list(range(1, 11))	#1~10 까지 리스트 출력
print(b, '\n')



print("변수 = 리스트 + 리스트")
c = a + b		#1~5 + 1~10 까지 출력. 왜? 리스트+리스트 가능
print(c)

d = [999]		#리스트
c= a + b + d	#리스트 + 리스트 + 리스트
print(c)
print()

print("extend()")
e = ['+']
c.extend(e)		#기존 c는 변경되는 단점있지만, 변수 줄일 수 있음 +리스트 추가도 가능
print(c)
print()



print("리스트에 추가1")
print(a)
a.append(6)		#1~5리스트 a에 6을 뒤에 추가(append)
print(a, ' len:', len(a))	#예시 출력. 1~6까지니까 길이 6

#*주의*
#a = [1, 2, 3]일 때
#b = a 하면 	2개의 리스트에 담는 것 X -> 2개의 리스트 '이름'을 붙인 것
#b.append(90) 하면 실제로 a와 b 모두에 90 추가됨
#따라서, b = a 대신 b = a[:] 하면 전체 복사됨


print("리스트에 추가2")
tmp = []
for i in range(10):
    tmp.append(i)
print(tmp)
print()

print("리스트에 추가3")
a.insert(3, 'a')	#a 리스트[3] 인덱스에 정수 or 문자를 삽입 /ex) a.insert(인덱스, 정수or문자)
print(a)
print(a, 'len:', len(a), '\n', sep = '__')	#+기본적으로 end = , sep = 은 맨 마지막위치




print("리스트 pop(), 리스트.remove()")
a.pop()
print(a)			#pop() 기본형 = 가장 마지막꺼 pop / pop =꺼내라
print(a.pop())		#이렇게도 가능
a.pop(2)			#a.pop(N): 인덱스 N번째를 pop하라
print(a)
a.remove('a')		#a.remove('a')리스트에 ()괄호 안에 있는 값 발견되면 삭제
print(a)
print()



print("리스트.index()")
print(a.index(2))	#a.index(2): 2가 위치한 인덱스 반환
print()

print("min()")
print(min(7, 5))	#min(): 괄호 안에 7, 5 중 가장 작은 정수
print(min(7, 3, 5))	#min(7,3,5): 7,3,5 중 가장 작은 정수
print(min(a))		#min(리스트): 리스트 중 가장 작은 정수
print()



print("리스트 가공하기 sum(), max(), min()")
a = list(range(1, 11))
print(a)
print(sum(a))		#sum(리스트): 리스트의 모든 합
print(max(a))		#max(리스트): 리스트 중 최대값
print(min(a))
print()



print("import random")
import random		#파이썬 랜덤모듈, 랜덤으로 숫자를 출력해주는 모듈/ 아용하겠다~ 선언
random.shuffle(a)	#random 모듈안에 있는 함수 .shuffle(리스트): 리스트 섞어라
print(a)

print("import random as r")
import random as r	#편의상 random모듈을 r이라고 표현하겠다.
r.shuffle(a)
print(a)



print("a.sort()")
a.sort(reverse = True)	#a.sort(): 리스트 a를 정렬
#*주의* reverse = 1 (O), reverse = true (X) / 'True' 대신 'true' 소문자로는 변경 불가
print(a)
a.sort()
print(a)
print()
#*주의*
# b = a.sort(reverse = 1)	#불가
# sort()는 내부 요소 같아야 가능하다



print("b = a.copy, c = a[:]")
b = a.copy()				#새 리스트 = 복사 할 리스트명.copy()
print(b)
c = a[:]					#새 리스트 = 복사할 리스트명[:]
print(c)
print()



print("a.sorted()")
d = sorted(a)				#sorted(리스트): 리스트 오름차순 정렬해서 담기
print(d)
d = sorted(a, reverse = 1)	#sorted(리스트, reverse = 1): 리스트 내림차순 정렬
print(d)
#sort()는 원본 정렬( a.sort() ) / sorted()는 사본정렬 (d = sorted(a))
print()

print("a.clear()")
a.clear()					#리스트명.clear(): 리스트 안에 내용 모두 초기화 됨
print(a)
print()

print("b = a 응용")
a = list(range(1, 10))
b = a
a.clear()					#a.clear()했어도 b = a 이므로 b위치는 a위치와 같음
print(b)					#따라서 b도 삭제된 것

a = [1, 2, 3]
b = a						#위와 동일하게 b = a 는 마치 포인터를 담은 것
b = []
print(b)