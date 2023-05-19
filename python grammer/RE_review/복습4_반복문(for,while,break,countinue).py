'''
반복문(for, while)
'''
a = range(10)	#(0부터 시작) N - 1 까지 정수 리스트 형태 완성
print(list(a))

b = range(1, 11)	# , 콤마 찍으면 시작범위와 ' < N' 까지가 범위
print(list(b))

for i in range(5):	# range(5) = 0 ~ 4(N-1) 까지
	#print("hello", end = ' ')	#print함수에서 end에 ' '문자 추가 가능
	print("hello")	#문자열은 "",''적을 것

for i in range(1, 11):	#range(1, 11) = 1부터 10(N-1)까지
	print(i, end = ' ')
print()

for i in range(0, 10, +2):	#0부터 9(N-1)까지인데 2씩 증가
	print(i, end = '')
print()

for i in range(10, 0, -1):	#range(10, 0(N-1)) (X) 불가. 감소는 인자 3개
	print(i, end = ' ')
print()

i = 1
while i <= 10:	#while문은 ()괄호 없어도 됨
	print(i)
	i = i + 2
print()

i = 10
while(i >= 1):	#while(i < 10) 	or	while i < 10  둘 다 가능 
	print(i)
	i = i - 3
print()




#심화
i = 1
while(True):	#while(True) = while(1)
	print(i, end = ' ')	#print()할 때 end 사용 가능 
	if i == 5:	#반복문 안에서 조건문 가능
		break
	i+=1		#증감 연산자 += -= 모두 가능
print()

for i in range(1, 10):	#range(1, 10)=시작1, 끝9(10-1)
	if i % 2 == 0:		#짝수일 때 패스하고 다시 반복문 돌리러가라
		continue
	print(i, end = ' ')
print()



#else 응용 Type 1 기본
for i in range(1, 11):
	if i == 5:
		break
	else:
		print(i, end = ' ')
print()

#else 응용 Type 2 (*중요*)
for i in range(1, 5):
	print(i, end = '')
	if i == 5:	#range(1, 5) == 1~4 이므로
		break
else:			#만약 for: 구문 안에 break 없이 정상 종료 시, else 실행
	print(' ', 11, sep = '')	#1234' '11 ('' 과 11 사이 sep = '')
	#print('', 11)	#sep 없으면 #1234 11 =이렇게 공백이 기본
print()

#else 응용 Type 3
for i in range(1, 11):
	print(i, end = '')	#맨마지막 10 뒤에도 end = '' 붙어서 끝남
	if i > 15:
		break
	if i == 10:
		print("'10'까지 정상 종료")
else:					#for 구문 break 없었으면 else 실행
	print(11)			#'10'까지 정상 종료 '\n' 개행문자 후 출력
print()

for i in range(1, 11):
	if i % 2 == 0:
		continue
	print(i, end = ' ')	#마지막 9 뒤에 end = ' '붙어서 나감
else:					#실행되는 이유 =for에 break 없이 정상 종료돼서
	print('for에 break 없음')
print()