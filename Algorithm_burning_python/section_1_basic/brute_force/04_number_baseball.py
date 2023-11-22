
n = int(input())
hint = [list(map(int, input().split())) for _ in range(n)]


answer_cnt = 0

for a in range(1, 10):				# 100의 자리수 1xx ~ 9xx
	for b in range(1, 10):				# 10의 자리수
		for c in range(1, 10):			# 1의 자리수

			if (a == b or b == c or c == a):
				continue

			is_true = True
			for tmp in hint:										# 2차원 문자열의 각 행을 순회: hint[0]=[123, 1, 1]
				number = str(tmp[0])								# 2차원 배열 중 첫번째 열의 값
				strike = int(tmp[1])
				ball = int(tmp[2])
			
				current_strike = 0
				current_ball = 0
				
				if a == int(number[0]):								# 100의 자리수가 같으면
					current_strike += 1
				elif a == int(number[1]) or a == int(number[2]):	# 10의 자리수가 같으면
					current_ball += 1
				
				if b == int(number[1]):
					current_strike += 1
				elif b == int(number[0]) or b == int(number[2]):
					current_ball += 1
				
				if c == int(number[2]):
					current_strike += 1
				elif c == int(number[0]) or c == int(number[1]):
					current_ball += 1
				
				if (current_strike != strike or current_ball != ball): # 둘 중에 하나라도 맞지 않으면
					is_true = False
					break

			if (is_true == True):									# 한 번도 걸린 게 없으면
				answer_cnt += 1

print(answer_cnt)
			

			


'''
4
123 1 1		
356 1 0
327 2 0
489 0 1

# number, strike, ball 순서

= 2
'''