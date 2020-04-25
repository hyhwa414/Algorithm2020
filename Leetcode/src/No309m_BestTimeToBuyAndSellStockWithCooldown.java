
public class No309m_BestTimeToBuyAndSellStockWithCooldown {
	public static void main(String[] args) {
		int[] p1 = {1,2,3,0,2};
		int o1 = maxProfit(p1);
	}

	public static int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		
		int sell = 0;
		int buy = - prices[0];
		int presell = 0;
		int prebuy = 0;
		for(int i = 1; i < prices.length; i++) {
			prebuy = buy;
			buy = Math.max(buy, presell - prices[i]);
			presell = sell;
			sell = Math.max(sell, prebuy + prices[i]);
		}
		
		return sell;
	}
}
