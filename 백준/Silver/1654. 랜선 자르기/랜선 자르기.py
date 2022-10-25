n, m = map(int, input().split())
log = [int(input()) for _ in range(n)]

def check(length):
    count = 0
    for l in log:
        count += l // length
    return count

start = 1
end = max(log)
while start <= end:
    mid = (start + end) // 2
    if check(mid) < m:
        end = mid - 1
    else:
        start = mid + 1
print(end)