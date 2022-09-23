n = int(input())
price = [list(map(int, input().split())) for _ in range(n)]

p0 = [price[0][0]]
p1 = [price[0][1]]
p2 = [price[0][2]]

for i in range(1, n):
    p0.append(price[i][0] + min(p1[i - 1], p2[i - 1]))
    p1.append(price[i][1] + min(p0[i - 1], p2[i - 1]))
    p2.append(price[i][2] + min(p0[i - 1], p1[i - 1]))

print(min(p0[-1], p1[-1], p2[-1]))