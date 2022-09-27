n, m = map(int, input().split())
lst = list(map(int, input().split()))
end = max(lst)
front = 0
while front <= end:
    tmp = (front + end) // 2
    s = 0
    for l in lst:
        if l > tmp:
            s += l - tmp
    if s >= m:
        front = tmp + 1
    else:
        end = tmp - 1
print(end)