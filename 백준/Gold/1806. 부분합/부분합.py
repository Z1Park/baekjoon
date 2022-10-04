n, m = map(int, input().split())
lst = list(map(int, input().split()))
i = j = 0
length = 100001
s = lst[0]
while True:
    if s < m:
        i += 1
        if i >= n:
            break
        s += lst[i]
    else:
        length = min(length, i-j+1)
        s -= lst[j]
        j += 1
print(0 if length == 100001 else length)