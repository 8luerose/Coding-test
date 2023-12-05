def largest_power_of_two(n):
    """주어진 숫자 n의 2의 거듭제곱 꼴이면서 가장 큰 약수를 반환합니다."""
    power = 1
    while n % 2 == 0:
        n //= 2
        power *= 2
    return power

def sum_of_largest_powers(A, B):
    """주어진 범위 A부터 B까지 각 숫자의 2의 거듭제곱 꼴이면서 가장 큰 약수들의 총 합을 계산합니다."""
    total_sum = 0
    for number in range(A, B + 1):
        total_sum += largest_power_of_two(number)
    return total_sum

# 예시 입력
A, B = map(int, input().split())
result = sum_of_largest_powers(A, B)
print(result)
