from heapq import heappop, heappush
inf = 1e9 + 1
n, m = int(input()), int(input())
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b, cost = map(int, input().split())
    arr[a-1].append([b-1, cost])
start, end = map(int, input().split())
start, end = start-1, end-1
dp = [inf for _ in range(n)]
dp[start] = 0
heap = []
heappush(heap, (0, start))
while heap:
    cost, city = heappop(heap)
    if dp[city] < cost:
        continue
    for nxt, cst in arr[city]:
        tmp = cst + cost
        if tmp < dp[nxt]:
            dp[nxt] = tmp
            heappush(heap, (tmp, nxt))
print(dp[end])