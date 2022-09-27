n, m = map(int, input().split())
lst = [int(input()) for _ in range(n)]
end = lst[0]
front = 0
count = n
while end != front + 1:
    tmp = (front + end) // 2
    count = 0
    for l in lst:
        count += l // tmp
    if count < m:
        end = tmp
    else:
        front = tmp
count = 0
for l in lst:
    count += l // end
if count == m:
    print(end)
else:
    print(front)