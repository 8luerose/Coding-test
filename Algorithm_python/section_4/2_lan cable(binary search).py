'''
개념

1. 결정 알고리즘: 답을 정하고 이 답이 유효한지 확인해 가면서 
더 좋은 답을 찾아가는 방식. 답을 찾는 과정은 주로 이분검색.

2. 'N개를 만들 수 있는 랜선의 최대 길이'
= 각 케이블들을 '동일하게 잘랐을 때' 만들어지는 최대 길이.
= 총합 N개를 만들 수 있고, 사이즈가 같은 조건 중 최대 길이

3. 이진탐색을 사용해서 해결한다.
= 802, 743 ... 예시라면, 1~'가장 긴 랜선'을 기준으로 이진탐색 시작
= 총합이 N개가 되는 값 찾고->그것들 중 최대 길이 찾는다

4. *주의*
- 이 문제에선 N개보다 많이 만드는 것(>=N)도 포함한다.
- mid는 길이
'''

def	line_cut_cnt(len):				#라인을 len으로 자른 갯수
    cnt_sum = 0
    for x in Line:					#파이썬에선 전역변수가 기본(ex Line)
          cnt_sum += (x // len)		#랜선을 // 길이로 나눈 몫들의 누적합
    return (cnt_sum)				#길이로 나눈 총합 갯수

k, n = map(int, input().split())
Line = []							#K개의 랜선을 저장하는 목적의 리스트

largest = 0
result = 0 
for i in range(k):
    tmp = int(input())
    Line.append(tmp)
    largest = max(largest, tmp)		#max(A,B): A,B중 큰 값 반환

i = 1
j = largest
while (i <= j):
    mid = (i + j) // 2				#이진 탐색
    if (line_cut_cnt(mid) >= n):	#라인을 len으로 자른 갯수가 n개보다 크거나 같을때
         result = mid				#그 len길이가 정답이므로 result에 저장
         i = mid + 1				#자른 갯수가 또 더 많거나 같을 수 있음, 그것들 중 가장 긴 길이(mid)구해야 하므로
    else :
         j = mid - 1
print(result)						#print("\n", result, sep ='')


'''
4 11
802
743
457
539

=200
'''