#include <string>
#include <vector>

using namespace std;

int solution(vector<int> citations) {
    int n = citations.size();
    for (int h = n; h > 0; h--) {
        int cnt = 0;
        for (int cit : citations)
            if (cit >= h) cnt++;
        if (cnt >= h) return h;
    }
    return 0;
}