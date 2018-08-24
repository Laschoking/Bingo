public class Volunteer extends Employee {
    public Volunteer(String id) {
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {

        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        throw new UnpayableEmployeeException("klsdkfj");

    }

    @Override
    public double calculateDeductions(){

        return 0;
    }




}
