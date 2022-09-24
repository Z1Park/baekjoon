lst = [list(map(int, input().split())) for _ in range(9)]
m = 0
idx1 = 0
idx2 = 0
for i in range(9):
    ma = max(lst[i])
    if ma > m:
        m = ma
        idx1 = i
        idx2 = lst[i].index(ma)
print(m)
print(idx1 + 1, idx2 + 1)