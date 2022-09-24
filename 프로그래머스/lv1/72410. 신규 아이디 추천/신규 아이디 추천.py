def solution(new_id):
    ac = ['_', '-']
    answer = ''
    for a in new_id.lower():
        if ord(a) >= ord('0') and ord(a) <= ord('9'):
            answer += a
        elif ord(a) >= ord('a') and ord(a) <= ord('z'):
            answer += a
        elif a == '.':
            if answer != '' and answer[-1] != '.':
                answer += a
        elif a in ac:
            answer += a
    answer = answer.lstrip('.')
    answer = answer.rstrip('.')
    if answer == '':
        answer = 'a'
    if len(answer) >= 16:
        if answer[14] == '.':
            answer = answer[0:14]
        else:
            answer = answer[0:15]
    while len(answer) <= 2:
        answer += answer[-1]
    return answer