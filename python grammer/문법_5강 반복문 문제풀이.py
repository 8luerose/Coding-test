'''
반복문을 이용한 문제풀이
1) 1부터 N까지 홀수 출력하기
2) 1부터 N까지의 합 구하기
3) N의 약수 출력하기
'''

n= int(input())     #n=input() 하면 n에 문자형 담김. 따라서 range(정수,정수) 불가
for i in range(1,n+1):
    print(i)
print()


#1부터 N까지 홀수 출력
N=int(input())
for i in range(1,N+1):
    if i%2==1:  #if(i%2 == 1)도 가능
        print(i)
print()


#1부터 N까지의 합 구하기
N=int(input())
sum=0
for i in range(1,N+1):
    sum=sum+i
print(sum)
print()


#N의 약수 찾기
N=int(input())
for i in range(1,N+1):
    if N%i == 0:
        print(i, end= ' ')
        #print( , end= ' ') 하면 줄 바꿈 안하고 옆으로 출력, 단 end=' ' 따옴표 안에 출력
print()
    


