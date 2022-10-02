def make_num(idx, length, num):
    if idx == length:
        nums.append(num)
        return
    for i in range(10):
        if i not in broken:
            make_num(idx+1, length, num*10+i)

n = int(input())
m = int(input())
if m != 0:
    broken = list(map(int, input().split()))
else:
    broken = []
k = 1
tmp = n
while tmp >= 10:
    k += 1
    tmp //= 10
i = 0
min_val = 500000
while i <= k+1:
    if i == 0:
        if min_val > abs(n-100):
            min_val = abs(n-100)
    else:
        nums = []
        make_num(0, i, 0)
        for num in nums:
            if min_val > i+abs(n-num):
                min_val = i+abs(n-num)
    i += 1
print(min_val)