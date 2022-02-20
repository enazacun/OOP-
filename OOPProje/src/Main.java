import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main (String []args) throws FileNotFoundException {
        Context context=new Context(new ReadTxt());//STRATEJİYİ ÇAĞIRMAK İÇİN NESNE OLUŞTURULDU
        Employee root =context.executeStrategy();//ROOT BELİRLENDİ
        String isThere="Y";//BAŞKA INPUT VAR MI
            while (isThere.equals("Y")) {
                String nameSurname=elemanInput();
                Employee c = root.findElement(nameSurname);//INPUTLA GİRİLEN ELEMANI ARAR
                while(c==null){
                    System.out.println("THIS EMPLOYEE DOES NOT EXIST IN THE DATABASE! TRY AGAIN");
                    nameSurname=elemanInput();
                    c = root.findElement(nameSurname);
                }
                c.makeList();
                System.out.println(c.getName()+" cost:"+ c.cost());
                Scanner scanner1=new Scanner(System.in);
                System.out.println("Is there any other employee you would like to search for ?(Y/N):");
                isThere =scanner1.nextLine();
                while(!(isThere.equals("Y") || isThere.equals("N"))){
                    //YANLIŞ INPUT GİRİŞİ KONTROLÜ
                    System.out.println("WRONG INPUT! TRY AGAIN");
                    System.out.println("Is there any other employee you would like to search for ?(Y/N):");
                    isThere =scanner1.nextLine();
                }
            }
        }
        public static String elemanInput() {//ELEMAN ADINI INPUT OLARAK ALAN METOT
        //INPUT ALMA TEKRARINI ÖNLER
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name surname:");
            String nameSurname = scanner.nextLine();
            return nameSurname;
        }


}

