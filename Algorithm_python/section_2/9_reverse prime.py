'''
개념

9010 일 때
1.결과적으로 19가 나와야 한다
2.0은 제외한다 (0109 -> 19)
3.'뒤집는건 나머지를 이용해서 10의 자리씩 이동시킨다
4.뒤집은 게 소수라면 그 소수를 출력한다

*쫄지마라*
'''

def	reverse(x):
    result = 0
    while(x > 0):
        tmp = x % 10
        result = result * 10 + tmp
        x = x // 10						#파이썬에서 // = 몫
    return result

def	isPrime(x):
    if x == 1:							#*킬링포인트* = 1 단독으로 있을경우 소수 아님.(소수: 1과 자기자신)
        return False
    for i in range(2, (x//2) + 1):		#*킬링포인트* = 1~16이라면 '절반까지만 약수' ex)16 = 8 * 2 =중복
        if	x % i == 0:
            return False
    else:								#for - else: for가 아니라면 else라는 구문
        return True


n = int(input())
arr = list(map(int, input().split()))

for x in arr:
    tmp = reverse(x)					#9010 -> 19라는 결과값 반환
    if	isPrime(tmp):					#19가 소수인지 판단
        print(tmp, end = ' ')			#첫 줄 (=한줄)로 처리


'''
5
32 55 62 3700 250
=23 73
'''