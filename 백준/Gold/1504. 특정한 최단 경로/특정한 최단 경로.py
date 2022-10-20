import sys
from heapq import heappop, heappush
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
    res[start] = 0
    que = []
    heappush(que, (0, start))
    while que:
        dist, node = heappop(que)
        if res[node] < dist:
            continue
        for g in graph[node]:
            nxt, nxt_dist = g
            tmp = dist + nxt_dist
            if res[nxt] > tmp:
                res[nxt] = tmp
                heappush(que, (tmp, nxt))
    return res

res = dijkstra(1)
res_v1 = dijkstra(v1)
res_v2 = dijkstra(v2)
result = min(res[v1]+res_v1[v2]+res_v2[v], res[v2]+res_v2[v1]+res_v1[v])
print(result if result < INF else -1)