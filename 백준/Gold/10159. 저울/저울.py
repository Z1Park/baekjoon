import sys

input = sys.stdin.readline
n = int(input())
m = int(input())
lst = [list(map(int, input().split())) for _ in range(m)]
arr = [['?' for a in range(n)] for b in range(n)]
for l in lst:
    arr[l[0]-1][l[1]-1] = -1
    arr[l[1]-1][l[0]-1] = 1
for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == j:
                arr[i][j] = 0
            elif arr[i][k] != '?' and arr[k][j] != '?' and arr[i][k]*arr[k][j] > 0:
                arr[i][j] = arr[i][k] + arr[k][j]
for i in range(n):
    print(arr[i].count('?'))