'''
중첩 반복문 (2중 for문)
'''
print("Hello", end = ' ')
print("World!", end = '')
print(' and Bye')
print("여기까지 'end' 설명")

print('K','O','R', sep = '')    #sep은 문자열 사이를 처리하는 방법이다. KOR 붙어 나옴옴
print('K','O','R')              #만약 아무것도 없다면 K O R 띄어쓰기 처리된다
print('K','O','R', sep = ' - ') #문자열 사이에 - 출력되는 것

print()

#예시1. 중첩 반복문
for i in range(5):
    for j in range(5):
        print(j, end = ' ')
    print()
print()

#예시2.
for i in range(5):
    print('i:', i, end = ' ')   #여기서 sep = '' 없으므로 'i: 0' 이렇게 띄어쓰기 됨
    for j in range(5):
        print('j=', j, sep = '', end = ' ')
        #여기서 sep은 'j=' 이거랑 j묶어 주는 역할!! , end = ' '는 j 가 0~4 까지니까 줄바꿈 안함
    print('엔터')   #for j 다 끝나면 실행됨
print()

#예시3. 별모양 찍기
for i in range(5):
    for j in range(5):
        print('*', end = ' ')
    print()
print()

#예시4.
for i in range(5):
    for j in range(i + 1):
        print('*', end = ' ')
    print()
print()

#예시5.
for i in range(5):
    for j in range(5 - i):
        print('*', end = ' ')
    print()
print()


#예시6. 내가 만든 삼각형 모양
tmp = int(input("삼각형 높이 한 자리 수 입력하세요: "))
for i in range(tmp):
    #print(' ' * ((tmp - 1) - i), end = '') 원본
    print(' ' * (tmp - (1 + i)), end = '')
    print('*' * (2 * i + 1))

'''
내가 쓴 풀이

높이 = 3 (0~2)일때

0: 1 / 2
1: 3 / 1
2: 5 / 0

1 = 0 * 2 + 1
3 = 1 * 2 + 1
5 = 2 * 2 + 1
따라서
* = i * 2 + 1

2 = 3 - 1(= 0 + 1)
1 = 3 - 2(= 1 + 1)
0 = 3 - 3(= 2 + 1)
따라서
' ' = 높이 - (i + 1)

'''

#마름모 해보기