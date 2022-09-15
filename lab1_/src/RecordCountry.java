import java.util.Scanner;

class Strana{
    String name;
    double square;
}

public class RecordCountry {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Введіть кількість країн => ");
        int n = sc.nextInt();
        Strana country[] = new Strana[n];
        System.out.println("Введіть інформацію про країни: ");
        for (int i = 0; i < country.length; i++) {
            sc.nextLine();
            country[i] = new Strana();
            System.out.print("Назва " + (i + 1) + "-ї країни => ");
            country[i].name = sc.nextLine();
            System.out.print("Площа " + (i + 1) + "-ї країни => ");
            country[i].square = sc.nextDouble();
        }
        System.out.println("Характеристики країн: ");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + "млн. кв. км");
        }
        int nommax = 0;
        double max = country[nommax].square;
        for (int i = 0; i < country.length; i++)
            if (country[i].square > max) {
                max = country[i].square;
                nommax = i;
            }
        System.out.println("\nКраїна з максимальною площею: ");
        System.out.println("" + country[nommax].name + "\t" + country[nommax].square + "млн кв. км");

        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - 1 - i; j++) {
                if (country[j].square > country[j + 1].square) {
                    Strana rab = country[j];
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }
        }
        System.out.println("\nВідсортований список за площею:");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + "млн. кв. км");
        }

        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - i - 1; j++) {
                if (country[j].name.compareTo(country[i + 1].name) > 0) {
                    Strana rab = country[j];
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }

        }
        System.out.println("\nВідсортований список за назвою:");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + "млн. кв. км");
        }

        double s=0;
        for (int i = 0; i < country.length; i++){
            s+=country[i].square;
        }
        double sr=s/country.length; ;
        System.out.println("Середня площа ="+sr); System.out.println("\nКраїни, з площею більше середньої");
        for (int i = 0; i < country.length; i++) {
            if (country[i].square>sr){
                System.out.println(country[i].name +"\t"+country[i].square + " млн кв. км");
            }
        }

        sc.nextLine();
        System.out.println("Введіть назву шуканої країни=>");
        String name = sc.nextLine();
        int nom=-1;
        for (int i = 0; i < country.length; i++){
            if (name.equalsIgnoreCase(country[i].name)) nom=i;
        }
        if(nom!=-1){
            System.out.println("Така країна є у списку. Це " +country[nom].name+" "+country[nom].square+" млн кв. км");
        }
        else System.out.println("Такої країни немає у списку");

    }
}
