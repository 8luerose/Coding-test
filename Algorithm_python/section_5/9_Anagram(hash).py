'''
개념
1. dictionary를 사용한다
	str1[A] = 1: A라는 key값을 참조해서 그 value에 1 셋팅
2. 그런데 dict는 += 하면 에러 발생 위험 있음
	str1[A] = str1[A] + 1 불가
    = str1[A] 의 값이 0이라면 value 참조 오류
3. <따라서> 방법은 str1.get('A', 0) 을 사용한다
	dict.get(키, 0) = 딕셔너리.값 가져와라(키, 0) 키 값. 없으면 0 반환
    str1[A] = str1.get('A', 0) + 1
	= 딕셔너리에 A의 value 반환(없으면 0 반환) + 1 -> 누적
4. str1.keys()는 key값을 의미한다
	= for i in str1.keys():
5. Anagram: 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치할 때
'''

a = input()
b = input()

arr1 = dict()						#빈 딕셔너리 구조 선언
arr2 = dict()

for x in a:
    arr1[x] = arr1.get(x, 0) + 1	#arr1에 x있으면 value반환, 없으면 0 반환 <-누적
for x in b:
    arr2[x] = arr2.get(x, 0) + 1

# print(arr1.keys())				# dict_keys(['A', 'b', 'a', 'e', 'C']) 이런 식
for i in arr1.keys():				#dict.keys()의 값 하나 참조
    if (i in arr2.keys()):			#arr2에도 있는 경우,
        if (arr1[i] != arr2[i]):	#arr1[키] != arr2[키]: 서로 딕셔너리의 value가 다를 때 
            print("NO")
            break
    else :							#arr1.keys()가 arr2.keys()에 없을 때
        print("NO")
        break
else :
    print("YES")					#for - else: for문 정상 종료 시 else 실행, 여기서는 잘못된게 없을 때 YES

'''
AbaAeCe
baeeACA

=Yes
'''