public class arrayIterator implements Iterator {
    employeeCollection employees;//ÇALIŞANLARIN TUTULDUĞU VERİ YAPISI
    int position=0;
    //CONSTRUCTOR
    public  arrayIterator (employeeCollection employees)
    {
        this.employees = employees;
    }

    public Employee next()
    {
        //EMP ITERATOR DİZİSİNDE O POZİSYONDAKİ ÇALIŞANI DÖNDÜRÜR
        Employee employeeItem =  employees.employeeIteratorArray[position];
        position += 1;//POZİSYON 1 ARTTIRILIR
        return employeeItem;
    }
    public boolean hasNext()
    {
        //BAŞKA EMP KALDI MI KONTROLÜ
        return position < employees.employeeNumber() &&
                employees.employeeIteratorArray[position] != null;
    }

}
