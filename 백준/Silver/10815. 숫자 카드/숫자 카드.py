n = int(input())
lst = list(map(int, input().split()))
lst.sort()
m = int(input())
check = list(map(int, input().split()))
result = []
for c in check:
    front, end = 0, n - 1
    while front + 1 != end:
        mid = (front + end) // 2
        if lst[mid] < c:
            front = mid
        elif lst[mid] > c:
            end = mid
        else:
            front = mid
            break
    if lst[front] == c or lst[end] == c:
        result.append(1)
    else:
        result.append(0)
print(*result)