import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectorTest {

    Director d1 = new Director("D","Cenk Erdur",5000,"Root");
    Director d2 = new Director("D","Ozgun Yilmaz",3000,"Cenk");

    @org.junit.jupiter.api.Test
    void addEmployee() {

        employeeCollection direktorler = new employeeCollection();
        direktorler.addEmployee(d1);
        direktorler.addEmployee(d2);

        assertTrue(direktorler.createIterator().hasNext()); //İKİ ELEMANLI LİSTEDE ITERATOR İLERLEYEBİLİRSE TEST BAŞARILI
    }

    @org.junit.jupiter.api.Test
    void findElement() {

        assertFalse(d2.getName()=="Cenk Erdur"); //D2'YE TANIMLANMIŞ DİREKTÖR CENK ERDUR DEĞİLSE TEST BAŞARILI
    }
}