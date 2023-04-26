package slidingwindow.bestbuystock;

public class MaxProfit {
    public int getMaxProfit(int[] stockPrices) {
        var maxProfit = 0;
        var current = 0;
        for(var sell = 1; sell < stockPrices.length; sell++) {
            var partial = stockPrices[sell] - stockPrices[sell - 1];
            if(current + partial < 0) current = 0;
            else current += partial;
            if(current > maxProfit) maxProfit = current;
        }
        return maxProfit;
    }
}

// 10,4,11,1,5;7
// 0  0 7  0 4

// 1,2,4,2,5,7,2,4,9,0,9 -> 18
// 0 1 3 1 4 6 1 3 8 0 9
