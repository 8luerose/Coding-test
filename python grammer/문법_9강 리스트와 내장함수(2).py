'''
2차원 리스트 생성과 접근
'''
print("예시1")
a=[0]*3
print(a)
b=[1,2,3]*3     #그냥 []*N 하면 [  ] 대괄호 한 줄 안에 값이 담긴다
print(b)

print('\n',"예시2")
a=[[0]*3 for _ in range(3)]     #[ []*3 이렇게 1행 ], for 문 범위에 따라 반복한다/for _ =변수 안 담김
print(a)        #출력 시 개행 없이 한줄에 a 출력

a[0][1]=1       #a[i][j] i행 j열 수정
print(a)
a[1][1]=2
print(a)

print('\n',"예시3")
for x in a:     #2차원 리스트에서 한 행씩 꺼내서 x에 담긴다
    print(x)    #한 행인 x 출력
print()

for x in a:     #2차원 리스트 a에서 한 행씩 꺼내서 x에 담긴다/ 첫번째 x= 1행 
    for y in x: #한 행 안에서도 각 원소를 살핀다(반복한다)
        print(y, end=' ')
    print()     #중첩 하나 끝나고 개행, 이 자리 print()없으면 반복 끝나고 개행 없이 한줄 0 1 0 0 2..
print()
