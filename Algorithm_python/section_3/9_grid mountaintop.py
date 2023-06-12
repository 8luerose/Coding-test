'''
개념(암기할 것 많음)

1. 가장 자리는 모두 0으로 초기화
- 첫행 .insert(0, [0] * n)		#자리 비우고 0번 인덱스에 새롭게 삽입
- 마지막행 .append([0] * n)		 #자리 비우고 마지막행 새롭게 삽입
- 첫 .insert(0, 0)				#해당 행의 0번 인덱스에 새롭게 삽입
- 끝 .append(0)					#해당 행의 마지막 인덱스에 새롭게 삽입

2. 상하좌우 탐색
if all(arr[i][j] > arr[i + dx[k]][j + dy[k]] for k in range(4)):

< *초특급 스킬* 반드시 암기 >
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

3. all(): 모두 참일 때 반환값 참
ex) if all():

'''
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

arr.insert(0, [0] * n)						#0번째 인덱스에 '추가'
arr.append([0] * n)							#마지막 행에 '추가'
for x in arr:								#2차원일때 1~n행 
    x.insert(0, 0)							#한 행 꺼내서, 그 중 0번 인덱스에, 추가
    x.append(0)								#한 행 꺼내서, 마지막 인덱스에, 추가

cnt = 0
for i in range(1, n + 1):					#0번, n+2는 0으로 초기화 됨
    for j in range(1, n + 1):				#따라서 1~n 까지 검사
        if all(arr[i][j] > arr[i + dx[k]][j + dy[k]] for k in range(4)):
               cnt += 1						#봉우리가 all 이라면 증가.
        # = 봉우리[i][j] > 주변[i + 상하좌우][j + 상하좌우]
		# = i,j 좌표를 '기준'으로 '상하좌우'를 'k번' 반복하며 검사
print(cnt)

'''
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

=10
'''