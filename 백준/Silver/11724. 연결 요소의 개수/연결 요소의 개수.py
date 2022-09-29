def dfs(curr):
    for b in bridge:
        if b[0] == curr and not visit[b[1]]:
            visit[b[1]] = True
            dfs(b[1])

n, m = map(int, input().split())
bridge = []
for i in range(m):
    curr, next = map(int, input().split())
    bridge.append([curr, next])
    bridge.append([next, curr])
visit = [False for _ in range(n+1)]
cc = 0
for i in range(1, n+1):
    if not visit[i]:
        cc += 1
        visit[i] = True
        for b in bridge:
            if b[0] == i and not visit[b[1]]:
                dfs(b[0])
print(cc)