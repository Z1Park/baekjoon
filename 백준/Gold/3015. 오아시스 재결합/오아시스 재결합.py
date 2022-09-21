import sys
input = sys.stdin.readline

n = int(input())
lst = [int(input()) for _ in range(n)]
stk = []
count = 0
for l in lst:
    while stk and stk[-1][0] < l:
        count += stk.pop()[1]
    
    if not stk:
        stk.append([l, 1])
    elif stk[-1][0] > l:
        count += 1
        stk.append([l, 1])
    else:
        tmp = stk.pop()[1]
        count += tmp
        if stk:
            count += 1
        stk.append([l, tmp + 1])
print(count)