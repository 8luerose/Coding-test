'''
개념

1. Anagram 을 list로 해결하는 방법
	= hashing 을 써서 해결한다
    = ex) str1[ord(x)]
    = 그렇다면 ord(x)는 무엇인가? "문자를 아스키 코드로 표현하는 함수"

2. 아스키코드
	= 대문자(A~Z) 65 ~ 90
    = 소문자(a~z) 97 ~ 122
    = 각 26개
    
3. **아스키코드를 해싱하는 방법
	= 대문자 A: (ord(x) ==65) '- 65' = 0
    = 0 ~ 25
    = 소문자 a: (ord(x) ==97) '- ?' = 0
	= 이 문제에선 arr = [0] * 52(==26 + 26) 라고 해석하므로! 
    = 0 ~ 25, 26 ~ 51 이어져서 나와야 함
    = 따라서 소문자 ?는 '- 71' 이다 
'''

a = input()
b = input()
str1 = [0] * 52					#0 ~ 25, 26 ~ 51 대소문자 해싱(리스트) 생성
str2 = [0] * 52

for x in a:						#첫번째 a = AbaAeCe
    if (x.isupper()):
        str1[ord(x) - 65] += 1	#[대문자 - 65] = [B(66) - 65] = [1] 
    else :
        str1[ord(x) - 71] += 1	#[소문자 - 71] = [c(99) - 71] = [28] = [25 + '3'] = a,b,'c'


for x in b:						#두번째 b = baeeACA
    if (x.isupper()):
        str2[ord(x) - 65] += 1	#[대문자 - 65] = [B(66) - 65] = [1] 
    else :
        str2[ord(x) - 71] += 1	#[소문자 - 71] = [c(99) - 71] = [28] = [25 + '3'] = a,b,'c'
        
# print(str1)					#[A~Z] 각 위치에 많이 나온만큼 +=1
# print(str2)

for i in range(52):				#range(52) == 51까지
    if (str1[i] != str2[i]):	#해당 위치에 담긴 내용물이 서로 다르냐? -> 그럼 Anagram 아님
         print("NO")
         break
else:							#for - else: for 정상 종료 시 else 실행
    print("YES")

'''
AbaAeCe
baeeACA

=Yes
'''