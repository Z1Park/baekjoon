import sys
input = sys.stdin.readline
v, e = map(int, input().split())
INF = sys.maxsize
graph = [[] for _ in range(v+1)]
for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append([b, w])
    graph[b].append([a, w])
v1, v2 = map(int, input().split())

def dijkstra(start):
    res = [INF for _ in range(v+1)]
    visit = [True] + [False for _ in range(v)]
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
    return res

res = dijkstra(1)
res_v1 = dijkstra(v1)
res_v2 = dijkstra(v2)
res1 = res[v1] + res_v1[v2] + res_v2[v]
res2 = res[v2] + res_v2[v1] + res_v1[v]
result = min(res1, res2)
print(-1 if result >= INF else result)