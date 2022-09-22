from collections import deque

n, m  = map(int, input().split())
lst = [list(map(int, list(input()))) for _ in range(n)]
que = deque()

def move(r, c):
    global que
    if r < n - 1 and lst[r+1][c] == 1:
        lst[r+1][c] = lst[r][c] + 1
        que.append((r+1, c))
    if r > 0 and lst[r-1][c] == 1:
        lst[r-1][c] = lst[r][c] + 1
        que.append((r-1, c))
    if c < m - 1 and lst[r][c+1] == 1:
        lst[r][c+1] = lst[r][c] + 1
        que.append((r, c+1))
    if c > 0 and lst[r][c-1] == 1:
        lst[r][c-1] = lst[r][c] + 1
        que.append((r, c-1))

que.append((0, 0))
while que:
    move(*(que.popleft()))
print(lst[n-1][m-1])