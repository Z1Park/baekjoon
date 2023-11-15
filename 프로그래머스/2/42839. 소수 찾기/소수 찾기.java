import java.util.*;
import java.util.stream.*;

class Solution {
    
    private class Prime {
        
        private boolean[] isPrime = new boolean[10000000];
        
        Prime() {
            에라토스테네스의채();
        }

        private void 에라토스테네스의채() {
            for (int i = 2; i < 10000000; i++) isPrime[i] = true;
            for (int i = 2; i < 10000000; i++) {
                if (isPrime[i]) {
                    for (int j = i*2; j < 10000000; j += i)
                        isPrime[j] = false;
                }
            }
        }
        
        public boolean checkPrime(int n) {
            return isPrime[n];
        }
    }
    
    private class Permutation {
        private List<List<Integer>> permutationList = new ArrayList<>();
        private int idx = 0;
        
        Permutation(int n) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i <= n; i++)
                perm(n, i, tmp);
        }
        
        private void perm(int n, int limit, List<Integer> tmp) {
            if (tmp.size() >= limit) {
                permutationList.add(List.copyOf(tmp));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (tmp.contains(i)) continue;
                tmp.add(i);
                perm(n, limit, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
        
        public boolean hasNextPermutation() {
            if (idx < permutationList.size())
                return true;
            return false;
        }
        
        public List<Integer> getNextPermutation() {
            if (idx < permutationList.size())
                return permutationList.get(idx++);
            return null;
        }
    }
    
    public int solution(String numbers) {
        Prime prime = new Prime();
        Permutation perm = new Permutation(numbers.length());
        Set<Integer> nums = new HashSet<>();
        while (perm.hasNextPermutation()) {
            String tmp = perm.getNextPermutation().stream()
                .map(i -> numbers.charAt(i))
                .map(Object::toString).collect(Collectors.joining());
            nums.add(Integer.parseInt(tmp));
        }
        return (int)nums.stream().filter(n -> prime.checkPrime(n)).count();
    }
}