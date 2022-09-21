import sys
input = sys.stdin.readline

left = list(input())
del left[-1]
right = []
n = int(input())
for i in range(n):
    tmp = list(input().split())
    if "L" == tmp[0]:
        if len(left) > 0:
            right.append(left.pop())
    elif "D" == tmp[0]:
        if len(right) > 0:
            left.append(right.pop())
    elif "B" == tmp[0]:
        if len(left) > 0:
            left.pop()
    elif "P" == tmp[0]:
        left.append(tmp[1])
print(''.join(left) + ''.join(reversed(right)))