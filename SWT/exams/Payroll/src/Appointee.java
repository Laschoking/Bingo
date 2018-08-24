public class Appointee extends Employee{
    private int dayOfMonth;
    private int hoursPerMonth;
    private double payPerHour;
    public Appointee(String id, int dayOfMonth,int hoursPerMonth, double payPerHour){

        super(id);
        if(payPerHour <= 0) throw new IllegalArgumentException();
        if(hoursPerMonth <= 0) throw new IllegalArgumentException();
        if(dayOfMonth <= 0 || dayOfMonth > 31)throw new IllegalArgumentException();
        this.dayOfMonth = dayOfMonth;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int payday) {


        return payday == dayOfMonth;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        return payPerHour * hoursPerMonth;
    }

    @Override
    public double calculateDeductions() {
        return 0.4 * hoursPerMonth * payPerHour;
    }

}