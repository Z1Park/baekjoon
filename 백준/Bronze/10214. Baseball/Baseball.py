t = int(input())
for i in range(t):
    Y, G = 0 ,0
    for _ in range(9):
        y, g = map(int, input().split())
        Y += y
        G += g
    if (Y > G):
        print("Yonsei")
    elif (Y < G):
        print("Korea")
    else:
        print("Draw")