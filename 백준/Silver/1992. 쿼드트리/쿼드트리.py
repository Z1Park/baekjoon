def qud_tree(m, r, c):
    res = "("
    for i in range(m):
        for j in range(m):
            if arr[r][c] != arr[r+i][c+j]:
                for a in range(2):
                    for b in range(2):
                        res += qud_tree(m//2, r+a*(m//2), c+b*(m//2))
                return res + ")"
    return str(arr[r][c])

n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
res = qud_tree(n, 0, 0)
print(res)