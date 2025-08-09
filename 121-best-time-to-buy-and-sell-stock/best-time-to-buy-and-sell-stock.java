class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxSell =0;

        for(int i=1;i<prices.length;i++){
            if(prices[i-1] > prices[i] && prices[i] <buy){
                buy = prices[i];
            }
            if(prices[i]>buy){
                int sell = prices[i] - buy;
                maxSell = Math.max(sell, maxSell);
            }
        }
        return maxSell;
    }
}