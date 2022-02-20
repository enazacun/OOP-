public class Director extends Employee {
    //İÇERİSİNDE DİREKTÖRÜN ALTINDAKİ ÇALIŞANLAR TUTULUR.
    employeeCollection employeeCollection =new employeeCollection();

    //CONSTRUCTOR
    public Director(String empType, String name, int salary, String dependentEmp) {

        super(empType,name,salary,dependentEmp);
    }
    //MALİYET HESAPLAMAK İÇİN OLUŞTURULDU.
    public int cost(){
        int total = 0;//MALİYET HESABI İÇİN TUTULDU
        Iterator iterator = employeeCollection.createIterator();
        while (iterator.hasNext()) {
            Employee employee1 =  iterator.next();
            total+= employee1.cost();//RECURSIVE
        }
        return getSalary() + total;//DİREKTÖRÜN MAAŞI EKLENMİŞ HALİ
    }
    //ÇALIŞANLARIN LİSTELENMESİNİ SAĞLAYAN METOD
    public void makeList(){
        System.out.println(" ".repeat(getBlankNum())+getEmpType()+"("+getName()+","+cost()+")");
        setBlankNum(getBlankNum() + 1);//HİYERARŞİK DÜZENİN SAĞLANMASI İÇİN 1 TAB İÇERİ KAYDIRILDI
        Iterator iterator = employeeCollection.createIterator();//ITERATOR OLUŞTURULDU
        while (iterator.hasNext()) {
            Employee employee1 =iterator.next();//SONRAKİ ELEMANLARI DOLAŞIYOR
            employee1.makeList();//RECURSIVE
        }
        setBlankNum(getBlankNum() - 1);//DİREKTÖRÜN ALTINDAKİ DİREKTÖRLERİ AYNI HİZADA TUTMAK İÇİN KULLANILDI
    }
    public void addEmployee(Employee employee){

        employeeCollection.addEmployee(employee);//DİREKTÖRÜN ALTINDA ÇALIŞAN ELEMANLARI EKLEYEN METOT
    }
    //PARAMETRE OLARAK VERİLEN KİŞİ ADI İLE, ÇALIŞAN NESNESİNİ DÖNDÜRÜYOR
    public Employee findElement(String empName){
        if(empName.equals(getName())){//VERİLEN İSME EŞİTSE DİREKT O NESNEYİ DÖNDÜRÜR
            return this;
        }
        else {//EŞİT DEĞİLSE ITERATOR İLE NESNEYİ ARAMAYA BAŞLAR,AĞAÇ YAPISINDA DOLAŞMA MANTIĞI KULLANILDI
            Iterator iterator = employeeCollection.createIterator();
            while (iterator.hasNext()) {
                Employee employee1 =iterator.next();//ITERATOR'IN DOLAŞMASI İÇİN OLUŞTURULDU
                //RECURSIVE
                Employee employee2 = employee1.findElement(empName);//ITERATOR DOLAŞIRKEN ARANAN KİŞİYİ BULDUĞUNDA KAYDETMEK İÇİN OLUŞTURULDU
                if (employee2 !=null){
                    return employee2;//KAYDINI TUTTUĞUMUZ NESNE BOŞ DEĞİLSE DÖNDÜRÜLÜR
                }
            }
        }return null;
    }

}

