'''
개념
1. 순열, 조합의 경우 itertools 라이브러리를 사용해서 구할 수 있다.
	= import itertools
2. 이항계수 초기화: b[i] = b[i - 1] * (N - i) // i
	= 1 3 3 1
3. 주의점
	= 라이브러리 사용을 막는 회사도 있다
	= "어떤 조건을 제시해서 만족하는 원소만 뽑아서 만들어라" 나올 때는 안 통한다
	= 기본은 DFS, 재귀로 받는다고 생각해라
4. for tmp in it.permutations(arr, n):
	= 리스트 중 n개를 뽑는 모든 조합의 경우를 구해준다.
	= {1, 2, 3}...
	= 기본형: for tmp in it.permutations(arr):
5. for L, x in enumerate(tmp):
	= enumerate는 '인덱스'와 '값'을 동시에 반환한다
	= L은 인덱스, x는 값
	= L 0레벨일 때, 그에 해당하는 순열 1,2,3,4 중 1. 그리고 이항계수 담은 1,3,3,1 중 1
	= 같은 레벨의 값끼리 곱해준다 'x * b[L]' => sum += (x * b[L])
6. 순열 경우의 수 구하고(itertools) -> 인덱스, 값 L,x 이렇게 매핑(enumerate) 
	= -> 이항계수로 구한 값과 곱하기 해서 sum으로 == sum += (x * b[L])
	= -> sum이 최초 예상한 값과 같으면 -> 하나씩 꺼내서 출력 3,1,2,4

'''
import itertools as it


n, m = map(int, input().split())
b = [1] * n

cnt = 0
for i in range(1, n):
	b[i] = b[i - 1] * (n - i) // i						# 이항계수 초기화 1 3 3 1
arr = list(range(1, n + 1))								# arr 리스트에 1 ~ (N+1) - 1까지 담는다
for tmp in it.permutations(arr):						# 리스트에 있는 자료를 보고, 모든 순열의 경우를 구해준다.
	sum = 0
	for L, x in enumerate(tmp):							# enumerate는 '인덱스'와 '값'을 동시에 반환한다
		sum += (x * b[L])								# 이항계수 b[L] 곱하기 순열 1234 중 같은 레벨 것 곱하기
	if (sum == m):										# 정답과 같은 sum이 나왔다면
		for x in tmp:									# tmp는 in it.permutations(arr) 했던 '순열' {3, 1, 2, 4} 
			print(x, end = ' ')							# for 로 하나 씩 꺼내면서 출력하겠다
		break											# 사전 순 가장 앞에 있는 것 하나만 출력
'''
4 16
= 3 1 2 4
'''