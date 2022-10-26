import sys
from collections import deque
input = lambda : sys.stdin.readline().rstrip()
find = list(input())
rev_find = list(reversed(find))
txt = list(input())
txt = deque(txt, len(txt))
left = []
right = []
flag = True
while txt:
    if flag:
        left.append(txt.popleft())
        if find == left[-len(find):]:
            left[-len(find):] = []
            flag = not flag
    else:
        right.append(txt.pop())
        if rev_find == right[-len(find):]:
            right[-len(find):] = []
            flag = not flag
while right:
    left.append(right.pop())
    if find == left[-len(find):]:
        left[-len(find):] = []
print(''.join(left))