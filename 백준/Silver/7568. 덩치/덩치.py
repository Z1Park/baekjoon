n = int(input())
lst = []
ords = [1] * n

for i in range(n):
    lst.append(list(map(int, input().split())))

for i in range(n - 1):
    for j in range(i + 1, n):
        if (lst[i][0] > lst[j][0] and lst[i][1] > lst[j][1]):
            ords[j] += 1
        elif (lst[i][0] < lst[j][0] and lst[i][1] < lst[j][1]):
            ords[i] += 1

for i in range(n):
    print(ords[i])