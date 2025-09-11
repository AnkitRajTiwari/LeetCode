class Solution { 
    public int[] asteroidCollision(int[] asteroids) {
        
        // The Stack is our "holding area" for asteroids that are currently alive and moving.
        // Think of it like a pile where the newest asteroid is always on top.
        Stack<Integer> stack = new Stack<>(); 
        
        // We go through each asteroid in the input array, one by one.
        for (int ast : asteroids) { // 'ast' is the current asteroid we're looking at.
            
            // 'destroyed' is a flag. It tells us if the current asteroid ('ast') got destroyed in a collision.
            boolean destroyed = false; 
            
            // This 'while' loop is the heart of the collision logic.
            // It keeps running as long as:
            // 1. The stack is NOT empty (meaning there's at least one asteroid already in our holding area).
            // 2. The current asteroid ('ast') is moving LEFT (ast < 0).
            // 3. The asteroid on TOP of the stack is moving RIGHT (stack.peek() > 0).
            // These are the conditions for a potential collision!
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) { 
                
                // Collision happens! Let's see who wins.
                // We compare the absolute size (strength) of the left-mover ('ast') and the right-mover (stack.peek()).
                
                // Case 1: The current asteroid ('ast', moving left) is STRONGER than the one on the stack (moving right).
                if (Math.abs(ast) > stack.peek()) {
                    // The asteroid on the stack (moving right) gets destroyed. We remove it.
                    stack.pop(); 
                    // The current asteroid ('ast') survives, but it might collide with the NEXT asteroid on the stack,
                    // so the 'while' loop continues.
                } 
                // Case 2: They are EQUALLY strong.
                else if (Math.abs(ast) == stack.peek()) {
                    // Both asteroids destroy each other.
                    stack.pop(); // Remove the asteroid from the stack.
                    destroyed = true; // Mark the current asteroid ('ast') as destroyed.
                    break; // Since 'ast' is destroyed, it can't collide further, so we exit this 'while' loop.
                } 
                // Case 3: The asteroid on the stack (moving right) is STRONGER.
                else { // Math.abs(ast) < stack.peek()
                    // The current asteroid ('ast', moving left) gets destroyed.
                    destroyed = true; // Mark 'ast' as destroyed.
                    break; // Since 'ast' is destroyed, it can't collide further, so we exit this 'while' loop.
                }
            }
            
            // After the 'while' loop (meaning either no collision was possible, or all collisions for 'ast' are resolved):
            // If the current asteroid ('ast') was NOT destroyed in any collision...
            if (!destroyed) {
                // ...it survives! We add it to our stack of surviving asteroids.
                stack.push(ast); 
            }
        }
        
        // Now, the stack contains all the asteroids that survived the collisions, in the order they ended up.
        // We need to convert this stack into a regular array for the final result.
        
        // Create a new array 'result' with the same size as the number of surviving asteroids.
        int[] result = new int[stack.size()];
        // We fill this array from the END to the BEGINNING, because a Stack gives us elements from TOP to BOTTOM.
        // By popping elements and putting them at the end of the result array, we get the correct final order.
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop(); // Take the top asteroid from the stack and put it in our result array.
        }
        
        // Return the array of surviving asteroids.
        return result;
    }
}