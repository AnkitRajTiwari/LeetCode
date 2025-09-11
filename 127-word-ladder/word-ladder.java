class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for(String str : wordList) set.add(str);
        if(!set.contains(endWord)) return 0;

        Queue<String> memory = new LinkedList<>();
        memory.offer(beginWord);

        set.remove(beginWord);
        int noSteps = 1;
        while(!memory.isEmpty()){

            int size = memory.size();
            for(int k =0;k<size;k++){

            String original = memory.poll();
            if(original.equals(endWord))return noSteps;

            int n = original.length();
            for(int i =0;i<n;i++){
                for(int j = 0; j < 26; j++){

                    char ch = (char)(97 + j);
                    char tempArray[] = original.toCharArray();
                    if(ch != tempArray[i]){
                        tempArray[i] = ch;

                    String temp = new String(tempArray);
                        if(!temp.equals(original) && set.contains(temp)){
                            set.remove(temp);
                            memory.offer(temp);
                        }
                    }
                }
            }
            }

            noSteps++;
        }
        return 0;
    }
}

/*
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for(String str : wordList) set.add(str);
        if(!set.contains(endWord)) return 0;

        Queue<Pair<String,Integer>> memory = new LinkedList<>();
        memory.offer(new Pair<>(beginWord,1));

        set.remove(beginWord);
        int noSteps = 1;
        while(!memory.isEmpty()){

            int size = memory.size();
            for(int k =0;k<size;k++){
                Pair<String , Integer> node = memory.poll();
            String original = node.getKey();
            Integer steps = node.getValue();

            if(original.equals(endWord))return steps;

            noSteps = Math.max(steps,noSteps);

            int n = original.length();

            for(int i =0;i<n;i++){
                for(int j = 0; j < 26; j++){

                    char ch = (char)(97 + j);
                    char tempArray[] = original.toCharArray();
                    if(ch != tempArray[i]){
                        tempArray[i] = ch;

                    String temp = new String(tempArray);

                        if(!temp.equals(original) && set.contains(temp)){
                            set.remove(temp);
                            memory.offer(new Pair<>(temp, steps + 1));
                        }
                    }
                }
            }
            }

        }

        return 0;
    }
}
 */