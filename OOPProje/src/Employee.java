public abstract class Employee {
    private String name;
    private int salary;
    private String empType;
    private String dependentEmp;
    private static int blankNum =0;

//CONSTRUCTOR
    protected Employee(String empTypeC, String name, int salary, String dependentEmp){
        this.setEmpType(empTypeC);
        this.setName(name);
        this.setSalary(salary);
        this.setDependentEmp(dependentEmp);

    }
//EKRANA YAZDIRIRKEN HİYERARŞİK YAPIYI HİZALAMAK İÇİN YAZILDI.
    public static int getBlankNum() {
        return blankNum;
    }

    public static void setBlankNum(int blankNum) {
        Employee.blankNum = blankNum;
    }
//ABSTRACT METOTLAR
    public abstract int cost();
    public abstract void makeList();
    public abstract Employee findElement(String empName);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getDependentEmp() {
        return dependentEmp;
    }

    public void setDependentEmp(String dependentEmp) {
        this.dependentEmp = dependentEmp;
    }
}
