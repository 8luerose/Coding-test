'''
개념
1. 전위 순회: '부' 왼 오
	중위 순회: 왼 '부' 오
    후위 순회: 왼 오 '부'
	= 본연의 일을 하는 위치에 따라 다름
2. 부모 x 2 = 왼쪽 자식 노드
	부모 x 2 + 1 = 오른쪽 자식 노드
3. DFS는 보통 '전위순회'
	= 병합정렬은 후위 순회
4. 깊이 우선 탐색 배운 것
'''

def DFS(v):
	if (v > 7):					#base case
		return
	else:
		print(v, end =" ")		#전위 순회
		DFS(v * 2)
		DFS(v * 2 + 1)
		# DFS(v * 2)
		# print(v, end =" ")		#중위 순회
		# DFS(v * 2 + 1)
		# DFS(v * 2)
		# DFS(v * 2 + 1)
		# print(v, end =" ")		#후위 순회

# if __name__ == "__main___":
DFS(1)

'''
전위순회 출력 : 1 2 4 5 3 6 7 
중위순회 출력 : 4 2 5 1 6 3 7 
후위순회 출력 : 4 5 2 6 7 3 1
'''