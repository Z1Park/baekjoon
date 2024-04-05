class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = N - 1; i >= 0; i--) {
            int r = i, c = 0;
            while (r < N && c < M)
                pq.add(mat[r++][c++]);
            r = i;
            c = 0;
            while (!pq.isEmpty())
                mat[r++][c++] = pq.poll();
        }
        for (int i = 1; i < M; i++) {
            int r = 0, c = i;
            while (r < N && c < M)
                pq.add(mat[r++][c++]);
            r = 0;
            c = i;
            while (!pq.isEmpty())
                mat[r++][c++] = pq.poll();
        }
        return mat;
    }
}

/*
11 25 66  1 69  7
23 55 17 45 15 52
75 31 36 44 58  8
22 27 33 25 68  4
84 28 14 11  5 50



 5 17  4  1 52  7
11 11 25 45  8 69
14 23 25 44 58 15
22 27 31 36 50 66
84 28 75 33 55 68
*/