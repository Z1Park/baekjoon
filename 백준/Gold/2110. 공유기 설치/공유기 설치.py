n, m = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()
start, end = 1, houses[n-1] - houses[0]
while start <= end:
    mid = (start + end) // 2
    tmp = houses[0]
    count = 1
    for i in range(1, n):
        if houses[i] - tmp >= mid:
            tmp = houses[i]
            count += 1
    if count >= m:
        start = mid + 1
    else:
        end = mid - 1
print(end)