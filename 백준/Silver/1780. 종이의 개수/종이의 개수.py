def cutting(m, r, c):
    global res
    for i in range(m):
        for j in range(m):
            if arr[r][c] != arr[r+i][c+j]:
                for a in range(3):
                    for b in range(3):
                        cutting(m//3, r+a*(m//3), c+b*(m//3))
                return
    res[arr[r][c]+1] += 1

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
res = [0, 0, 0]
cutting(n, 0, 0)
for i in range(3):
    print(res[i])