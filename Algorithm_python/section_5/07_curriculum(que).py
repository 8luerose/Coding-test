'''
개념
1. que에 교육과정인 CBA 담는다
2. 순서대로 이수해야 하기 때문에, 입력받은 문자열과 que를 비교해가며 같을 때 pop한다
3. 그런데 만약 que에 남는 게 있다면 그것은 잘못된 것이다. 따라서 NO처리
'''

from collections import deque

input_arr = input()
n = int(input())
for i in range(n):
    plan = input()
    Q = deque(input_arr)					#매번, plan 입력 후 que를 초기화 해주는 것 = deque(입력받은 문자열)
    for x in plan:							#plan은 문자열, 문자열 하나하나 문자로 꺼내서 for돌린다
        if (x in Q):						#'문자열 안에 문자 있어?' = 문자 in 문자열 (파이썬이 진짜 개미친 이유) 
            if (x != Q.popleft()):			#문자열 안에 우리가 찾는 x가 있는데, '제일 앞에 것' 꺼내보니까 다르다? -> 교육과정대로 안했구만
                    print("#%d NO" %(i + 1))
                    break
    else :									#더 이상 꺼낼 문자열(plan)이 없을 때
        if (len(Q) == 0):					#Q에 남아있는 게 없이 모두 비었으면 참
            print("#%d YES" %(i + 1))
        else :								#Q에 어랏? 남은 게 있으면 거짓~
            print("#%d NO" %(i + 1))


'''
CBA
3
CBDAGE
FGCDAB
CTSBDEA

=
#1 YES
#2 NO
#3 YES

AFC
1
AFFDCCFF

=
#1 YES
'''