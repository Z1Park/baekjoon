n, k = map(int, input().split())
arr = [[1 for a in range(n)] for b in range(k)]
for i in range(k):
    arr[i][0] = i+1
for i in range(1, k):
    for j in range(1, n):
        arr[i][j] = arr[i-1][j] + arr[i][j-1]
print(arr[-1][-1] % 1000000000)