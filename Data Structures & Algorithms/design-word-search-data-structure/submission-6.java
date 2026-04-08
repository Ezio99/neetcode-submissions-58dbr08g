class WordDictionary {
    public static class DictionaryNode {
        private DictionaryNode[] children;
        boolean isWord;

        public DictionaryNode() {
            children = new DictionaryNode[26];
            isWord = false;
        }

        public DictionaryNode[] getChildren() {
            return children;
        }

        public void setChildren(DictionaryNode[] children) {
            this.children = children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    DictionaryNode root;

    public WordDictionary() {
        root = new DictionaryNode();
    }

    public void addWord(String word) {
        DictionaryNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currentNode.getChildren()[word.charAt(i) - 'a'] == null) {
                currentNode.getChildren()[word.charAt(i) - 'a'] = new DictionaryNode();
            }
            currentNode = currentNode.getChildren()[word.charAt(i) - 'a'];
        }
        currentNode.setWord(true);
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, DictionaryNode node) {
        if (index == word.length()) {
            return node.isWord();
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (DictionaryNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            DictionaryNode child = node.children[ch - 'a'];
            return child != null && searchInNode(word, index + 1, child);
        }
    }
}
