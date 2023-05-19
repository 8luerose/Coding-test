T = int(input())


for i in range(1, T+1):
    N, s, e, k = map(int, input().split())
    arr = [0] * N
    for j in range(N):
       arr[j] = int(input())
    sorted_list = sorted(arr[s-1 : e])
    K_th_number = sorted_list[k-1]
    print(f"#{i} {K_th_number}")
    