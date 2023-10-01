#include <string>
#include <vector>
#include <map>

using namespace std;

string stringToLower(string& s) {
    string res;
    for (char c : s) res.append(1, tolower(c));
    return res;
}

int solution(int cacheSize, vector<string> cities) {
    if (cacheSize == 0) return 5 * cities.size();
    map<string, int> m;
    int time = 0;
    for (auto c : cities) {
        string city = stringToLower(c);
        auto it = m.find(city);
        if (it != m.end()) {
            time++;
            m.erase(it);
            m.insert({city, time});
        }
        else {
            time += 5;
            if (m.size() >= cacheSize) {
                auto minIter = m.begin();
                for (auto it = m.begin()++; it != m.end(); it++) {
                    if (it->second < minIter->second) minIter = it;
                }
                m.erase(minIter);
            }
            m.insert({city, time});
        }
    }
    return time;
}