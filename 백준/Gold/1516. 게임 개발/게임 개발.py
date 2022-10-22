import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = [[0] for _ in range(n+1)]
btime = [0 for _ in range(n+1)]
for i in range(1, n+1):
    tmp = list(map(int, input().rstrip().split()[:-1]))
    btime[i] = tmp[0]
    for j in tmp[1:]:
        graph[j].append(i)
        graph[i][0] += 1
que = deque()
for i in range(1, n+1):
    if graph[i][0] == 0:
        que.append(i)
res = btime.copy()
while que:
    node = que.popleft()
    for nxt in graph[node][1:]:
        graph[nxt][0] -= 1
        res[nxt] = max(res[nxt], res[node]+btime[nxt])
        if graph[nxt][0] == 0:
            que.append(nxt)
for i in res[1:]:
    print(i)