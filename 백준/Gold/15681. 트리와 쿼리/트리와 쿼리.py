import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
n, r, q = map(int, input().split())
graph = [[] for _ in range(n+1)]
st = [0 for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(node):
    st[node] = 1
    for nxt in graph[node]:
        if st[nxt] == 0:
            st[node] += dfs(nxt)
    return st[node]

dfs(r)
for _ in range(q):
    print(st[int(input())])