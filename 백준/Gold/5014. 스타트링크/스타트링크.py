from collections import deque

f, s, g, u, d = map(int, input().split())
floor = [-1 for _ in range(f+1)]
def bfs(tmp):
    que = deque()
    que.append(tmp)
    floor[tmp] = 0
    while que:
        x = que.popleft()
        if x == g:
            print(floor[x])
            return
        for i in (x+u, x-d):
            if 1 <= i <= f and floor[i] == -1:
                floor[i] = floor[x] + 1
                que.append(i)
    print("use the stairs")
bfs(s)