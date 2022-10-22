import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
m = int(input())
graph = [[0] for _ in range(n+1)]
part = [True for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    part[a] = False
    graph[a].append([b, c])
    graph[b][0] += 1

que = deque()
res = [0 for _ in range(n+1)]
que.append(n)
res[n] = 1
while que:
    node = que.popleft()
    for [nxt, cnt] in graph[node][1:]:
        graph[nxt][0] -= 1
        res[nxt] += res[node] * cnt
        if graph[nxt][0] == 0:
            que.append(nxt)
for i in range(1, n+1):
    if part[i]:
        print(i, res[i])