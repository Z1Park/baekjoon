count, e, w, s, n = map(int, input().split())
lst = [[e/100, 0, 1], [w/100, 0, -1], [s/100, 1, 0], [n/100, -1, 0]]
total = 0

arr = [[0 for a in range(31)] for b in range(31)]

def dfs(x, y, c, p):
    global arr, total
    arr[x][y] = 1
    if c == 0:
        total += p
        arr[x][y] = 0
        return
    for i in lst:
        if arr[x+i[1]][y+i[2]] == 0 and i[0] != 0:
            dfs(x+i[1], y+i[2], c-1, p*i[0])
    arr[x][y] = 0

dfs(16, 16, count, 1)
print(total)