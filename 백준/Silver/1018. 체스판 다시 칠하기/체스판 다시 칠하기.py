def count_pattern(a ,b):
    global lst
    prev = "W"
    if (lst[a][b] == prev):
        count1 = 0
    else:
        count1 = 1
    for i in range(a, a + 8):
        for j in range(b, b + 8):
            if (i == a and j == b):
                continue
            if (lst[i][j] == prev):
                count1 += 1
            if (prev == "B"):
                prev = "W"
            else:
                prev = "B"
        if (prev == "B"):
            prev = "W"
        else:
            prev = "B"
    prev = "B"
    if (lst[a][b] == prev):
        count2 = 0
    else:
        count2 = 1
    for i in range(a, a + 8):
        for j in range(b, b +8):
            if (i == a and j == b):
                continue
            if (lst[i][j] == prev):
                count2 += 1
            if (prev == "B"):
                prev = "W"
            else:
                prev = "B"
        if (prev == "B"):
            prev = "W"
        else:
            prev = "B"
    if (count1 > count2):
        return count2
    else:
        return count1

n, m = map(int, input().split())
lst = []
min = 64

for i in range(n):
    lst.append(input())

for i in range(n - 7):
    for j in range(m - 7):
        curr = count_pattern(i, j)
        if (curr < min):
            min = curr
print(min)