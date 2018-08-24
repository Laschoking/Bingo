public class AbsoluteDiscountPricing implements ISalePricing  {
    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold){
        if(discount < 0 || threshold < 0) throw new IllegalArgumentException();
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        long tmp = sale.getPreDiscountTotal() - discount;
        if(tmp > threshold)return tmp;
        if(sale.getPreDiscountTotal() < threshold)return sale.getPreDiscountTotal();
        else return threshold;

    }
}
