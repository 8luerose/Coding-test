n = int(input())
a = list(map(int, input().split()))

'''
방법_1 (매개변수의 자릿수를 10으로 나눠서 더하는 방법)
def digit_sum(x):
    sum = 0
    while (x > 0):
        sum += x%10
        x = x//10
    return (sum)

max = -2147000000    
for x in a:							#리스트 원소를 그대로 꺼낸다 (접근 방법)
    total = digit_sum(x)
    if total > max:
        max = total
        result = x
print(result)
'''

#방법_2 (파이썬 함수 'str()' 이용 시 자릿수 쪼개기 가능)
def digit_sum(x):
    sum = 0
    for i in str(x):
        sum += int(i)
    return (sum)

max = -2147000000    
for x in a:							#리스트 원소를 그대로 꺼낸다 (접근 방법)
    total = digit_sum(x)
    if total > max:
        max = total					#지금 것이 더 크면 교체
        result = x					#리스트 a에 담긴 값인 x
print(result)

'''
3
125 15232 97

=97
'''