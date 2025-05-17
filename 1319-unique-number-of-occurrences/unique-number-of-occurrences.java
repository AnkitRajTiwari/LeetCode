class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> map=new HashMap<>(); // to store number of frequency of each 
                                                      //element 
        HashSet<Integer> set=new HashSet<>();// used to store unique element 

        for(int i:arr)
        {
           // checks
           if(map.containsKey(i))
           {
            map.put(i,map.get(i)+1);
           }
           else
           {
            map.put(i,1);
           }
        }
        for(int key:map.keySet())
        {
            if(set.contains(map.get(key))) // contains duplicate 
            {
                return false;
            }
            else
            {
                set.add(map.get(key)); // unique occurence 
            }
        }
        return true;
    }
}



// Great question! Let's explain why get is used in this line:

// map.put(i, map.get(i) + 1);
// What does map.get(i) do?
// map is a HashMap that stores keys and their associated values.

// get(key) returns the value associated with the given key.

// In this case, the key is i (a number from the array).

// The value is the current count (frequency) of that number in the map.