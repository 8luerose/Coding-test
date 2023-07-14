'''

개념
1. 맨 왼,오 끝 부분 가져올 것이다
2. 둘 중 작은 부분을 가져온다
3. 마지막 부분을 기억하고 있어야 한다 (2골랐으면 2를 기억)
4. (2, L), (3, R) 처럼 리스트에 저장해놓고
5. 리스트 정렬한다 -> 작은 거 고른다
6. 반복

+ LRLL 이니까 4개 (문자열 갯수)
'''
n = int(input())
arr = list(map(int, input().split()))

i = 0										#lt 왼쪽 포인터
j = n -1									#rt 오른쪽 포인터
last = 0									#골랐던 마지막 값

result = ""									#LRLL 저장할 문자열
tmp = []									#(2,L) (3,R) 저장해둘 리스트

while (i <= j):
    if (arr[i] > last):						#왼쪽이 크면 (기준인 마지막 수 보다)
        tmp.append((arr[i], 'L'))			#튜플로 리스트에 저자 (key, value)
    if (arr[j] > last):
        tmp.append((arr[j], 'R'))
    tmp.sort()								#리스트를 정렬 (=key를 기준으로)
    if (len(tmp) == 0):						#리스트에 아무것도 담긴 게 없으면 브레이크
        break
    else :
        result = result + tmp[0][1]			#리스트에 추가 = 리스트 중[0]번째(arr[i]), 그 중 [1]번째('L')
        last = tmp[0][0]					#튜플 2개 중 [0]번째[0]	(1), (2) -> (1) -> ('1', 2) 
        if (tmp[0][1] == 'L'):				#골랐으면 i,j 이동시키기 위해 L, R골랐는지 판단
             i += 1
        else :
            j -= 1
    tmp.clear()								#(,), (,) 저장해둔 튜플들 제거
print(len(result))							#result = "LRLL" 해둔 거 세어줌
print(result)

'''
5
2 4 5 1 3
=4
LRLL

10
3 2 10 1 5 4 7 8 9 6
=3
LRR
'''