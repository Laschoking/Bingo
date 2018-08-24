public class BestForCustomerPricing extends ComplexPricing {

    public BestForCustomerPricing(ISalePricing pricing) {
        super(pricing);


    }
    @Override
    public long getTotal(Sale sale){
        ISalePricing tmp = list.get(0);
        for(ISalePricing p : list){
            if (p.getTotal(sale) < tmp.getTotal(sale))

        }
}
