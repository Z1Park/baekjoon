from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())
lst = []
for i in range(m):
    nx, ny = map(int, input().split())
    lst.append([nx, ny])
    lst.append([ny, nx])
visit = [0 for _ in range(n+1)]
que = deque()
que.append(a)
cnt = -1
while que:
    curr = que.popleft()
    if curr == b:
        cnt = visit[curr]
    for l in lst:
        if l[0] == curr and not visit[l[1]]:
            visit[l[1]] = visit[l[0]] + 1
            que.append(l[1])
print(cnt)