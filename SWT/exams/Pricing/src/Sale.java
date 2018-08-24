public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;


    public Sale(long preDiscountTotal, ISalePricing pricing){
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal(){
        return preDiscountTotal;
    }
    public void setPricing(ISalePricing pricing){

    }

    public long getTotal(){
        return 0;
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        return null;
    }
}
