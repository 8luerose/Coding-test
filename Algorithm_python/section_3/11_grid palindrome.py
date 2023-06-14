'''
개념

1. 7x7 격자판에서 5개 회문 검사 
	= 0 1 2 '+ 5'
2. 행 7이므로 총 3x7번 검사 
	= (0 1 2 + 5) x 7
3. 회문은 N // 2 검사 
	= 5 // 2는 2인데 가운데는 검사 안함. 짝수는 모두 검사됨
4. *중요 문법* 파이썬에서 '리스트 전체 뒤집는 법'
	= arr[::-1]
5. 행은 arr[::-1]가능, but 열은 세로로 검사 
	= arr[i+n][j] != arr[i+5-1 -n][j]
    = i+n은 순서대로 열 증가, i+5-1 -n 은 거꾸로 (-1 2 ..)
6. for - for - for
	= for(0 1 2) - for(열) - 행 검사 - for(열 검사용)
** 	= 행 고정 5회 - 열 검사(i+k ~ i+N-1 -k)5회

*중요 문법*
- arr[::-1]
- arr[i][j:j+5] = arr[i][j+0], arr[i][j+1]..[j+4]
- for - else


넘 어려어...
'''
arr = [list(map(int, input().split())) for _ in range(7)]

cnt = 0
for i in range(3):
	for j in range(7):
		check_arr = arr[j][i:i+5]					#슬라이스= 리스트 전체가 check_arr에 저장됨 
		if (check_arr == check_arr[::-1]):			#리스트 전체 역순= arr[::-1]
			cnt += 1
		for k in range(2):
			if (arr[i+k][j] != arr[i+5-1 -k][j]):	#(세로 검사) 가 틀린게 있다면 break
				break
		else:
			cnt += 1

print(cnt)


'''

2 4 1 5 3 2 6
3 5 1 8 7 1 7
8 3 2 7 1 3 8
6 1 2 3 2 1 1
1 3 1 3 5 3 2
1 1 2 5 6 5 2
1 2 2 2 2 1 5

=3
'''