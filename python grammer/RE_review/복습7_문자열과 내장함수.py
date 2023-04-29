'''
문자열과 내장함수
'''
#<1>
print("# 예시1")    
msg = "It is Time"
print(msg)
print(msg.upper())  #문자열 대문자로 변환
print(msg.lower())  #문자열 소문자로 변환
print('원본: ', msg)
print()

#<2>
print("# 예시2")
tmp = msg.upper()   #포인터 주소값이 아니라 strcpy처럼 배열로 복사
print(tmp, '\n')

print("# 예시2-1")
print(tmp.find('T'))    #find()는 해당 문자열 중 발견된 인덱스 반환. 첫 T 발견 후 종료.
print(tmp.find('m'))    #find()는 만약 문자열에서 발견 못 할 시 -1 반환
print(tmp.find('S'))    #tmp 가 .upper() 되었기 때문에 S 위치는 4
tmp_find = tmp.find('S')#정수형으로 반환되므로 변수에 저장 가능
print(tmp_find)			#변수가 int 형이므로 print(int) 바로 가능
print()

###
print("# 응용1")
sum = 0
for i in range(len(tmp)):
    if tmp[i] == 'T':			#문자열 == '문자' 라면
        sum = sum + 1
        print(i, end = ' ')		#(1) end = ' ' 이기 때문에 뒷 줄 붙어서 출력됨
print()							#(2) 따라서 print()해줘야 1 6 ~  ->  1 6 \n ~
print('sum:', sum, '이다')				#sum: 2 이다 출력
print('sum:', sum, '이다', sep = '')	#sum:2이다 출력
print()

#<3>
print('# 예시3')
print('tmp:', tmp.count('T'))	#.count() = 문자열 글자 개수 세어주는 함수 (sum 변수 안 쓰고도 한줄 내에서 카운트 가능)
print(msg.count(' '))			#띄어쓰기 개수 세어줌
print(msg.count('a'))			#문자열.count('문자') 했는데 없으면 0 출력
print()

#<4>
print('# 예시4')
print(msg)			#문자열 전체 출력 가능
print(msg[:4])		#[:n] = n-1 까지 문자열 그대로 출력
print(msg[3:5])		#[3:5] = 3~4(=5-1) 문자열 그대로 출력
print()

#<5>
print('# 예시5')
print(len(msg))
for i in range(len(msg)):
    print(msg[i], end = ' ')
print()

###이렇게도 가능 + range() 사용법
for x in msg:		#if, range()일 때는 정수 써야 한다. len(msg)처럼. = 문자열 str은 range에 담을 수 없다(오류발생)
    print(x, end = '')
print('\n')			#print() 이렇게 하면 한줄 출력. print('\n')은 \n 이후에 한줄 출력

#<6>
print('# 예시6')
for x in msg:
    if x.isupper():		#if 문자.isupper() = 문자 중에 대문자일 경우
        print(x, end = ' ')
print()

for x in msg:
    if x.islower():		#문자 중에 소문자일경우 if x.islower()
        print(x, end = ' ')
print()

for x in msg:
    if x.isalpha():		#문자 중에 알파벳일경우 if x.isalpha()
        print(x, end = ' ')
print('\n')

#<7>
print('# 예시7')
tmp = 'AZ'
for x in tmp:
    print(ord(x))		#ord('문자') = 해당 문자의 아스키값 출력
print()

tmp = 'az'
for x in tmp:
    print(ord(x))
print('\n')

tmp = 65
print(tmp)
print(chr(tmp))			#chr(정수) = 문자 출력 
print(tmp + 1)
print(chr(tmp + 1))
print()

#<응용2>
print('#응용2')
print(chr(65))			#chr(정수)->문자 출력
print(ord('A'))			#ord(문자)->정수 출력
tmp = 65
#print(ord(tmp))		#ord(문자)는 문자->아스키 이므로 ord(정수)를 문자로 볼 수 없다
print(chr(tmp + 1))		#print(1 + chr(tmp))는 문법 오류(정수 + 문자), chr(정수 + 정수) 가능
test = 'A'
print(ord(test))
print(ord(test) + 1)	#원리: ord()에서 아스키(정수)로 변환, +1 하면 '정수+정수' 출력됨
print()



#<응용3>
print('응용3')
str = "This is Test Str"
for i in range(len(str)):
    if str[i].islower():
        print(chr(ord(str[i]) - ord('a') + ord('A')), end = ' ')
        #대문자 변환 로직: 소문자 - 'a' = 거리 // 거리 + 'A' = A에서부터 출발한 대문자
print('\n', str, '\n')


print('+코드 참고')
str = "This is Test Str"
for i in range(len(str)):
    #str[i] = str[i].upper()	*파이썬은 문자열 그대로 수정 불가->복사,재할당 해줘야함
	#str[i] = chr(ord(str[i]) - ord('a') + ord('A'))	*재할당 불가
	#str[i] = 'v'				*재할당 불가
	continue					#for : 안에 아무것도 없으면 안돼서 continue 넣어줌
print()
