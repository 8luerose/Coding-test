'''
개념
1. 킬로그램을 넘지 않는 최대의 무게를 구하는 문제이다.
2. 부분집합으로 해결한다
3. 부분집합들 중 주어진 킬로그램에 가장 근접한 값을 구하면 된다
4. 부분집합을 구하기 위해 DFS를 사용한다
5. **시간 초과 최적화 필요
	= 앞으로 따질 것이 기존 것보다 작으면 따질 필요가 없다
    = if (sum + (total - tsum) < result)
    = 그동안 더한 부분집합의 합이 주어진 킬로그램 '조건'을 넘어가면 그건 더이상 볼 필요가 없다
    = if (sum > c)
'''
import sys
def DFS(L, sum, tsum):					# tsum은 포함할거냐 안할거냐 선택한것들, sum은 부분집합
    global result						# result = sum(=지역변수 화) 할거니까 global로 result 선언. 즉, main 부분에서 선언한 result를 쓰겠다
    if (sum + (total - tsum) < result):	# total - tsum은 더해지지 않은 부분집합의 합이다. = (지금까지 더한 부분집합의 합 + 더해질 부분집합)의 합이 기존 MAX인 result 보다 작으면 따질 필요없음
         return
    if (sum > c):						# 그동안 더한 부분집합의 합이 주어진 킬로그램을 넘어가면 그건 더이상 볼 필요가 없다
          return
    if (L == n):						# 인덱스(레벨)L이 주어진 arr의 갯수와 같아지면 바닥까지 모두 찾은것
         if (sum > result):				# 지금 모두 더한 부분집합 더한값이, 그동안의 최댓값보다 크면 MAX인 result에 담는다
               result = sum
    else:
         DFS(L + 1, sum + arr[L], tsum + arr[L])
         DFS(L + 1, sum, tsum + arr[L]) 
         

if __name__ == "__main__":
    c, n = map(int,input().split())
    arr = [0] * n
    result = -2147000000
    for i in range(n):
        arr[i] = int(input())
    total = sum(arr)					# total은 arr의 모든 원소의 합
    DFS (0, 0, 0)						# 초기화 부분: 인덱스(레벨)0, 그동안 다 더한 sum의 초깃값 0, tsum은 포함할거냐 안할거냐 선택한것들
    print(result)
'''
259 5
81
58
42
33
61

=242
'''