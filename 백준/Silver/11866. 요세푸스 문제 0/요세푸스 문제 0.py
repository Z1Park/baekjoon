from collections import deque
n, m = map(int, input().split())
que = deque()
for i in range(1, n+1):
    que.append(i)
res = []
idx = 1
while que:
    tmp = que.popleft()
    if idx == m:
        res.append(str(tmp))
        idx = 1
    else:
        que.append(tmp)
        idx += 1
print('<'+ ', '.join(res) +'>')