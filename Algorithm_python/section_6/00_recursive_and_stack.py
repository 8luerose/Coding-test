'''
재귀
'''

def DFS(x):
    if (x > 0):
        DFS(x - 1)
        print(x, end = ' ')
        
n = int(input())
DFS(n)

