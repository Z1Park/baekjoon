import sys
input = sys.stdin.readline

string = list(input())
string.pop()
stk=[]
res=''
for a in string:
    if a == '(':
        stk.append(a)
    elif a == '*' or a == '/':
        while stk and (stk[-1] == '*' or stk[-1] =='/'):
            res += stk.pop()
        stk.append(a)
    elif a == '+' or a == '-':
        while stk and stk[-1] != '(':
            res+= stk.pop()
        stk.append(a)
    elif a == ')':
        while stk and stk[-1] != '(':
            res += stk.pop()
        stk.pop()
    else:
        res += a
while stk :
    res += stk.pop()
print(res)