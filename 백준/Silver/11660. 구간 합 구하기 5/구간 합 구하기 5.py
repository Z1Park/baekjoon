import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
s_arr = [[0 for _ in range(n+1)] for _ in range(n)]
for i in range(n):
    s = 0
    for j in range(1, n+1):
        s += arr[i][j-1]
        s_arr[i][j] = s
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    s = 0
    for i in range(x1-1, x2):
        s += s_arr[i][y2]-s_arr[i][y1-1]
    print(s)