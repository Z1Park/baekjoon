import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    ps = input()
    count = 0
    flag = 0
    for a in ps:
        if a == '\n':
            break
        if a == '(':
            count += 1
        else:
            if count <= 0:
                flag = 1
                print("NO")
                break
            else:
                count -= 1
    if flag == 0:
        if count == 0:
            print("YES")
        else:
            print("NO")