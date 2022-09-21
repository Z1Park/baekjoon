n = int(input())

for i in range(n):
    t = i
    s = i
    while (t > 0):
        s += t % 10
        t //= 10
    if (s == n):
        print(i)
        break
else:
    print(0)