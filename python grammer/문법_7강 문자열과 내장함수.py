'''
문자열과 내장함수
'''

print('#예시1.')  #<1>
msg="It is Time"
print(msg)
print(msg.upper())  #문자열 대문자로 변환
print(msg.lower())  #문자열 소문자로 변환
print('원본: ',msg)
print()


print('#예시2.')  #<2>
tmp=msg.upper() #포인터 주소값이 아니라 strcpy처럼 배열로 복사
print(tmp,'\n')


print('#예시2-1.')    #<2-1>
print(tmp.find('T'))        #첫 T 발견 후 종료, 여기선 결과 1 출력됨
print()


print('#응용1.')      #<응용1>
sum=0
for i in range(len(tmp)):
    if tmp[i]=='T':
        sum=sum+1
        print(i, end=' ')
print()     #end=' ' 때문에 len길이까지 돌고 print() 붙어서 출력됨. 그래서 줄바꿈 역할 못하는것
print('sum:',sum,'이다','\n')          #sum: 2 출력
print('sum:',sum,'이다','\n',sep='')   #sum:2  출력


print('#예시3.')  #<3>
print('tmp:',tmp.count('T'))   #문자열 글자 개수 세어주는 함수. 배열 sum 변수 안쓰고도 한줄 내에서 카운트 가능
print(msg.count(' '))                   #띄어쓰기 개수 세어줌
print(tmp.count('a'))                   #문자열 내 a 없으면 0 출력
print()


print('#예시4.')  #<4>
print(msg)
print(msg[:4])      #[:n]= n-1까지 출력
print(msg[3:5])     #[3:5]=3~4(=5-1)
print()

print('#예시5.')  #<5>
print(len(msg))
for i in range(len(msg)):
    print(msg[i], end=' ')
print()

for x in msg:   #오류: range(msg) 문자열 str은 range에 담을 수 없다. len(msg) 한번 변환해줘야 range 가능
    print(x,end=' ')    #문자열 msg 에서 문자를 차례대로 꺼내서 x에 담음
print()


print('#예시6.')  #<6>
for x in msg:
    if x.isupper():     #문자 중에 대문자일 경우
        print(x, end=' ')
print()
for x in msg:           
    if x.islower():     #문자 중에 소문자일 경우
        print(x, end=' ')
print()
for x in msg:
    if x.isalpha():     #문자 중에 알파벳일 경우
        print(x, end='')
print()
print()

print('#예시7.')  #<7>
tmp='AZ'
for x in tmp:
    print(ord(x))   #문자열 tmp에서 문자 하나씩 꺼내서 x에 저장하고, ord(x) 이렇게 해당 문자의 아스키값 출력
print()

tmp='az'
for x in tmp:
    print(ord(x))
print()

tmp=65
print(tmp)
print(chr(tmp))
print(tmp+1)
print()


print('#응용2.')  #<응용2>
print(chr(65))  #chr(정수)->문자 출력
print(ord('A')) #ord(문자)->정수 출력
#print((ord(tmp))) ord는 문자를 아스키코드로 변환시키는 함수이므로, 정수65(tmp)를 문자로 볼 수 없다
print((chr(tmp+1))) #print(1+(chr(tmp))) 는 정수 + 문자 이므로 문법 오류, chr(tmp(정수)+정수) 해야
test='A'
print(ord(test))
print(ord(test)+1) #원리: ord()에서 아스키(정수)로 변환, +1하면 '정수+정수 값' 출력될 것
print()


print('#응용3.')  #<응용3>
str='This is Test Str'
for i in range(len(str)):
    if str[i].islower():
        print( chr ( ord(str[i])-ord('a') + ord('A') ) , end=' ')
        #str[i]=str[i].upper()
        #str[i]=chr( ord(str[i])-ord('a') + ord('A') )
        #str[i]='V'
print('\n',str,'\n')     #파이썬은 문자열 그대로 수정 불가, 복사, 재할당 해줘야함


