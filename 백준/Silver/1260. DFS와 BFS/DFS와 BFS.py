from collections import deque

n, m, v = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(m)]
for l in lst:
    if [l[1], l[0]] not in lst:
        lst.append([l[1], l[0]])
lst.sort(key= lambda x : (x[0], x[1]))
visited = []

def dfs(node):
    global lst
    visited.append(str(node))
    for l in lst:
        if node == l[0] and str(l[1]) not in visited:
            dfs(l[1])

def bfs(node):
    global lst, que
    visited.append(str(node))
    for l in lst:
        if node == l[0] and str(l[1]) not in visited and l[1] not in que:
            que.append(l[1])

dfs(v)
print(' '.join(visited))
visited = []
que = deque()
que.append(v)
while que:
    bfs(que.popleft())
print(' '.join(visited))