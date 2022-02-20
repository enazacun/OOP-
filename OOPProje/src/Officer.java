public class Officer extends Employee {

    public Officer(String empType, String name, int salary, String dependentEmp) {

        super(empType,name,salary,dependentEmp);
    }
    public int cost(){
        return getSalary();
    }

    public void makeList(){

        System.out.println(" ".repeat(getBlankNum())+getEmpType()+"("+getName()+","+cost()+")");

    }
    public Employee findElement(String empName){
        if(empName.equals(getName())){
            return this;
        }
        else {
            return null;
        }
    }

}