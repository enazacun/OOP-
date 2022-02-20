import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerTest {
    Officer m1 = new Officer("M","Oylum Alatli",2000,"Ozgun");

    @Test
    void cost() {
        assertEquals(2000,m1.cost()); //MEMURUN MALİYETİ BEKLENEN MALİYETLE AYNIYSA TEST BAŞARILI
    }
}