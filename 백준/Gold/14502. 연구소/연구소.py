import sys
from collections import deque
from itertools import combinations
from copy import deepcopy
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
blank = []
virus = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            blank.append([i, j])
        elif arr[i][j] == 2:
            virus.append([i, j])

max_size = 0
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
for comb in combinations(blank, 3):
    new_arr = deepcopy(arr)

    for c in comb:
        new_arr[c[0]][c[1]] = 1
    
    que = deque(virus)
    while que:
        r, c = que.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < m and new_arr[nr][nc] == 0:
                new_arr[nr][nc] = 2
                que.append([nr, nc])

    count = 0
    for i in range(n):
        for j in range(m):
            if new_arr[i][j] == 0:
                count += 1
    if max_size < count:
        max_size = count

print(max_size)