'''

개념
1. M개(;회) 숫자를 제거한다
2. 나보다 앞에있는(왼쪽) 숫자가 나보다 작으면 내가 그 자리를 뺏고 맨 앞으로 간다
3. 만약 내 앞에 것들이 나보다 크면 나는 그냥 바로 뒷자리로 붙는다
4. 만약 M회 숫자를 모두 제거했다면, 바로 뒷자리로 붙는다
5. Stack 자료구조로 해결한다
6. 파이썬에서는 Stack 자료구조를 갖고 있는 것이 아니라, 
	그냥 '리스트로' pop, append 함수를 쓰면 된다
7. string으로 받고, 리스트화 시킨다
'''

num, m = map(int,input().split())
num = list(map(int, str(num)))						#정수->문자열->정수->list화 = list(map(int, str(정수)))
stack = []

for i in num:
    while (stack and m > 0 and (stack[-1] < i)):	#stack 존재, m 횟수 남았고, 마지막 스택 투입이 나보다 작을 때
            stack.pop()
            m -= 1
    stack.append(i)									#while 다 돌고 나보다 작은거 다 pop시켰으면, 이제 나를 추가
if (m != 0):										#만약 m 횟수 남았으면
      stack = stack[ : -m]							#stack의 마지막에서 m만큼 뺀([:n] = -n) 나머지 들이 stack에 남는다

#case(1) 정수형 리스트 -> 문자열 -> ''이렇게 붙여서 연결짓는다
result = ''.join(map(str, stack))					#''.join = ''이렇게 붙여서 구분짓는다, map(str, stack) = [7,8,2,3] -> 7 8 2 3
print(result)

#case(2) 그냥 결과 리스트 stack을 for반복해서 출력한다
for i in stack:
    print(i, end = '')


'''
5276823 3
7823

9977252641 5
99776
'''