n = int(input())
lst = set(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))
result = []
for c in check:
    if c in lst:
        result.append(1)
    else:
        result.append(0)
print(*result)