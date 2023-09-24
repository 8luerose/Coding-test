'''
개념

1. 순열, 파스칼 응용 문제
2. 1 2 3 4 이렇게 있을 때, 최종 값은 1 + 2 + 2 + 2 + 3 + 3 + 3 + 4 = 20
3. 이런 식으로 1 + 2, 2 + 3, 3 + 4 -> 1 + 2 + 2 + 3 ... 더해진다
4. 문제에서 1 ~ N 까지라고 했으니, 이론적으로 나올 수 있는 가짓수는 N ! 팩토리얼
	= 4! = 4 * 3 * 2 * 1 = 24
	= N! = N * (N - 1) * (N - 2) * ... * 1
5. 그런데, 이렇게 모두 탐색하면 '시간 초과' 발생
6. 따라서, 규칙을 찾아야 한다. 
	= 1 + 2 + 2 + 2 + 3 + 3 + 3 + 4
	= 1 * 1 + (2 * 3) + (3 * 3) + 4 * 1
	= 1 + 6 + 9 + 4 = 20 바로 한 번에 나온다
	= 이런 식으로 규칙을 찾아야 한다
7. 이항계수
	= (a + b)^2 = a^2 + 2ab + b^2
	= (a + b)^3 = a^3 + 3a^2b + 3ab^2 + b^3
8. 이항계수를 이용하고, N이 4라면 4C0, 4C1, 4C2, 4C3, 4C4를 구한다
	= 4C0의 공식은 4! / (0! * 4!) = 1
	= 4C1의 공식은 4! / (1! * 3!) = 4
	= 일반항은 nCr = n! / (r! * (n - r)!)
9. 이렇게 구한 이항계수를 저장하고, N! 으로 나오는 모든 수에 대입한다
	= 예를 들어, 1 3 3 1 과 가장 윗줄로 예측하는 경우의 수 1 2 3 4 를 곱한다
	= (1 * 1) + (2 * 3) + (3 * 3) + (4 * 1) = 20
10. 딱 맞아 떨어지면 그 경우의 수가 정답 -> 1 2 3 4
11. check 리스트를 사용해서 중복을 방지한다
	= check = [0] * (n + 1) 만드는데, 0번째 인덱스는 사용하지 않고 실제 사용하는 인덱스는 1부터 시작한다
	= check[i] = 1 이면 i번째 인덱스를 사용했다는 의미
	= 예를 들어, 1,2,3 동전 중 1을 사용했다면 check['1'] = 1 이렇게 체크
	= check [0][1][0][0] 이런 식

12. 포인트는 3가지
	= p[L] = i 이렇게 설정되면 p[1] = 1 p[2] = 2 이런 식
	= p[L] * b[L] 이것은 => p[1] * b[1] 이런 식으로 '같은 걸'곱한다는 뜻
	= DFS(L + 1, sum + (p[L] * b[L])) 이것은 => DFS(1 + 1, 0 + (1 * 1)) 이런 식으로 '누적해서' 더한다는 뜻
	= b[i] = b[i - 1] * (N - i) // i	=> 앞에 숫자에 일정 부분 곱하고, 나눈다. 규칙찾기인셈. () b[i-1] => b[1 - 1]) * (N-i) => (4-1) 하고 i로 나눈다
'''
import sys

def DFS(L, sum):
	if (L == N and sum == M):			# 순열 조건 발견 시 출력
		for x in p:
			print(x, end = ' ')
		sys.exit(0)						# 프로그램 종료
	else :
		for i in range(1, N + 1):		# check[i] = 1 이면 i번째 인덱스를 사용했다는 의미
			if (ch[i] == 0):			# check[i] == 0 이면 사용하지 않았으면
				ch[i] = 1				# 사용했다고 기록
				p[L] = i				# 해당 깊이 위치에 사용된 i값을 담음-> m깊이만큼 담을 수 있고 꽉 차면 출력
				DFS(L + 1, sum + (p[L] * b[L]))	# (p[0] * b[0]) + (p[1] * b[1]) + (p[2] * b[2])은 (1*1) + (2*3) + (3*3) = 1 + 6 + 9 = 16
				ch[i] = 0				# D(L)해당 레벨 끝나고 돌아오면, check[i] = 1 아직 이 상태인것. 이제 다시 사용하지 않았다고 기록


N, M = map(int, input().split())
p = [0] * N								# 순열 1 2 3 4, 3 1 2 4
b = [1] * N								# 이항계수 1 3 3 1
ch = [0] * (N + 1)						# check 리스트
for i in range(1, N):					# 1 3 3 1 세팅
	b[i] = b[i - 1] * (N - i) // i		# 이항계수 구하기: 앞에 숫자에( b[i-1] => b[1 - 1]) * (N-i) => (4-1) 하고 i로 나눈다
DFS(0, 0)


# + 추가사항
# b[1] = b[0] * (4 - 1) // 1 
# = 1 * 3 		= 3 				여기서 b[0]는 1C0으로 1이기도 하고, b = [1] * N 으로 초기화
# b[2] = b[1] * (4 - 2) // 2 
# = 3 * 2 // 2 	= 3
# b[3] = b[2] * (4 - 3) // 3 
# = 3 * 1 // 3 	= 1
'''
4 16
= 3 1 2 4
'''