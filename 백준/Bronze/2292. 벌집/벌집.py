n = int(input())

start = 1
d = 6
count = 1
while (start + d < n):
    count += 1
    start += d
    d += 6
if n == 1:
    print(1)
else:
    print(count + 1)