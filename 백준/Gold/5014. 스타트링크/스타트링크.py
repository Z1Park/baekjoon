from collections import deque

f, s, g, u, d = map(int, input().split())
floor = [0] * (f+1)
visit = [0] * (f+1)
flag = True
def bfs(tmp):
    que = deque()
    visit[tmp] = 1
    que.append(tmp)
    while que:
        x = que.popleft()
        if x == g:
            print(floor[x])
            return
        for i in (x+u, x-d):
            if 1 <= i <= f and not visit[i]:
                visit[i] = 1
                floor[i] = floor[x] + 1
                que.append(i)
    print("use the stairs")
bfs(s)