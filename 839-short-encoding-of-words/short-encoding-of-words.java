class Solution {
    public int minimumLengthEncoding(final String[] words) {
        final TrieNode root = new TrieNode();

        for(final String word : words)
            this.insert(root, word);

        int result = 0;
        int height = 1;

        final Queue<TrieNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            final int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TrieNode curr = queue.poll();

                for(final TrieNode child : curr.children) {
                    if(child != null) {
                        if(child.isLeaf)
                            result += height + 1;

                        queue.offer(child);
                    }
                }
            }

            height++;
        }

        return result;
    }

    private void insert(final TrieNode root, final String word) {
        TrieNode curr = root;

        for(int i = word.length() - 1; i >= 0; --i) {
            final int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                curr.isLeaf = false;
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
    }

    private final class TrieNode {
        public final TrieNode[] children;
        public boolean isLeaf;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isLeaf = true;
        }
    }
}