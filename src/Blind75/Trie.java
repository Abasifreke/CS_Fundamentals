package Blind75;

import java.util.HashSet;

import Blind75.Trie.TrieNode;

public class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }

        void addChild(char c) {
            this.children[c - 'a'] = new TrieNode();
        }

        TrieNode hasChild(char c) {
            return this.children[c - 'a'];
        }

    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void printTrie() {
        printTrie(root, "");
    }

    private void printTrie(TrieNode node, String currWord) {
        TrieNode curr = node;
        for (int i = 0; i < 26; i++) {
            TrieNode child = curr.children[i];
            if (child.isWord) {
                char ch = (char) ('a' + i);
                printTrie(child, currWord + String.valueOf(ch));
            } else {
                System.out.println(currWord);
            }
        }
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            TrieNode childC = curr.hasChild(c);
            if (childC == null) {
                curr.addChild(c);
            }
            curr = curr.hasChild(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            TrieNode childC = curr.hasChild(c);
            if (childC == null) {
                return false;
            }
            curr = childC;
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            TrieNode childC = curr.hasChild(c);
            if (childC == null) {
                return false;
            }
            curr = childC;
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.printTrie();
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */