'''
개념
1. 부분집합은 2^n개가 존재한다. 넣을 건지 or 넣지 않을 건지 2개의 경우의 수가 있기 때문
	=공집합을 뺴면 2^n - 1개가 존재한다.
2. 부분집합 예시는 1 3 5 6 7 10 이렇게 있던 것중 sum에 더해주는 부분집합 1 5 6 이 있을때
	sum에 포함되지 않는 부분집합은 3 7 10 이다. 이렇게 두가지의 부분집합이 존재한다
3. 즉, 이 문제는 전체 - sum == sum 이 되는지 확인하는 문제이다.
	= 또 다른 부분집합 원소들(total - sum)의 합이 sum이 되는지 확인하는 문제이다.
'''
import sys

def DFS(L, sum):
    if (sum > total // 2):				#total 12일때 sum은 7이 될 수 없음 (total - sum == sum 이므로) 그 이상은 볼 필요없음
        return
    if (L == n):						#인덱스(레벨)L이 주어진 arr의 갯수와 같아지면 바닥까지 모두 찾은것
           if (sum == (total - sum)):	# total - sum == sum 이면 같은 부분집합이 존재한다는 것
                       print("YES")
                       sys.exit(0)		#프로그램 종료
    else:
           DFS(L + 1, sum + arr[L])		#인덱스(레벨) 하나 더 증가 시키고, 그 arr[인덱스]의 값을 부분집합의 원소로 쓰겠다(누적)
           DFS(L + 1, sum)				#인덱스(레벨) 하나 더 증가시키지만, 그 arr[인덱스]의 값을 부분집합의 원소로 쓰지 않겠다(누적x)
            

n = int(input())
arr = list(map(int, input().split()))
total = sum(arr)
DFS (0, 0)								#인덱스(레벨)0, 그걸 쓰는 sum의 초깃값 0으로 시작
print("NO")								#DFS를 끝까지 돌았는데도 return이 안되었다면 NO를 출력


'''
6
1 3 5 6 7 10
= YES
'''