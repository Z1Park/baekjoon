def promising(r, c, i):
    if i in arr[r]:
        return False
    for j in range(9):
        if arr[j][c] == i:
            return False
    for j in range(3):
        for k in range(3):
            if arr[(r//3)*3 + j][(c//3)*3 + k] == i:
                return False
    return True

def get_blanck():
    for i in range(9):
        for j in range(9):
            if arr[i][j] == 0:
                return [i, j]
    return [-1, -1]

def dfs(r, c):
    global flag
    for i in range(1, 10):
        if not promising(r, c, i):
            continue
        arr[r][c] = i
        a, b = get_blanck()
        if a != -1 and b != -1:
            dfs(a, b)
            if flag:
                return
        elif not flag:
            flag = True
            for i in range(9):
                print(*arr[i])
        arr[r][c] = 0

arr = [list(map(int, input().split())) for _ in range(9)]
flag = False
dfs(*get_blanck())