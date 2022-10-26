import sys
input = lambda : sys.stdin.readline()
n = int(input())
stk = []
cnt = 0
for _ in range(n):
    curr = int(input())
    while stk and stk[-1][0] < curr:
        cnt += stk.pop()[1]
    
    if not stk:
        stk.append((curr, 1))
    elif stk[-1][0] > curr:
        cnt += 1
        stk.append((curr, 1))
    else:
        tmp = stk.pop()[1]
        cnt += tmp
        if stk:
            cnt += 1
        stk.append((curr, tmp+1))
print(cnt)