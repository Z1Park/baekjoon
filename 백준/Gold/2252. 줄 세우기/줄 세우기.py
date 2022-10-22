import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[0] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b][0] += 1
que = deque()
visit = [False for _ in range(n+1)]
for i in range(1, n+1):
    if graph[i][0] == 0:
        visit[i] = True
        que.append(i)
res = []
while que:
    node = que.popleft()
    res.append(node)
    for i in range(1, len(graph[node])):
        nxt = graph[node][i]
        graph[nxt][0] -= 1
        if graph[nxt][0] == 0:
            que.append(nxt)
print(*res)