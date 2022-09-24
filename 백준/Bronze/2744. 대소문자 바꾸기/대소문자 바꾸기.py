ss = input()
answer = ''
for s in ss:
    if s.islower():
        answer += s.upper()
    elif s.isupper():
        answer += s.lower()
    else:
        answer += s
print(answer)