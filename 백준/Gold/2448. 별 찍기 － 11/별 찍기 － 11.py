def fill_star(m, r, c):
    if m == 3:
        arr[r][c] = '*'
        arr[r+1][c-1] = arr[r+1][c+1] = '*'
        for i in range(c-2,c+3):
            arr[r+2][i] = '*'
    else:
        fill_star(m//2, r, c)
        fill_star(m//2, r+m//2, c-m//2)
        fill_star(m//2, r+m//2, c+m//2)

n = int(input())
arr = [[' ' for a in range(2*n)] for b in range(n)]
fill_star(n, 0, n-1)
for i in range(n):
    print(''.join(arr[i]))