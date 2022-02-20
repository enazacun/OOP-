import java.io.FileNotFoundException;

public class Context {
    private Strategy strategy;
    //CONSTRUCTOR
    public Context(Strategy strategy)//BELİRLENEN STRATEJİYE GÖRE İŞLEM YAPILACAK
    {
        this.strategy=strategy;
    }
    //READ OPERASYONUNUN ÇAĞRIMI
    public Employee executeStrategy() throws FileNotFoundException {
        return strategy.readOperation();
    }
}
