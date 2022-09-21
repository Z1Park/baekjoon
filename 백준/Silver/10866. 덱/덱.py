import sys
input = sys.stdin.readline

n = int(input())
que = []
for i in range(n):
    tmp = input()
    if "push_front" in tmp:
        tmp = list(tmp.split())
        que.insert(0, tmp[1])
    if "push_back" in tmp:
        tmp = list(tmp.split())
        que.append(tmp[1])
    elif "pop_front" in tmp:
        if not que:
            print(-1)
        else:
            print(que[0])
            del que[0]
    elif "pop_back" in tmp:
        if not que:
            print(-1)
        else:
            print(que[-1])
            del que[-1]
    elif "front" in tmp:
        if not que:
            print(-1)
        else:
            print(que[0])
    elif "back" in tmp:
        if not que:
            print(-1)
        else:
            print(que[-1])
    elif "size" in tmp:
        print(len(que))
    elif "empty" in tmp:
        if not que:
            print(1)
        else:
            print(0)