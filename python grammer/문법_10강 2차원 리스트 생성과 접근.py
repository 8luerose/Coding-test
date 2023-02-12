'''
2차원 리스트 생성과 접근
'''

print("예시 1.") #예시1
a=[0]*3
print(a)
b=[1,2,3]*3     #이렇게 하면 1 2 3이 *3 되어서 한 줄에 쭈루룩 저장된다
print(b)

print('\n',"예시 2",sep='')   #예시2
a=[[0]*3 for _ in range(3)]  #[0]*3 을 for _ (변수 없는 _) 반복문 돌려서 리스트 묶음으로 담는다
print(a)

a[0][1]=1
print(a)
a[1][1]=2
print(a)

print('\n',"예시 3",sep='')   #예시3
for x in a:     #a에서 한 행 꺼내서 x에 담는다
    print(x)

for x in a:     #a에서 한 행 꺼내고
    for y in x: #한 행 중에서 한 원소 씩 꺼낸다
        print(y,end=' ')
    print()     #줄바꿈

    
