package kani.co.za;

import java.util.*;

public class AdvancedChallenges {

    public static int[] findDuplicates(int[] numbers) {
        // TODO: Implement

        if (numbers == null || numbers.length == 0) {
        return new int[0];
    }

    // Brilliant move: sorting groups duplicates together
    Arrays.sort(numbers);

    List<Integer> list = new ArrayList<>();

    // Stop at length - 1 to prevent IndexOutOfBoundsException!
    for (int i = 0; i < numbers.length - 1; i++) {
        
        // If current element matches the next element, we found a duplicate
        if (numbers[i] == numbers[i + 1]) {
            
            // Level Up: Only add it if it isn't already in our result list
            if (list.isEmpty() || list.get(list.size() - 1) != numbers[i]) {
                list.add(numbers[i]);
            }
        }
    }

    // Clean conversion back to primitive int array
    return list.stream().mapToInt(Integer::intValue).toArray();
    }

    

    public static char firstNonRepeatingChar(String input) {
        // TODO: Implement
        // Defensive check: handle null or empty string up front
        if (input == null || input.isEmpty()) {
            return ' ';
        }

        // Step 1: Create our frequency tracker map
        Map<Character, Integer> charCounts = new HashMap<>();

        // Step 2: Fill the map with counts
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            // If the character is already in the map, get its current count and add 1.
            // If it's not in the map, start its count at 0 and add 1.
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Step 3: Scan the string *again* from left to right. 
        // The first character we find with a map count of exactly 1 is our winner!
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        // If we checked every character and all of them had counts higher than 1
        return ' ';
    }

    public static int maxSubArraySum(int[] numbers, int k) {
        // TODO: Implement
       // Rule Guardrails: Handle null, empty, k out of bounds, or k <= 0
        if (numbers == null || numbers.length == 0 || k > numbers.length || k <= 0) {
            return 0;
        }

        int currentWindowSum = 0;

        // Step 1: Calculate the sum of the very first window (first 'k' elements)
        for (int i = 0; i < k; i++) {
            currentWindowSum += numbers[i];
        }

        // Initialize our max tracking variable with the first window's sum
        int maxSum = currentWindowSum;

        // Step 2: Slide the window across the rest of the array one step at a time
        for (int i = k; i < numbers.length; i++) {
            // Add the new element entering the front (numbers[i])
            // Subtract the old element leaving the back (numbers[i - k])
            currentWindowSum += numbers[i] - numbers[i - k];

            // Track the highest sum we've seen so far
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    public static Map<String, Integer> mergeStockPortfolios(Map<String, Integer> p1, Map<String, Integer> p2) {
        // TODO: Implement

       Map<String, Integer> stok = new HashMap<>();

        // Rule Guardrails: If a portfolio is null, ignore it safely
        if (p1 != null) {
            for (String stock : p1.keySet()) {
                int shares = p1.get(stock);
                // Put it straight into our new map
                stok.put(stock, shares);
            }
        }

        if (p2 != null) {
            for (String stock : p2.keySet()) {
                int sharesFromP2 = p2.get(stock);
                
                // Look up what we already have in 'stok' (defaults to 0 if we haven't seen it yet)
                int currentShares = stok.getOrDefault(stock, 0);
                
                // Add them together and save/overwrite it in 'stok'
                stok.put(stock, currentShares + sharesFromP2);
            }
        }

        // Rule Guardrail: Remove any stock where quantities dropped to 0 or fewer
        // We use 'removeIf' on the entrySet to safely clean up the map in place
        stok.entrySet().removeIf(entry -> entry.getValue() <= 0);

        return stok;
    }
}

