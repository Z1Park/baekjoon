from collections import deque
n = int(input())
bridge = [[] for _ in range(n+1)]
res = [0 for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    bridge[a].append(b)
    bridge[b].append(a)
que = deque()
que.append(1)
while que:
    node = que.popleft()
    for next in bridge[node]:
        if res[next] == 0:
            res[next] = node
            que.append(next)
for i in range(2, n+1):
    print(res[i])