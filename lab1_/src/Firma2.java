import java.util.Scanner;
class Sotrudnik2 {
    String fam, im, otch, doljnost;
    int kolDet;
    Rebenok []reb = null;
}
class Rebenok{
    String imaR;
    int vozrastR;
}
public class Firma2 {
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
            sotr[i].kolDet = sc.nextInt();
            sc.nextLine();

            if(sotr[i].kolDet!= 0 ) {
                sotr[i].reb = new Rebenok[sotr[i].kolDet];
                System.out.println("Діти => ");
                for (int j = 0; j < sotr[i].reb.length; j++) {
                    sotr[i].reb[j] = new Rebenok();

                    System.out.print("Введіть ім'я " + (i + 1) + " дитини => ");
                    sotr[i].reb[j].imaR = sc.nextLine();

                    System.out.print("Введіть його вік => ");
                    sotr[i].reb[j].vozrastR = sc.nextInt();
                    sc.nextLine();
                }
            }
        }
        System.out.println("\nСпівробітники фірми \n фам \t ім'я \t отч \t посада");
        for(Sotrudnik2 s: sotr) {
            System.out.print(s.fam+ "\t"+s.im + "\t"+ s.otch+ "\t "+ s.doljnost); System.out.println("\nДіти: ");
            for(Rebenok r: s.reb)
                System.out.println("\t\t"+ r.imaR+ "\t\t"+ r.vozrastR);
            System.out.println("");
        }
    }

}

