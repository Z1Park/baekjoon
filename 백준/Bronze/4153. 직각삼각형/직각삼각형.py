while True:
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break
    if max(a, b, c) != c:
        if a > b:
            a, c = c, a
        else:
            b, c = c, b
    print("right" if a**2 + b**2 == c**2 else "wrong")