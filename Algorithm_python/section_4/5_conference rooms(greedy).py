'''
개념

그리디
1. '정렬' -> '최적해'를 찾는 과정 
2. 해당 문제는 '끝나는 시간'을 기준으로 정렬한다
= 예를 들어 3시에 끝났다면 시작 시간과 비교했을 때 같거나 커야 한다
3. 튜플: arr = 1,2,3 = ',' 콤마 붙여야 튜플로 인식
= 단, 튜플은 값을 변경할 수 없음. [(), ()] 리스트 튜플도 가능
4. 튜플 두번째 값을 '기준으로' 오름차순 정렬하기
= v.sort(key=lambda x:x[1])
+ <튜플 정렬>
	-첫번째 값을 기준으로 
    오름차순 정렬 =v.sort(key = lambda x : x[0])
    내림차순 정렬 =v.sort(key=lambda x : -x[0]) && v.sort(key=lambda x : x[0], reverse=True)
    -첫 번째 원소가 같은 경우 두 번째 원소로 정렬
    =v.sort(key = labmda x : (x[0], x[1]))
'''

n = int(input())
arr = []

for i in range(n):
    i, j = map(int, input().split())
    arr.append((i, j))						#'튜플' 자료형으로 시작, 끝 저장
arr.sort(key = lambda x : (x[1], x[0]))		#튜플 정렬 =두 번째 원소가 같은 경우 첫 번째 원소로 정렬

cnt = 0
end_time = 0							
for i, j in arr:							#비교하기 위해 끝나는 시간을 기록하는 용도
    if (i >= end_time):						#첫 시작은 무조건 됨. 끝나는 시간이 0이기 때문
        end_time = j						#끝나는 시간 기록(이따가 또 비교하기 위함)
        cnt += 1
print(cnt)    


'''
5
1 4
2 3
3 5
4 6
5 7

=3
(2, 3) , (3, 5), (5, 7) 회의실 이용 가능
'''