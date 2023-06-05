str = input()

result = 0
for x in str:
    if (x.isdecimal()):					#문자.isdecimal = 0~9  ||  문자.isdigit = 2^21 포함 
        result = result * 10 + int(x)	#char이므로 -> int(문자) = 정수로 변경
print(result)

cnt = 0
for i in range(1, result + 1):			#약수 = 1~N
    if (result % i == 0):				#나누어 떨어지면 약수
        cnt += 1						#약수 세어준다
print(cnt)

'''
g0en2Ts8eSoft							#028 찾아준다
=28										#28 (=첫번째 0 무시한다)
6										#6 = 28의 약수의 개수
'''