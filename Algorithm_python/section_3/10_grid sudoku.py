'''
개념

1. 행, 열, 그룹 체크용 배열 총 3개를 만든다
	= for - for = (행,열) - 그룹
2. 해당 값에 해당하는 인덱스를 증가시켜준다 = 값을 인덱스로 사용
	ex) row[arr[i][j]] = 1
3. if (sum(ch) == 9)라면, 모두 1씩 된 것.
(*주의* for로 한번씩 순회하지 말것! && ch[]=1 이므로 중복일시 9가 되지 않음)
4. check() 함수 만들어서 main 구성할 것

5. 그룹 체크
	- 4중 for문 작성할 것
    - group[arr[i * 3 + k][j * 3 + k]] = 1		#암기!! '[베이스 행*3 + 세밀도]'
		= 그룹 체크하는 알고리즘
		= 0~ 3~ 6~
          3~
          6~
          =이렇게 (0,0) (0,3) (0,6) ... (6,0) (6,3) (6,6) 그룹을 '구역별 검사' seting
          =i * 0 + k .. 이렇게 (3x3으로 구성된) 9가지의 그룹들을 검사 가능
	- if sum(group) != 9 이면 중복 발생했거나, 누락된 경우이므로 False 반환
	
    - 행, 열, 그룹까지 모두 False가 아니라면 True 반환
'''

def	check(arr):
    for i in range(9):				# 9 x 9 배열 탐색
        row = [0] * 10				# 행(=i)바뀔 때마다 리스트 초기화
        col = [0] * 10
        for j in range(9):
            row[arr[i][j]] = 1		#여기가 핵심! row[값] = row[리스트[행][열]] = 1~9 값을 인덱스로 사용
            col[arr[i][j]] = 1
        if ((sum(row)!= 9) or (sum(col)!= 9)):
            return False
    for i in range(3):				#012 345 678 가로 기준 '베이스 행'
         for j in range(3):			#012 345 678 세로 기준 '베이스 열'
             group = [0] * 10       #'그룹' 리스트 초기화
             for k in range(3):		#베이스 행*3 + 세밀도 행 중 '세밀도 행'
                 for s in range(3):	#베이스 열*3 + 세밀도 열 중 '세밀도 열'
                     group[arr[i * 3 + k][j * 3 + s]] = 1	#=group[배열[베이스행*3+세밀도][베이스열*3+세밀도]] = 1
             if (sum(group) != 9):	#구역의 합이 9가 아니면 False
                 return False
    return True						#(행, 열), 그룹 모두 False 아니라면 True 반환 (=check()함수의 마지막)
             
        

arr = [list(map(int, input().split())) for _ in range(9)]
if check(arr):
    print("YES")
else:
    print("NO")






'''
1 4 3 6 2 8 5 7 9
5 7 2 1 3 9 4 6 8
9 8 6 7 5 4 2 3 1
3 9 1 5 4 2 7 8 6
4 6 8 9 1 7 3 5 2
7 2 5 8 6 3 9 1 4
2 3 7 4 8 1 6 9 5
6 1 9 2 7 5 8 4 3
8 5 4 3 9 6 1 2 7

=YES
'''