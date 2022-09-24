lst = [int(input()) for _ in range(7)]

m = 100
s = 0
flag = True
for l in lst:
    if l % 2 == 1:
        flag = False
        s += l
        if m > l:
            m = l
if flag:
    print(-1)
else:
    print(s)
    print(m)