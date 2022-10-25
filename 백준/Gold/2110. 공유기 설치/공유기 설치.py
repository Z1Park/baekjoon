n, m = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()

def check(dist):
    count = 1
    curr = houses[0]
    for i in range(1, n):
        if houses[i] >= curr + dist:
            count += 1
            curr = houses[i]
    return count

start = 1
end = max(houses)
while start <= end:
    mid = (start + end) // 2
    if check(mid) < m:
        end = mid - 1
    else:
        start = mid + 1
print(end)