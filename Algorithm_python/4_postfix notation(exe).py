'''
개념
1. 후위수식 연산 = 스택
2. 숫자는 들어가고, 연산자는 스택에서 2개 빼낸다
3. 스택의 top은 뒷자리로, 즉 5 2 + = 5 + 2
4. 연산 결과는 다시 push(append)
'''

arr = input()
stack = []

for x in arr:
    if (x.isdecimal()):					#arr 중 하나가 숫자인지 판별
        stack.append(int(x))			#문자열 중 x는 문자. 따라서 int()처리
    else :								#숫자가 아니다 = 연산자 일 떄
        if (x == '+'):
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            stack.append(tmp2 + tmp1)
        elif (x == '-'):
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            stack.append(tmp2 - tmp1)	#스택에 먼저 들어가있는것이 tmp2 = 연산자 앞에 위치
        elif (x == '*'):
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            stack.append(tmp2 * tmp1)
        elif (x == '/'):
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            stack.append(tmp2 / tmp1)
print(stack[0])							#스택 쌓여있는 모든 것 = 사실상 마지막 결과값 1개
# print(stack)

'''
352+*9-
= 12
'''