'''
개념 
*쫄지마라

그떄그때 가장 높은 것 -1, 가장 낮은 것 +1
마지막에 가장 높은 것 - 가장 낮은 것
해주면 됨

1.'오름차순으로'sorting해주고
2.가장 높 -1, 가장 낮 +1
3.sorting = 제일 높, 제일 낮 변경됐을 수도 있으니까! 재소트
4.이걸 50번
'''
N = int(input())
arr = list(map(int, input().split()))
M = int(input())

arr.sort()
for _ in range(M):
    arr[0] += 1			#오름차순 정렬했기 때문에 가장 낮은 것은 첫번째
    arr[N - 1] -= 1		#가장 높은 것은 마지막
    arr.sort()			#오름차순이 변경됐을 수도 있으므로 다시 정렬

result = arr[N - 1] - arr[0]
print(result)


'''
10
69 42 68 76 40 87 14 65 76 81
50

=20
'''