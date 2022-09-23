# import sys
# input = sys.stdin.readline().rstrip()
from collections import deque


n = int(input())
lst = [list(map(int, input().split())) for _ in range(n)]
m = 0
for i in range(n):
    t = max(lst[i])
    if m < t:
        m = t
m_cnt = 0

def del_island(x, y):
    global arr
    arr[x][y] = 0
    for i in range(4):
        if 0 <= x+dx[i] < n and 0 <= y+dy[i] < n and arr[x+dx[i]][y+dy[i]] == 1:
            if (x+dx[i], y+dy[i]) not in que:
                que.append((x+dx[i], y+dy[i]))

def check_island():
    global arr, que, count
    for i in range(n):
        if 1 in arr[i]:
            count += 1
            que.append((i, arr[i].index(1)))
            return False
    return True

for k in range(m):
    arr = []
    for i in range(n):
        tmp = []
        for j in range(n):
            if lst[i][j] <= k:
                tmp.append(0)
            else:
                tmp.append(1)
        arr.append(tmp)
    que = deque()
    count = 0
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while True:
        if check_island():
            break
        while que:
            del_island(*(que.popleft()))
    if m_cnt < count:
        m_cnt = count
print(m_cnt)