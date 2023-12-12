class Solution {
    
    private int N, M;
    private int[][] key, lock;
    
    private void rotateKey() {
        int[][] newKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++)
                newKey[i][j] = key[j][M-1-i];
        }
        key = newKey;
    }
    
    private boolean tryUnlock(int rPos, int cPos) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nr = i - rPos, nc = j - cPos;
                if (lock[i][j] == 0) {
                    if (nr < 0 || nr >= M || 
                        nc < 0 || nc >= M || 
                        key[nr][nc] == 0) 
                        return false;
                }
                else {
                    if (nr < 0 || nr >= M || 
                        nc < 0 || nc >= M) continue;
                    if (key[nr][nc] == 1) return false;
                }
            }
        }
        return true;
    }
    
    public boolean solution(int[][] k, int[][] l) {
        key = k;
        lock = l;
        M = key.length;
        N = lock.length;
        for (int rotCnt = 0; rotCnt < 4; rotCnt++) {
            for (int rPos = -M + 1; rPos < N; rPos++) {
                for (int cPos = -M + 1; cPos < N; cPos++) {
                    if (tryUnlock(rPos, cPos)) return true;
                }
            }
            rotateKey();
        }
        return false;
    }
}