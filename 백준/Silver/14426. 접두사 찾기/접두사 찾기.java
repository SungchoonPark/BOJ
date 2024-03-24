import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            if (trie.contains(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setLastChar(true);
        }

        boolean contains(String word) {
            TrieNode trieNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!trieNode.getChildNodes().containsKey(c)) return false;
                trieNode = trieNode.getChildNodes().get(c);
            }
            return true;
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        void setLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }
}