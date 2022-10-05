tc = int(input())
for t in range(tc):
    h, w, n  = map(int, input().split())
    visit = [[False] * w for _ in range(h)]
    floor = h if n % h == 0 else n % h
    room = n // h if n % h == 0 else n // h + 1
    print(floor*100+room)