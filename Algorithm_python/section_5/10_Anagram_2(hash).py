'''
개념
1. 기존 코드에 의하면 A, B 문자열 각각 한바퀴 dict로 돌면서 증가시켜주고
	서로 비교해서 다른 게 있을 때 anagram이 아니라고 보았다
2. 그러나 이 코드는 복잡하고 쓸때없이 불필요한 코드가 있다
3. 따라서 새로운 코드로 작성한다. 
	해당 논리는 1증가 1감소 후, 아직도 감소 안된 것이 발견되면 'No'라는 논리이다
'''

a = input()
b = input()

arr = dict()						#빈 딕셔너리 구조 선언

for x in a:
    arr[x] = arr.get(x, 0) + 1	#arr1에 x있으면 value반환, 없으면 0 반환 <-누적
for x in b:
    arr[x] = arr.get(x, 0) - 1	#아까 1증가했던거 다시 1감소

for x in a:
    if (arr.get(x) > 0):		#arr.get(키) value > 0 == b검사할때 감소하지 않고 남은 것 발견함
        print("NO")
        break
else :							#for - else = for정상 종료 시 else 작동
    print("YES")
'''
AbaAeCe
baeeACA

=Yes
'''