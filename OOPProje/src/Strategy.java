import java.io.FileNotFoundException;

public interface Strategy {//INTERFACE,READ OPERASYONU YAPILACAĞI BELİRTİLDİ
    Employee readOperation() throws FileNotFoundException;

}
