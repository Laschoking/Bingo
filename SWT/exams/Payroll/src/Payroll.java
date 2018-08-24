import java.util.List;

public class Payroll {
    private int payday;
    PayrollDisposition disposition;

    public Payroll(PayrollDisposition disposition, int payday){
        if(disposition == null) throw new NullPointerException();
        if(payday < 1 || payday > 31) throw new IllegalArgumentException();
        this.payday = payday;
        this.disposition = disposition;


    }

    public void doPayroll(PayrollDB db){
        List<Employee> empl = db.getEmployeeList();


        for(Employee e : empl){
            System.out.println(e.getClass().toString());
            if(e instanceof Appointee && e.isPayday(payday)){
                disposition.sendPayment(e, 1.5 * e.calculateDeductions());
            }
        }

    //prob 1. wie payday bekommen
        // 2. calculate  Pay von volunteer mit 0 belegen?
    }
}
