'''
람다 함수
'''

print('\n',"예시 1",sep='')   #예시1
def plus_one(x):
    return x+1
print(plus_one(1))

plus_two=lambda x: x+2      #이게 람다식(=메소드 굳이 적지 않는 익명 함수)
print(plus_two(1))




print('\n',"이렇게 하지마라",sep='')   #lambda x 에는 x에 넘겨줄 값을 마련해줘야함 x+1 처럼.
tmp=lambda x: print(x+1)    #해당 코드 무의미: 인자 x를 받아서 lambda x에 넘겨줘야 하는데 넘겨줄게없음
print(tmp(2))



print('\n',"예시 2",sep='')   #예시2
def plus_one(x):
    return x+1

a=[1,2,3]
print(list(map(plus_one,a)))    #a 꺼내서 map(함수, a) 매핑 시키고, 이걸 list 값으로 묶는다
print(list(map(lambda x: x+1, a)))  #a 꺼내서 map(람다식, a)매핑 시키고 이걸 list 값으로 묶는다
print('매핑하고 list() 없이 쓸 경우:',map(plus_one,a)) 
print()

print("람다식 특징\n",'1: 불필요한 함수 남발 안해도됨\n','2: 가독성 좋음\n','3: 재활용 못함\n',sep='')
