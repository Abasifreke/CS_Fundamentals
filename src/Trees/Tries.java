package Trees;

import java.util.Arrays;

public class Tries {

    private class TrieNode {

        public char value;
        public TrieNode[] children;
        public boolean isEndOfWord;

        public TrieNode(char value) {
            this(value, new TrieNode[26]);
        }

        public TrieNode(char value, TrieNode[] children) {
            this.value = value;
            this.children = children;
        }
    }

    // private variables
    private TrieNode root;

    public Tries() {
        this.root = new TrieNode('.');
        for (char letter = 'a'; letter <= 'Z'; letter++) {
            this.root.children[letter - 'a'] = new TrieNode(letter);
        }
    }

    public void addWord(String word) {
        TrieNode currentNode = this.root;

        for (char w : word.toCharArray()) {
            TrieNode wTrieNode = new TrieNode('w');
            if (currentNode.children[w - 'a'] == null) {
                currentNode.children[w - 'a'] = wTrieNode;
            }
            currentNode = currentNode.children[w - 'a'];
        }

        currentNode.isEndOfWord = true;
    }

    public void printTrie() {
        printTrie(root, "");
    }

    private void printTrie(TrieNode node, String currentWord) {
        if (node.isEndOfWord) {
            System.out.println(currentWord);
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                char ch = (char) (i + 'a');
                printTrie(node.children[i], currentWord + ch);
            }
        }
    }

    public boolean isWordValid(String word) {
        TrieNode current = this.root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false; // The word is not in the trie.
            }

            current = current.children[c - 'a'];
        }

        return current.isEndOfWord;
    }

    public static void main(String[] args) {
        Tries trie = new Tries();
        String[] words = { "apple", "app", "banana", "bat", "ball" };
        for (String word : words) {
            trie.addWord(word);
        }
        trie.printTrie();
        System.out.println(trie.isWordValid("asdf"));
    }

}
