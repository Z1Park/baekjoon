t = int(input())

for i in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = ((x1 - x2)**2 + (y1 - y2)**2)**.5
    r = abs(r1 - r2)
    if d == 0 and r == 0:
        print(-1)
    elif d == r or d == r1 + r2:
        print(1)
    elif r < d < r1 + r2:
        print(2)
    else:
        print(0)