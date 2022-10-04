from collections import deque

def move(i, j, size):
    diff = size - j
    if i > diff:
        i -= diff
        j += diff
    else:
        j += i
        i = 0
    return i, j

A, B, C = map(int, input().split())
que = deque()
que.append((0, 0))
visit = [[False for i in range(B+1)] for j in range(A+1)]
visit[0][0] = True
res = [C]
while que:
    a, b = que.popleft()

    tmp_a, tmp_b = move(a, b, B)
    tmp_c = C-tmp_a-tmp_b
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)
    
    tmp_a, tmp_c = move(a, C - a - b, C)
    tmp_b = C-tmp_a-tmp_c
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)

    tmp_b, tmp_a = move(b, a, A)
    tmp_c = C-tmp_a-tmp_b
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)

    tmp_b, tmp_c = move(b, C - a - b, C)
    tmp_a = C-tmp_b-tmp_c
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)

    tmp_c, tmp_a = move(C - a - b, a, A)
    tmp_b = C-tmp_a-tmp_c
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)

    tmp_c, tmp_b = move(C - a - b, b, B)
    tmp_a = C-tmp_b-tmp_c
    if not visit[tmp_a][tmp_b]:
        visit[tmp_a][tmp_b] = True
        que.append((tmp_a, tmp_b))
        if tmp_a == 0 and tmp_c not in res:
            res.append(tmp_c)
print(*sorted(res))