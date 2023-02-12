'''
중첩 반복문(2중 for문)
'''
print("Hello",end=' ')  #end는 줄바꿈 안하고 다음 라인과 이어준다. end=' ' 따옴표 안에 문자형으로.
print("World",end=' ')
print(' and Bye')
print("여기까지 'end' 설명")  #' ' 안에 또 ' '있으면 인식 못 함. 그리고 " ' 이것도 불가

print('K','O','R', sep='')  #sep은 '' 요 따옴표 안에 것들을 묶어준다 sep=' ' 따옴표 안에 처럼
print('K','O','R')
print('K','O','R',sep=' - ')

print()


#에시1.중첩 반복문
for i in range(5):
    for j in range(5):
        print(j, end=' ')
    print()
print()



#예시2. 
for i in range(5):
    print('i:',i,sep='',end=' ')
    for j in range(5):
        print('j=', j, sep='', end=' ')
        #여기서 sep은 'j=' 이거랑 j 묶어주는 역할, end=' '는 j가 0~4까지니까 줄바꿈 안하고 다음거랑 붙여줌 
    print('엔터') #for j 다 끝나면 실행됨
print()


#예시3.별모양찍기
for i in range(5):
    for j in range(5):
        print('*',end=' ')
    print()
print()


#예시4.
for i in range(5):
    for j in range(i+1):    #i는 0~4까지 이므로 i+1 해줘야 j의 시작이 1이 됨
        print('*',end=' ')
    print()
print()


#예시5
for i in range(5):
    for j in range(5-i):
        print('*',end=' ')
    print()
print()
