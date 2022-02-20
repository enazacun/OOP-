public class employeeCollection implements Collection{
    //ITERATOR'UN ÇALIŞMASI İÇİN VERİ YAPISI TANIMLAYIP İÇİNİ DOLDURMA İŞLEMLERİ
    Employee[] employeeIteratorArray =new Employee[100];
    //DİZİNİN TANIMLANABİLMESİ İÇİN DEĞER ATANMALIYDI,DEFAULT OLARAK 100 ATADIK
    int pos = 0;
    //VERİ YAPISINI OLUŞTURMAK İÇİN KULLANDIĞIMIZ METODLAR
    public void addEmployee(Employee employee){//EKLE
        employeeIteratorArray[pos]= employee;
        pos++;
    }

    public int employeeNumber(){//ELEMAN SAYISI

        return employeeIteratorArray.length;
    }
    public Iterator createIterator() {//COLLECTION INTERFACE'İ IMPLEMENTASYONU

        return new arrayIterator(this);
    }
}
