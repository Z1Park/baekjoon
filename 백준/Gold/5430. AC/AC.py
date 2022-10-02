from collections import deque

tc = int(input())
for t in range(tc):
    command = list(input())
    n = int(input())
    que = deque()
    lst = list(input()[1:-1].split(','))
    for l in lst:
        que.append(l)
    rev = False
    err_flag = False
    if n == 0 and 'D' in command:
        print('error')
        continue
    for cmd in command:
        if cmd == 'R':
            rev = not rev
        else:
            try:
                if rev:
                    tmp = que.pop()
                else:
                    tmp = que.popleft()
            except:
                err_flag = True
                print('error')
                break
    if not err_flag:
        if rev:
            print('['+','.join(reversed(que))+']')
        else:
            print('['+','.join(que)+']')