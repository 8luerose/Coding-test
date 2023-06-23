'''
개념 (솔직히 이번 문제 가볍게 봤음... 약점도 존재하고 깔끔하지 않은 문제랄까?)


dvd 갯수 최대 3개까지 가능
9개 곡 = 1~9까지의 합 = 45분
= 즉, 45분짜리 크기 3개도 가능. 근데 가성비 안 나옴
-> 이진탐색으로 '최소 몇 분'까지로 줄일 수 있는지 검사
-> 3개 dvd로 모든 곡들을 분할하여 담아낼 수 있는 용량이라면 답이 될 수 있다
-> 단, 그 용량 중에서 '최소 용량'을 찾아내고 싶은 것
'''
n, m = map(int, input().split())
arr = list(map(int, input().split()))

def dvd_count(capacity):		#dvd 몇 개 필요한지 세어주는 함수
    cnt = 1						#dvd 1개부터 시작
    sum = 0						#총합 몇 분짜리인지
    for x in arr:
        if (sum + x > capacity):#곡 하나 더 더해봤는데 용량보다 크면 
            cnt += 1			#그러면 dvd 한 장 더 필요하겠네~
            sum = x 			#dvd 한 장 더 늘어났으니, 새롭게 총합 스타트(다음 용량의 첫 곡)
        else:
            sum += x			#만약 용량 허용 범위이면 용량에 곡 추가
    return (cnt)				#이렇게 곡 돌면서 dvd 최소 몇 장 필요한지 알 수 있음


i = 1							#dvd생산을 위한 최소 용량 1 
j = sum(arr)					#dvd 크기가 될 수 있는 것 중 가장 큰 용량
result = 0
while (i <= j):
    mid = (i + j) // 2
    if (dvd_count(mid) <= m):	#m개를 넘지 않는 dvd갯수라면 가능
        result = mid			#mid가 가능하니까, 더 큰 용량은 무조건 되겠지?
        j = mid - 1				#따라서 무조건 되는 건 볼 필요없고, 더 작은 크기를 찾기 위한 초기화
    else:
        i = mid + 1				#m개를 넘을 정도로 허용 용량이 작을 때, 더 큰 크기를 찾기 위한 초기화
print (result)
        

'''
9 3
1 2 3 4 5 6 7 8 9

= 17
'''