pre = [1, 1, 2, 2, 2, 8]
get = list(map(int, input().split()))
for i in range(6):
    print(pre[i] - get[i], end=' ')
print()