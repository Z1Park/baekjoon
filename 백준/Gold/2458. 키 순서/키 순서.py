import sys
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [['?' for _ in range(n)] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a-1][b-1] = 1
    arr[b-1][a-1] = -1
for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == j:
                arr[i][j] = 0
            elif arr[i][k] != '?' and arr[k][j] != '?' and arr[i][k]*arr[k][j] > 0:
                arr[i][j] = arr[i][k] + arr[k][j]
cnt = 0
for i in range(n):
    if '?' not in arr[i]:
        cnt += 1
print(cnt)