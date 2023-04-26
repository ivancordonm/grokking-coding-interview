package slidingwindow.bestbuystock;

public class MaxProfit {
    public int getMaxProfit(int[] stockPrices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int stockPrice : stockPrices) {
            if (stockPrice < minPrice) {
                minPrice = stockPrice;
            } else {
                int profit = stockPrice - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
