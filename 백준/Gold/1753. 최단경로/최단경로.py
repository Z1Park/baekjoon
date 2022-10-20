import sys
input = sys.stdin.readline
v, e = map(int, input().split())
start = int(input())
INF = sys.maxsize
graph = [[] for _ in range(v+1)]
visit = [True] + [False for _ in range(v)]
res = [INF for _ in range(v+1)]
for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append([b, w])

visit[start] = True
res[start] = 0
node = start
for _ in range(v):
    for g in graph[node]:
        nxt, weight = g
        if not visit[nxt]:
            res[nxt] = min(res[nxt], res[node] + weight)
    m = INF
    nxt = 0
    for i in range(1, v+1):
        if m > res[i] and not visit[i]:
            m = res[i]
            nxt = i
    node = nxt
    visit[nxt] = True
for i in range(1, v+1):
    if res[i] == INF:
        print("INF")
    else:
        print(res[i])