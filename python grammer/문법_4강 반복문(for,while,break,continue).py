'''
반복문(for, while)
'''

a=range(10) #(0부터 시작) N - 1 까지 정수 리스트형태
print(list(a))

b=range(1,11)   # ,콤마  찍으면 시작범위와 <N 까지가 범위
print(list(b))

for i in range(5):  #0~4(N-1)까지
    print("hello")  #문자열은 " " , ' ' 적을 것

for i in range(1, 11):  #1부터 10(11-1)까지
    print(i)
print()

for i in range(0,10,+2):    #9(10-1)까지가 범위
    print(i)
print()

for i in range(10,0,-2):    #range(10, 0) j하면 감소 안됨. 감소는 인자 3개
    print(i)
print()

i=1
while i<=10:
    print(i)
    i=i+2
print()

i=10
while i>=1:
    print(i)
    i=i-5
print()
    
    
i=1
while True:
    print(i)
    if i==5:
        break
    i+=1
print()



for i in range(1,10):
    if i%2==0:
        continue
    print(i)
print()




for i in range(1,11):
    print(i)
    if i==5:
        break
else:       #만약 for: 구문에 break 없이 정상적으로 종료된다면 else 실행
    print(11)
print()




for i in range(1,11):
    print(i)
    if i>15:
        break
    if i==10:
        print("'10'까지 정상 종료")
else:
    print(11)
print()




for i in range(1,11):
    if i%2==0:
        continue
    print(i)
else:
    print(11)
print()




    
    
