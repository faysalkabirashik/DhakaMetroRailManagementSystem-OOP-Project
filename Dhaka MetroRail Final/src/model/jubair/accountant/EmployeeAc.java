package model.jubair.accountant;

public class EmployeeAc extends Accountant {
    private String empBankAc;
    private float empSalary;
    private String status;

    public EmployeeAc(int empID, String empBankAc, String empName, String empDesignation, float empSalary, String status) {
        super(empID, empName, empDesignation);
        this.empBankAc = empBankAc;
        this.empSalary = empSalary;
        this.status = status;
    }

    public String getEmpBankAc() {
        return empBankAc;
    }

    public void setEmpBankAc(String empBankAc) {
        this.empBankAc = empBankAc;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeAc{" +
                "empBankAc='" + empBankAc + '\'' +
                ", empSalary=" + empSalary +
                ", status='" + status + '\'' +
                '}';
    }
}
