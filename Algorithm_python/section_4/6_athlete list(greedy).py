'''

개념
1. 키를 기준으로 내림차순 정렬
2. 내 앞에 있는 사람보다 몸무게가 더 크다면 선수 가능
= 내 앞에 있는 사람(내림차순)은 키로는 이길 수 없으므로
3. 그렇다면 나를 기준으로 앞으로 한 번씩 for 돌리느냐?
= No. 왜냐하면 Max 로 가능
= Max가 몇 번 나오는지 위에서부터 Count해주면 된다
= 내림차순 정렬되어 있기 때문에 몸무게 큰 사람 구할 수 있다
4.튜플 추가법
= for - arr.append((a, b))

(복습)
5. 튜플: arr = 1,2,3 = ',' 콤마 붙여야 튜플로 인식
= 단, 튜플은 값을 변경할 수 없음. [(), ()] 리스트 튜플도 가능
6. 튜플 두번째 값을 '기준으로' 오름차순 정렬하기
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
    a, b = map(int, input().split())
    arr.append((a, b))					#튜플로 리스트에 추가
arr.sort(reverse = True)				#'첫번째 키'를 기준으로 내림차순 정렬

max = 0
cnt = 0
for height,weight in arr:
    if (weight > max):
        max = weight
        cnt += 1
print (cnt)

'''
5
172 67
183 65
180 70
170 72
181 60

= 3
'''