import sys
input = sys.stdin.readline

n = int(input())
stk = []
for i in range(n):
    tmp = input()
    if "push" in tmp:
        tmp = list(tmp.split())
        stk.append(tmp[1])
    elif "top" in tmp:
        if not stk:
            print(-1)
        else:
            print(stk[-1])
    elif "size" in tmp:
        print(len(stk))
    elif "pop" in tmp:
        if not stk:
            print(-1)
        else:
            print(stk[-1])
            del stk[-1]
    elif "empty" in tmp:
        if not stk:
            print(1)
        else:
            print(0)