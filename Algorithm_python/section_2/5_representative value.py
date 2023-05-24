N = int(input())
arr = list(map(int, input().split()))

avg = int((sum(arr) / N ) + 0.5)		#반올림 처리 = int(A + '0.5') 
min = float('inf')
#min = 2147000000						#이렇게 초기화도 가능

for i, x in enumerate(arr):				#enumerate = 인덱스, 값 담는 반복문 함수
    diff = abs(x - avg)					#abs() = 절댓값 구하는 함수 
    if diff < min:						
        min = diff						#min = diff 최솟값을 현재 diff로 교체 
        score = x
        student_num = i
    elif diff == min:					#74 기준으로 73, 75는 각각 1차이
        if x > score:					#더 점수가 클 때, 즉 75 > 73이면
            score = x					#점수가 큰 것을 score(비교 기준)로 교체
            student_num = i
            
print(avg, student_num + 1)

#정리
#즉, 74 기준일 때 73이면 차이가 1. 75이면 차이가 1. 차이가 같지만 큰 수인 75로 교체
#75로 교체했는데, 75를 새롭게 마주했을 때 가장 빠른 인덱스인 첫 75으로 고정 유지 

#오류 수정 추가
#avg = round(sum(arr) / N)				#round = round_half_even방식
#round_half_even: 4.5 처럼 되어있을 때 짝수 쪽으로 변경됨. (4.51이면 반올림 처리)
#예시 1) 4.5 -> 4	2) 5.5 -> 6		+)4.51 -> 5


'''
내가 작성한 코드

N = int(input())
arr = list(map(int, input().split()))

sum_result = sum(arr)
print("합계:", sum_result)
avg = sum_result / len(arr)
#avg = sum_result / N			#이렇게도 가능
print("평균:", avg)

avg_cp = avg
for i in range(N):
	if arr[i] > avg:
		avg_cp = arr[i]
		num = i
print(avg, num)
'''

'''
입력예시

10
45 73 66 87 92 67 75 79 75 80

=74 7 
'''