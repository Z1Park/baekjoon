def solution(id_list, report, k):
    count = {name : 0 for name in id_list}
    record = {name : [] for name in id_list}
    for rep in report:
        user, rp = rep.split()
        if rp not in record[user]:
            record[user].append(rp)
            count[rp] += 1
    
    reported = []
    for i in id_list:
        if count[i] >= k:
            reported.append(i)
            
    answer = [0] * len(id_list)
    for key, value in enumerate(id_list):
        answer[key] += len(set(record[value]) & set(reported))
    
    return answer