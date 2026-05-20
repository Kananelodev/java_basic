# Assessment 003 — Advanced Data Manipulation & Data Structures

## Learning Outcomes Tested
- Selection and manipulation of Java Collections (List, Set, Map)
- Frequency tracking algorithms
- Custom multi-pointer and sliding window strategies
- Handling complex edge cases defensively

## Question 1 — `findDuplicates(int[] numbers)`
Write a method that takes an array of integers and returns a list of all numbers that appear more than once.

### Rules:
- The returned list must contain unique values (if a number appears 3 times, it should only be in the output list once).
- The returned list must be sorted in ascending order.
- If the input array is null or empty, return an empty list.

### Example:
```java
findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1, 3})
// Returns: [2, 3]
```

## Question 2 — `firstNonRepeatingChar(String input)`
Write a method that finds the first character in a string that does not repeat anywhere else in that string.

### Rules:
- The method must be case-sensitive ('a' and 'A' are different characters).
- Spaces count as valid characters.
- If all characters repeat, or if the input string is null or empty, return a space character `' '`.

### Example:
```java
firstNonRepeatingChar("swiss") 
// 's' repeats, 'w' does not repeat, 'i' does not repeat. 
// 'w' is the *first* one we encounter that is unique.

// Returns: 'w'
```

## Question 3 — `maxSubArraySum(int[] numbers, int k)`
Write a method that takes an array of integers and an integer k, and returns the maximum sum of any contiguous subarray of size k.

### Rules:
- "Contiguous" means the numbers must be right next to each other in the array.
- If k is greater than the array length, if k <= 0, or if the array is null/empty, return 0.

### Example:
```java
maxSubArraySum(new int[]{2, 1, 5, 1, 3, 2}, 3)
// Subarrays of size 3 are:
// [2, 1, 5] -> Sum: 8
// [1, 5, 1] -> Sum: 7
// [5, 1, 3] -> Sum: 9  <-- Maximum found
// [1, 3, 2] -> Sum: 6

// Returns: 9
```

## Question 4 — `mergeStockPortfolios(Map<String, Integer> portfolio1, Map<String, Integer> portfolio2)`
You are managing two financial portfolios. Each portfolio tracks stock tickers (Keys) and the number of shares owned (Values). Write a method to merge these two portfolios.

### Rules:
- If a stock ticker exists in both portfolios, sum their share quantities together.
- If a stock ticker only exists in one portfolio, include it in the merged portfolio as-is.
- If a quantity drops to 0 or fewer shares during a merge, it should not be included in the final map.
- If either portfolio is null, treat it as an empty portfolio. If both are null, return an empty map.

### Example:
```java
Map<String, Integer> p1 = Map.of("AAPL", 10, "TSLA", 5, "MSFT", 20);
Map<String, Integer> p2 = Map.of("AAPL", 5, "NVDA", 15, "MSFT", -20);

mergeStockPortfolios(p1, p2)
// AAPL: 10 + 5 = 15
// TSLA: 5 (only in p1)
// NVDA: 15 (only in p2)
// MSFT: 20 + (-20) = 0 (Excluded because it is <= 0)

// Returns a Map containing: {"AAPL"=15, "TSLA"=5, "NVDA"=15}
```