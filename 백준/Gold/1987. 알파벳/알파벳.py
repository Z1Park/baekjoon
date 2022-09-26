row, col = map(int, input().split())
lst = [list(input()) for _ in range(row)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

m_cnt = 0
visited = set(lst[0][0])
def dfs(r, c, count):
    global m_cnt, visited
    if m_cnt < count:
        m_cnt = count
    for i in range(4):
        if 0 <= r+dr[i] < row and 0 <= c+dc[i] < col and lst[r+dr[i]][c+dc[i]] not in visited:
            visited.add(lst[r+dr[i]][c+dc[i]])
            dfs(r+dr[i], c+dc[i], count + 1)
            visited.remove(lst[r+dr[i]][c+dc[i]])

dfs(0, 0, 1)
print(m_cnt)