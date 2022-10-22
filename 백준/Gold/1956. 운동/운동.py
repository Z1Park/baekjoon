import sys
input = sys.stdin.readline
n, m = map(int, input().split())
INF = sys.maxsize
arr = [[INF for _ in range(n)] for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a-1][b-1] = c
for k in range(n):
    for i in range(n):
        for j in range(n):
            if arr[i][j] > arr[i][k] + arr[k][j]:
                arr[i][j] = arr[i][k] + arr[k][j]
cycle = []
for i in range(n):
    cycle.append(arr[i][i])
res = min(cycle)
print(res if res < INF else -1)