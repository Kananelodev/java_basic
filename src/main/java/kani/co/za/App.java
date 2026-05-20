package kani.co.za;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {

          // 1. Create first sample portfolio (p1)
        Map<String, Integer> portfolio1 = new HashMap<>();
        portfolio1.put("AAPL", 10);
        portfolio1.put("GOOG", 5);

        // 2. Create second sample portfolio (p2)
        Map<String, Integer> portfolio2 = new HashMap<>();
        portfolio2.put("AAPL", 20);
        portfolio2.put("TSLA", 15);

        // 3. Run your merge method
        Map<String, Integer> result = AdvancedChallenges.mergeStockPortfolios(portfolio1, portfolio2);

        // 4. Print the output to see if it worked
        System.out.println("Merged Portfolio: " + result);
        
    }
}
