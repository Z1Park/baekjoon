#include <string>
#include <vector>
#include <cctype>
#include <algorithm>

using namespace std;

typedef struct data_t {
    string head;
    int num;
    int idx;
    
    data_t(string head, int num, int idx) {
        this->head = head;
        this->num = num;
        this->idx = idx;
    }
} data_t;

bool cmp(data_t& a, data_t& b) {
    if (a.head != b.head) return a.head < b.head;
    if (a.num != b.num) return a.num < b.num;
    return a.idx < b.idx;
}

vector<string> solution(vector<string> files) {
    vector<data_t> vec;
    for (int idx = 0; idx < files.size(); idx++) {
        string head, file(files[idx]);
        int num = -1;
        for (int i = 0; i < file.size(); i++) {
            if (isdigit(file[i])) {
                head = file.substr(0, i);
                for (int j = i+1; j < file.size(); j++) {
                    if (!isdigit(file[j])) {
                        num = stoi(file.substr(i, j - i));
                        break;
                    }
                }
                if (num == -1) num = stoi(file.substr(i, file.size() - i));
                break;
            }
            else file[i] = tolower(file[i]);
        }
        data_t data(head, num, idx);
        vec.push_back(data);
    }
    sort(vec.begin(), vec.end(), cmp);
    vector<string> res;
    for (auto v : vec) res.push_back(files[v.idx]);
    return res;
}