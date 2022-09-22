import sys
input = sys.stdin.readline

def move(idx, r, c, d1, d2, d3, ind):
    i = idx
    flag = True
    while i < r:
        j = 0
        while j < c:
            if flag:
                print(d1, end = '')
            else:
                print(d2, end = '')
            j += 1
        if i < r - ind:
            print(d3, end = '')
        i += 1
        flag = not flag

r, c = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(r)]
if r % 2 == 1:
    move(0, r, c - 1, "R", "L", "D", 1)
elif c % 2 == 1:
    move(0, c, r - 1, "D", "U", "R", 1)
else:
    m = 1000
    for i in range(r):
        for j in range(c):
            if (i + j) % 2 == 1 and lst[i][j] < m:
                m = lst[i][j]
                x, y = i, j
    move(0, y - y % 2, r - 1, "D", "U", "R", 0)
    move(0, x, 1, "R", "L", "D", 0)
    if x != r - 1:
        print("D", end = '')
    if y % 2 == 0:
        move(x + 1, r, 1, "L", "R", "D", 1)
    else:
        move(x + 1, r, 1, "R", "L", "D", 1)
    if y + 1 - y % 2 != c - 1:
        print("R", end = '')
    move(y + 1, c - 1 + y % 2, r - 1, "U", "D", "R", 1)