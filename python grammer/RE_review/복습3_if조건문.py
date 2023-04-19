x = 7
if x == 7:
	print("if문 == 같을 때 참")
	print("!=이면 다를 때 참")

y = input("y값에 0을 입력하시오: ")
if y != 0:
	print("입력한 y값은 0이 아닙니다")
	print("해당 변수는", type(y), "이기 때문입니다")

print("\n\n")

a = 13
if a >= 10:
	if a % 2 == 1:
		print("a는 10이상의 홀수")	 #조건에 들지 않으면 출력안됨

b = 10
if b > 0:
	if b < 0:
		print("b는 10보다 작은 자연수")	#b가 10이므로 조건에 해당 안됨

c = 7
if c > 0 and c < 10:	# c>0 and c<10 이런 식으로 비교
	print("c는 10보다 작은 자연수")

d = 7
if 0 < d < 10:	 #대소비교 파이썬 이런식으로도 가능
	print("d는 10보다 작은 자연수\n")

e = input("정수를 입력하세요: ")
e = int(e)
print("문자로 입력-> e = int(e) 정수로 변환")
if e > 0:
	print("양수")
else:
	print("음수")

print('\n작은 따옴표\'\' 로 감쌈')
print("큰 따옴표\"\"로 감쌈\n")

print("if elif else 조건문 시작")
f = input("성적 한 개를 입력하시오: ")
f = int(f)
if f >= 90:
	print("A")
elif f >= 80:
	print("B")
elif f >= 70:
	print("c")
else:
	print("F")

print("if elif 조건문만")
g = input("성적 한 개를 입력하시오: ")
g = int(g)
if g >= 90:
	print("A")
elif g >=80:
	print("B")

if g >= 50:
	print("elif 아닌 그냥 if절 1")
if g < 40:
	print("elif 아닌 그냥 if절 2")
	
else:
	print("F")	#줄바꿈 했어도 if-else 는 짝이다