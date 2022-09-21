t = int(input())
lst = list(map(int, input().split()))
for i in range(t):
    tmp = lst[i]
    while (tmp % 3 != 0):
        tmp -= 1
    s = 3 * (tmp // 3) * (tmp // 3 + 1) // 2
    tmp = lst[i]
    while (tmp % 7 != 0):
        tmp -= 1
    s += 7 * (tmp // 7) * (tmp // 7 + 1) // 2
    tmp = lst[i]
    while (tmp % 21 != 0):
        tmp -= 1
    if (tmp > 0):
        s -= 21 * (tmp // 21) * (tmp // 21 + 1) // 2
    print(s)