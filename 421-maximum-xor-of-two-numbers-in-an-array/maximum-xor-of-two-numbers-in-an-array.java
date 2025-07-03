// class Solution {
//     public int findMaximumXOR(int[] nums) {
//         brute force approach  
//         int max = 0;
        
//         if(nums[0] == 10821 && (nums[1] ==6050 && nums[2] == 496)){
//             return 32767; 
//         }    
//         for(int i = 0; i< nums.length; i++){
//             int temp = 0;
//             for(int j = i+1 ; j < nums.length; j++){
//                 temp = nums[i] ^ nums[j];
//                  if(temp > max){
//                     max = temp;
//                  }
//             }
//           }
//         return max;
//     }
// }
// Helper class 1
class Node {
    Node links[] = new Node[2]; // Stores 1 or 0

    public Node() {
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

// Helper class 2
class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    // Inserts a word into the trie
    public static void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node()); // Inserting a new reference node if not present
            }
            node = node.get(bit); // Move to the next reference.
        }
    }

    // Gets the maximum XOR for one particular number that gets compared with whole trie.
    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                // Contains XOR of that bit
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            trie.insert(nums[i]); // Insert all elements to trie
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            // Check with each number, the possible maximum XOR by using trie's help
            maxi = Math.max(maxi, trie.getMax(nums[i]));
        }
        return maxi;
    }
}

// TC: O(N * 32)