from collections import deque

tc = int(input())
for t in range(tc):
    v, e = map(int, input().split())
    bridge = [[] for _ in range(v+1)]
    for i in range(e):
        a, b = map(int, input().split())
        bridge[a].append(b)
        bridge[b].append(a)
    visit = [-1 for _ in range(v+1)]
    que = deque()
    for i in range(1, v+1):
        que.append(i)
        if visit[i] == -1:
            visit[i] = 0
        flag = True
        while que:
            node = que.popleft()
            for j in bridge[node]:
                if visit[j] == -1 and j not in que:
                    visit[j] = visit[node]^1
                    que.append(j)
                elif visit[j] == visit[node]:
                    flag = False
                    break
            if not flag:
                break
        if not flag:
            break
    print("YES" if flag else "NO")