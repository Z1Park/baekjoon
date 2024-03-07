class Trie {
    
    private Set<String> wordSet = new HashSet<>();
    private Map<Character, List<String>> wordMap = new HashMap<>();

    public Trie() {
        for (int i = 0; i < 26; i++)
            wordMap.put((char)('a' + i), new ArrayList<>());
    }
    
    public void insert(String word) {
        wordSet.add(word);
        wordMap.get(word.charAt(0)).add(word);
    }
    
    public boolean search(String word) {
        return wordSet.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for (String word : wordMap.get(prefix.charAt(0))) {
            if (word.startsWith(prefix))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */