s = input()
l = list("CAMBRIDGE")
answer = ""
for a in s:
    if a not in l:
        answer += a
print(answer)