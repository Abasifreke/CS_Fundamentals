class Trie {

    class TrieNode {
        public char val;
        public TrieNode[] children;
        public boolean isWord;

        TrieNode(){
            this.children = new TrieNode[26];
        }

        TrieNode(char val){
            this.val = val;
            this.children = new TrieNode[26];
        }

    }


    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = this.root;

        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(c);
            }

            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = this.root;

        for(char c: word.toCharArray()){
            if(node.children[c- 'a'] == null) return false;

            node = node.children[c-'a'];
        }

        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;

        for(char c: prefix.toCharArray()){
            if(node.children[c- 'a'] == null) return false;

            node = node.children[c-'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */