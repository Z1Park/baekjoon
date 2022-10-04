def fill_star(m, r, c):
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            if m == 3:
                arr[r+i][c+j] = '*'
            else:
                fill_star(m//3, r+i*(m//3), c+j*(m//3))

n = int(input())
arr = [[' ' for a in range(n)] for b in range(n)]
fill_star(n, 0, 0)
for i in range(n):
    print(''.join(arr[i]))