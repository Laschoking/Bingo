import java.util.*;
public abstract class ComplexPricing implements ISalePricing{
    private List<ISalePricing> list;

    public ComplexPricing(ISalePricing pricing){
        if(pricing == null)throw new NullPointerException();
        list = new ArrayList<ISalePricing>();
        list.add(pricing);




    }

    public void add(ISalePricing pricing){
        list.add(pricing);
    }

    public ISalePricing getPricings(){
        return null;
    }

    public long getTotal(Sale sale){


        return 0;

    }
}
