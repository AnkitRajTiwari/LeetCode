class Solution {

    // Method to count how many letters have their lowercase version appear
    // before the uppercase version in the string
    public int numberOfSpecialChars(String word) {

        // Initialize a counter to keep track of special characters
        int count = 0;

        // Loop through all 26 letters of the English alphabet
        for(int i = 0; i < 26; i++) {

            // Convert the index to a corresponding uppercase character
            // 'A' has ASCII value 65, so adding i gives 'A' to 'Z'
            char upperCase = (char) (i + 65);

            // Convert the index to a corresponding lowercase character
            // 'a' has ASCII value 97, so adding i gives 'a' to 'z'
            char lowerCase = (char) (i + 97);

            // Check if the lowercase character exists in the string
            // and if its last position is before the first occurrence of the uppercase character
            if (word.indexOf(lowerCase) != -1 && 
                word.lastIndexOf(lowerCase) < word.indexOf(upperCase)) {

                // If both conditions are true, it's a special character -> increase the count
                count++;
            }
        }

        // Return the total number of special characters found
        return count;
    }
}
