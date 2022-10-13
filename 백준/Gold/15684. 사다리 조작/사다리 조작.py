n, m, h = map(int, input().split())
lad = [[False for _ in range(n+1)] for _ in range(h+1)]
for _ in range(m):
    a, b = map(int, input().split())
    lad[a][b] = 1

pros = []
for i in range(1, h+1):
    for j in range(1, n):
        if not lad[i][j-1] and not lad[i][j] and not lad[i][j+1]:
            pros.append((i, j))

def check():
    for j in range(1, n+1):
        curr = j
        for i in range(1, h+1):
            if lad[i][curr]:
                curr += 1
            elif lad[i][curr-1]:
                curr -= 1
        if curr != j:
            return False
    return True

def dfs(depth, idx):
    global res
    if depth >= res:
        return
    if check():
        res = depth
        return
    for i in range(idx, len(pros)):
        r, c = pros[i]
        if not lad[r][c-1] and not lad[r][c+1]:
            lad[r][c] = True
            dfs(depth+1, i+1)
            lad[r][c] = False

res = 4
dfs(0, 0)
print(res if res < 4 else -1)