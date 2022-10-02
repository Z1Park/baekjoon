from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
arr = []
for _ in range(3):
    arr += list(input().split())
que = deque()
for i in range(9):
    if arr[i] == '0':
        que.append((''.join(arr), i, 0))

dic = dict()
flag = False
while que:
    puzzle, idx, cnt = que.popleft()
    if puzzle == '123456780':
        print(cnt)
        flag = True
        break
    for i in range(4):
        nr = idx // 3 + dr[i]
        nc = idx % 3 + dc[i]
        if 0 <= nr < 3 and 0 <= nc < 3:
            arr = list(puzzle)
            arr[idx], arr[nr*3+nc] = arr[nr*3+nc], arr[idx]
            if dic.get(''.join(arr)) == None:
                dic[''.join(arr)] = cnt+1
                que.append((''.join(arr), nr*3+nc, cnt+1))
if not flag:
    print(-1)