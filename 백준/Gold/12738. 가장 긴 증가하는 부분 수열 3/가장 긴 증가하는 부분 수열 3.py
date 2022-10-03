def find_index(value):
    start = 0
    end = len(c)
    while start < end:
        mid = (end + start) // 2
        if c[mid] < value:
            start = mid + 1
        else:
            end = mid
    return end

n = int(input())
lst = list(map(int, input().split()))
c = [-1000000001]
dp = [0 for _ in range(n+1)]
for i in range(n):
    if c[-1] < lst[i]:
        c.append(lst[i])
    else:
        c[find_index(lst[i])] = lst[i]
print(len(c)-1)