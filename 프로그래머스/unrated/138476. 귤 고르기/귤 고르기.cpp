#include <string>
#include <vector>
#include <queue>
#include <map>
#define MP(a,b) make_pair((a), (b))

using namespace std;

typedef pair<int, int> pii;

int solution(int k, vector<int> tangerine) {
    map<int, int> m;
    for (auto t : tangerine) {
        auto it = m.find(t);
        if (it == m.end()) m.insert(MP(t, 1));
        else it->second++;
    }
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    for (auto it = m.begin(); it != m.end(); it++) {
        pq.push(MP(it->second, it->first));
    }
    int cnt = tangerine.size() - k;
    while (!pq.empty()) {
        if (cnt < pq.top().first) break;
        cnt -= pq.top().first;
        pq.pop();
    }
    return pq.size();
}