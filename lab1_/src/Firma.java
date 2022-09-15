
import java.util.Scanner;
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}
public class Firma {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in,"cp1251");
        System.out.println("Введіть кількість співробітників => ");
        int kol = sc.nextInt();
        sc.nextLine();

        Sotrudnik2[]sotr = new Sotrudnik2[kol];

        System.out.println("Введіть інформацію про кожного співробітника:");
        for (int i=0; i < sotr.length; i++){
            sotr[i] = new Sotrudnik2();

            System.out.print("Введіть прізвище "+(i+1)+" співробітника => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введіть його ім'я => ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введіть його по батькові => ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введіть його посаду => ");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введіть кількість дітей => ");
            sotr[i].kolDet=sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\nСпівробітники фірми:\n фам\tім'я\tотч\t посада \tОклад");
        for(Sotrudnik2 s: sotr){
            System.out.print(s.fam + "\t"+s.im + "\t"+s.otch + "\t"+s.doljnost + "\t\t" + s.kolDet + "\n");
        }
    }
}
