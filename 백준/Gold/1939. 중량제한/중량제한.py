import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])
start, end = map(int, input().split())

def check(weight):
    que = deque()
    que.append(start)
    while que:
        node = que.popleft()
        if node == end:
            return True
        for nxt, wgt in graph[node]:
            if not visit[nxt] and weight <= wgt:
                visit[nxt] = True
                que.append(nxt)

left, right = 1, 1000000000
while left <= right:
    mid = (left + right) // 2
    visit = [False for _ in range(n+1)]
    visit[start] = True
    if check(mid):
        left = mid + 1
    else:
        right = mid - 1
print(right)