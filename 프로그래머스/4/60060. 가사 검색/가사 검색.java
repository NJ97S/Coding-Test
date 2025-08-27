import java.util.*;

/*
- 키워드 = 와일드카드 문자 중 하나인 '?'가 포함된 패턴 형태의 문자열
- '?' = 글자 하나를 의미, 어떤 문자에도 매칭 가능

- words: 가사에 사용된 모든 단어들이 담긴 배열
- queries: 찾고자 하는 키워드가 담긴 배열

- 각 키워드 별로 매치된 단어가 몇 개인지 순서대로 배열에 담아 반환
*/

class Solution {
    
    static class TrieNode {
        
        TrieNode[] children = new TrieNode[26];
        
        boolean isEndOfWord;
        
        int count;
        
    }
    
    static class Trie {
        
        TrieNode root = new TrieNode();
        
        void insert(String word) {
            
            TrieNode node = root;
            node.count++;
            
            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                
                node = node.children[idx];
                
                node.count++;
            }
            
            node.isEndOfWord = true;
            
        }
        
        int search(String word) {
            
            TrieNode node = root;
            
            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                
                if (node.children[idx] == null) return 0;
                
                node = node.children[idx];
            }
            
            return node.count;
            
        }
        
    }
    
    public int[] solution(String[] words, String[] queries) {
        
        int[] answer = new int[queries.length];
        int idx = 0;
        
        Trie[] topTrieArr = new Trie[10001];
        Trie[] downTrieArr = new Trie[10001];
        
        for (String word: words) {
            // topTrie insert
            Trie topTrie = topTrieArr[word.length()];
            
            if (topTrieArr[word.length()] == null) {
                topTrie = new Trie();
                topTrieArr[word.length()] = topTrie;
            }
            
            topTrie.insert(word);
            
            // downTrie insert
            Trie downTrie = downTrieArr[word.length()];
            
            if (downTrie == null) {
                downTrie = new Trie();
                downTrieArr[word.length()] = downTrie;
            }
            
            String temp = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                temp += word.charAt(i);
            }
            
            downTrie.insert(temp);
        }
        
        for (String query: queries) {
            String repQuery = query.replace("?", "");
            
            // topTrie search
            if (query.charAt(0) != '?') {
                Trie topTrie = topTrieArr[query.length()];
                
                answer[idx++] = topTrie == null ? 0 : topTrie.search(repQuery);
            } 
            
            // downTrie search
            else {
                Trie downTrie = downTrieArr[query.length()];
                
                String temp = "";
                for (int i = repQuery.length() - 1; i >= 0; i--) {
                    temp += repQuery.charAt(i);
                }
                
                answer[idx++] = downTrie == null ? 0 : downTrie.search(temp);
            }
        }
        
        return answer;
        
    }
    
}