T = int(input())

for i in range(T):
    n, s, e, k = map(int, input().split())
    a = list(map(int, input().split()))
    a = a[s-1 : e]
    a.sort()
    K_th_number = a[k-1]
    print(f"#{i+1} {K_th_number}")
    #print("#%d %d" %(i+1, a[k-1]))		이렇게도 가능하다
    
'''
#기존에 내가 쓴 코드

for i in range(1, T+1):
    N, s, e, k = map(int, input().split())
    arr = [0] * N
    for j in range(N):
       arr[j] = int(input())
    sorted_list = sorted(arr[s-1 : e])
    K_th_number = sorted_list[k-1]
    print(f"#{i} {K_th_number}")
'''

'''
입력

2
6 2 5 3 
5 2 7 3 8 9 
15 3 10 3
4 15 8 16 6 6 17 3 10 11 18 7 14 7 15

출력
#1 7
#2 6
'''