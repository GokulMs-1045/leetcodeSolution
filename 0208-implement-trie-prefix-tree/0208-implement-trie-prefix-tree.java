class Node{

    Node []links = new Node[26];

    boolean flag = false;

    boolean isEnd(){
        return flag;
    }

    void setEnd(){
        flag = true;
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
}


class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){

            if(!node.containsKey(ch))
                node.put(ch, new Node());

            node = node.get(ch);
        }

        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){

            if(!node.containsKey(ch))
                return false;

            node = node.get(ch);
        }

       return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(char ch : prefix.toCharArray()){

            if(!node.containsKey(ch))
                return false;

            node = node.get(ch);
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