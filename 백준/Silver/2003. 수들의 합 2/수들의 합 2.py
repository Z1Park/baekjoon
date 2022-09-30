n, m = map(int, input().split())
lst = list(map(int, input().split()))
cnt = 0
for i in range(n):
    s = 0
    for j in range(i, n):
        s += lst[j]
        if s > m:
            break
        elif s == m:
            cnt += 1
            break
print(cnt)