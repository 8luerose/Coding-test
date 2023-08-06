'''
개념

1. 파이썬의 dictionary를 이용하면 된다
2. 딕셔너리 구조는 key, value로 이루어져있다
3. key는 영어, 문자, 숫자 모두 가능하다
4. 사용된 key의 value를 1에서 0으로 바꾸고,
	마지막에 사용되지 않고 그대로 1인 것을 찾아주면 되는 문제다
'''
n = int(input())
arr = dict()					#arr는 dict()구조

for i in range(n):				#전체 입력 받을 때
	word = input()				#key 입력받고
	arr[word] = 1				#그 arr[key]가 속한 value 1로 변경
for i in range(n - 1):			#사용한 key값 입력받을 때
	word = input()
	arr[word] = 0				#사용한 word(=key)참조해서 0으로 변경

# print(arr)
for key, value in arr.items():	#dict는 key,value 참조 가능 + arr.items()는 { , , }하나 꺼내온다
	# print(key, value)			#.items() -> key, value에 각각 담긴다
	if (value == 1):
		print(key)				#value가 1일 때, 그 key를 출력한다
		break


'''
5
big
good
sky
blue
mouse
sky
good
mouse
big

= blue
'''