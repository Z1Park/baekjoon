n, h = map(int, input().split())
down = [0 for _ in range(h+1)]
up = [0 for _ in range(h+1)]
for i in range(n):
    tmp = int(input())
    if i % 2 == 0:
        down[tmp] += 1
    else:
        up[tmp] += 1

for i in range(h-1, 0, -1):
    down[i] += down[i+1]
    up[i] += up[i+1]

min_val = n
cnt = 0
for i in range(1, h+1):
    tmp = down[i] + up[h+1-i]
    if min_val > tmp:
        min_val = tmp
        cnt = 1
    elif min_val == tmp:
        cnt += 1
print(min_val, cnt)