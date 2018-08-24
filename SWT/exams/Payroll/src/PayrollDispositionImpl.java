import java.util.*;


public class PayrollDispositionImpl implements PayrollDisposition {
    Map<Employee,Double> payments;
    Collection<Double> totalPayments;

    public PayrollDispositionImpl(){
        payments = new HashMap<>();
    }
//volunteer nicht enthalten
    @Override
    public void sendPayment(Employee empl, double payment) {
        if(empl == null) throw new NullPointerException();
        if(payment <= 0) throw new IllegalArgumentException();
        payments.put(empl, (double) Math.round(payment * 10)/ 10);
    }

    public double getTotal(){
        double tmp = 0;
        totalPayments = payments.values();
        for (Double p : totalPayments){
            tmp += p;
        }
        return tmp;

    }

    public double getAverage(){
        if (payments.size() == 0) return 0;
        else return getTotal() / payments.size();
    }

    public Map<Employee, Double> getPayments() {
        return payments;
    }

}
