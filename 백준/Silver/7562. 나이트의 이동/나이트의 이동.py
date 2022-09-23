from collections import deque

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

def bfs(x, y):
    global lst, que
    lst[x][y] = 1
    que.append((x, y))
    while que:
        x, y = que.popleft()
        if x == target_x and y == target_y:
            print(lst[x][y] - 1)
            return
        for i in range(8):
            if 0 <= x+dx[i] < n and 0 <= y+dy[i] < n and lst[x+dx[i]][y+dy[i]] == 0:
                lst[x+dx[i]][y+dy[i]] = lst[x][y] + 1
                que.append((x+dx[i], y+dy[i]))

t = int(input())
for i in range(t):
    n = int(input())
    x, y = map(int, input().split())
    target_x, target_y = map(int, input().split())
    lst = [[0 for a in range(n)] for b in range(n)]
    que = deque()
    bfs(x, y)