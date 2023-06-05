
#**중요 포인트** 
# '문자열[::-1] = 문자열 거꾸로 변환한 값 (복사x 자체값o)' 

n = int(input())
for i in range(n):
    str = input()					#문자열 그냥 input()으로 받음
    str = str.upper()				#문자열 전체 .upper()가능
    size = len(str)
    for j in range(size // 2):
        if (str[j] != str[-1 - j]):	#문자열[-1] = 맨 마지막 문자
            print("#%d NO" %(i+1))	#("%d" %(값)): %d = %값 대응
            break
    else:
        print("#%d YES" %(i+1))


# 이렇게도 가능
# n = int(input())
# for i in range(n):
#     str = input()					#문자열 그냥 input()으로 받음
#     str = str.upper()				#문자열 전체 .upper()가능
#     if str == str[::-1]:			#[::-1] = reverse, 문자열 서로 같은지 비교
#         print("#%d YES" %(i+1))
#     else:
#         print("#%d NO" %(i+1))


'''
5
level
moon
abcba
soon
gooG								#소문자, 대문자 똑같다고 가정

=
#1 YES
#2 NO
#3 YES
#4 NO 
#5 YES
'''