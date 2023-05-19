n, k = map(int, input().split())
a = list(map(int, input().split()))
res = set()								#*이게 포인트* set은 자료형(중복되지 않게 저장)

for i in range(n):
    for j in range(i+1, n):
        for m in range(j+1, n):
            res.add(a[i] + a[j] + a[m])	#set자료형은 .append(x) -> .add(o)
res = list(res)							#set자료형은 sort불가 -> 따라서 list(res)처럼 리스트화
res.sort(reverse = True)
print(res[k - 1])

#이번 단원에서 키 포인트
#set자료형: 중복되지 않게 저장 가능한 자료형
#set자료형은 .sort불가 -> 리스트화 시켜야함

'''
내가 작성한 코드

N, K = map(int, input().split())
arr = list(map(int, input().split()))

result = []
cnt = 0
for i in range(len(arr)):
    flag = 0
    for j in range(i):
        if (result[j] == arr[i]):
            flag = 1
    if (flag == 0):
        result.append(arr[i])
        print("%d" % result[cnt])
        cnt += 1
result.sort()
print(result)
print(result[K-1])
'''