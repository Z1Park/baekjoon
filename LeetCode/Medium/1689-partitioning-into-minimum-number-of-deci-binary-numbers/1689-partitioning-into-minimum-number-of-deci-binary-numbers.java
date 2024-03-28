class Solution {
    public int minPartitions(String n) {
        int result = 0;
        for (char c : n.toCharArray())
            if (result < c) result = c;
        return result - '0';
    }
}