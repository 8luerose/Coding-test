'''
람다 함수
'''

#예시 1
print('\n', "예시 1", sep = '')
def plus_one(x):
    return (x + 1)
print(plus_one(1))
print()

plus_two = lambda x: x + 2		#'함수명 = lambda x: ' 하면 간단하게 x 내용에 무엇이 담길지 쓸 수 있다 ex) x + 2
print(plus_two(1))

#실패 예시
print('\n', "이렇게 하지마라", sep = '')	#lambda x 에는 x에 넘겨줄 값을 마련해줘야 함 x + 1 처럼
tmp = lambda x: print(x + 1)				#해당 코드 무의미: 인자 x를 받아서 lambda x에 넘겨줘야 하는데 넘겨줄게 없음
print(tmp(2))								#따라서 반환값은 'None'

#예시 2
print('\n', "예시 2", sep = '')
def plus_one(x):
    return (x + 1)

a = [1, 2, 3]
print(list(map(plus_one, a)))	#map(어떻게 적용시킬 것인가, 변수) 이런 형태이다. a꺼내서 plus_one에 매핑 -> list로 묶는다
print(list(map(lambda x: x + 1, a)))	# map(람다, a) = a 변수 꺼내서 람다 매핑 -> list로 묶는다
print('매핑하고 list()없이 쓸 경우:', map(plus_one, a))		#a가 리스트 인데, map이 list()에 담기지 않아서 이상한 주소값 출력
print()

print("람다식 특징\n", end = '') 
print("1: 불필요한 함수 남발 안 해도 됨\n", end = '')
print("2: 가독성 좋음\n", end = '')
print("3: 재활용 못함\n", end = '')