import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTxt implements Strategy {
    @Override
    public Employee readOperation() throws FileNotFoundException {
        ArrayList<Director> directorArrayList = new ArrayList<>();//DİREKTÖRLERİ TUTAR
        ArrayList<Officer> officerArrayList = new ArrayList<>();//MEMURLARI TUTAR
        //HİYERARŞİK DÜZENDE DİZİ OLUŞTURURKEN KODUN VERİMLİLİĞİNİ ARTIRMAK İÇİN ARRAYLİST'İN ÖZELLİKLERİNDEN FAYDALANDIK
        ArrayList<Employee> employeeArrayList = new ArrayList<>();//TÜM ÇALIŞANLARI TUTAR
        try {
            File f = new File("girdiler.txt"); // DOSYA AÇILIR.
            Scanner dosya = new Scanner(f);

            while (dosya.hasNextLine()) {//SATIRLAR
                String line = dosya.nextLine();
                String[] words = line.split(",");//KELİMELER
                if (words[0].equals("D")) {
                    //EMPTYPE "D" İSE DİREKTÖR NESNESİ OLUŞTURULUR
                    Director director = new Director(words[0], words[1], Integer.parseInt(words[2]), words[3]);
                    directorArrayList.add(director);
                    employeeArrayList.add(director);

                } else {
                    //EMPTYPE "M" İSE MEMUR NESNESİ OLUŞTURULUR
                    Officer officer = new Officer(words[0], words[1], Integer.parseInt(words[2]), words[3]);
                    officerArrayList.add(officer);
                    employeeArrayList.add(officer);
                }


            }
            //MEMURUN DİREKTÖRÜNÜ BULMAYA YARAR,ÖZELDEN GENELE BİR ARAMA MEVCUT
            for (Officer officer : officerArrayList) {
                for (Director director : directorArrayList) {
                    String[] directorName = director.getName().split(" ");
                    if (officer.getDependentEmp().equals(directorName[0])) {
                        director.addEmployee(officer);
                        break;
                    }
                }
            }
            //DİREKTÖRÜN DİREKTÖRÜNÜ BULMAYA YARAR
            for (Director director1 : directorArrayList) {
                for (Director director2 : directorArrayList) {
                    String[] directorName = director2.getName().split(" ");
                    if (director1.getDependentEmp().equals(directorName[0])) {
                        director2.addEmployee(director1);
                        break;
                    }
                }
            }


        } catch (FileNotFoundException e) {//DOSYA BULUNAMAZSA HATA BİLDİRİR
            System.out.println("FILE CAN NOT BE FOUND!");
            System.exit(0);
        }return employeeArrayList.get(0);//ROOT'U DÖNDÜRÜR

    }

}
