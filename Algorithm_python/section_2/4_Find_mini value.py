#최솟값 구하기

arr = [5, 3, 7, 9, 2, 5, 2, 6]
arrMin = float('inf')		#파이썬에서 가장 큰 값으로 초기화

for i in range((len(arr))):	#0~7까지 (=len(arr)=8)
    if arr[i] < arrMin:		#'무한대'로 둔 이유: 첫 번째 수 무조건 담기 위함
        arrMin = arr[i]
print(arrMin)


# for x in arr:
#     if x < arrMin:		
#         arrMin = x
# print(arrMin)
#이렇게도 가능
