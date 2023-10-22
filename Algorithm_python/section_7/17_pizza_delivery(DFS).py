'''

'''
def select_pizza(pizza_map, m):
    n = len(pizza_map)
    pizza_list = []
    for i in range(n):
        for j in range(n):
            if pizza_map[i][j] == 2:
                pizza_list.append((i, j))
    pizza_combinations = list(combinations(pizza_list, m))
    return pizza_combinations

def get_min_distance(pizza_map, pizza_combinations):
    n = len(pizza_map)
    min_distance = float('inf')
    for pizza_combination in pizza_combinations:
        distance = 0
        for i in range(n):
            for j in range(n):
                if pizza_map[i][j] == 1:
                    min_house_distance = float('inf')
                    for pizza in pizza_combination:
                        house_distance = abs(i - pizza[0]) + abs(j - pizza[1])
                        min_house_distance = min(min_house_distance, house_distance)
                    distance += min_house_distance
        min_distance = min(min_distance, distance)
    return min_distance

from itertools import combinations

# 입력값 받기
n, m = map(int, input().split())
pizza_map = []
for _ in range(n):
    pizza_map.append(list(map(int, input().split())))

# 피자집 선택하기
pizza_combinations = select_pizza(pizza_map, m)

# 도시의 최소 피자배달거리 계산하기
min_distance = get_min_distance(pizza_map, pizza_combinations)

# 결과 출력하기
print(min_distance)

'''
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
=
6
'''