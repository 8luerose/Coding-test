#정답 코드
N,K = map(int, input().split())

flag = 0
for i in range(1, N+1):
    if (N % i == 0):
        flag+=1
        #print(i, end = ' ')
    if (flag == K):
        print(i)
        break
else:							#for - else 구문: for가 break에 걸리지 않고 '정상적으로 끝나면' else 실행
	print(-1)   

        

#내가 처음 작성한 코드
# N,K = map(int, input().split())

# flag = 0
# for i in range(1, N+1):
#     if (N % i == 0):
#         flag+=1
#         print(i, end = ' ')
#         if (flag == K):
#             print(i)
#             break
#     else:
#         continue
# if (flag < K):
#     print(-1)   

        