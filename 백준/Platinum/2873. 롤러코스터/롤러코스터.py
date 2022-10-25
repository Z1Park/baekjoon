import sys
input = lambda : sys.stdin.readline()
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def move(r, c, dir, dir1, dir2, final):
    flag = True
    for i in range(r):
        for j in range(c-1):
            print(dir1 if flag else dir2, end='')
        flag = not flag
        if i != r-1 or final:
            print(dir, end='')

if n % 2 == 1:
    move(n, m, 'D', 'R', 'L', False)
else:
    if m % 2 == 1:
        move(m, n, 'R', 'D', 'U', False)
    else:
        min_val = 1001
        for i in range(n):
            for j in range(m):
                if (i+j)%2 == 1 and min_val > arr[i][j]:
                    min_val = arr[i][j]
                    r, c = i, j
        move(c-c%2, n, 'R', 'D', 'U', True)
        move(r-r%2, 2, 'D', 'R', 'L', True)
        print('DR' if r%2 == 0 else 'RD', end='')
        if r+(2-r%2) != n:
            print('D', end='')
        move(n-r-(2-r%2), 2, 'D', 'L', 'R', False)
        if c+(2-c%2) != m:
            print('R', end='')
        move(m-c-(2-c%2), n, 'R', 'U', 'D', False)