import java.util.Scanner;
class Lake{
    String title, location;
    double square;
}
public class RecLake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введіть кількіть озер: ");
        int n = sc.nextInt();
        Lake lakes[] = new Lake[n];
        System.out.println("Введіть інформацію про озера");
        for(int i = 0; i < lakes.length; i++){
            sc.nextLine();
            lakes[i] = new Lake();
            System.out.print("Назва "+(i+1)+"-го озера: ");
            lakes[i].title = sc.nextLine();
            System.out.print("Місце розташування "+(i+1)+"-го озера: ");
            lakes[i].location = sc.nextLine();
            System.out.print("Площа "+(i+1)+"-го озера: ");
            lakes[i].square = sc.nextDouble();
        }

        int idx = 0;
        double max = lakes[idx].square;
        for (int i = 0; i < lakes.length; i++){
            if(lakes[i].square > max){
                max = lakes[i].square;
                idx = i;
            }
        }
        System.out.println("\nНайбільше озеро: ");
        System.out.println(""+lakes[idx].title+"\t"+lakes[idx].square + "кв. км");

        double s = 0;
        int avgs = 0;
        for (int i = 0; i < lakes.length; i++){
            s+=lakes[i].square;
        }
        double sr = s/ lakes.length;
        for (int i = 0; i < lakes.length; i++){
            if(lakes[i].square < sr){
                avgs++;
            }
        }
        System.out.println("\nКількість озер із площею меншою за середню: " + avgs);

        for (int i = 0; i < lakes.length-1; i++){
            for (int j = 0; j < lakes.length-i-1; j++){
                if(lakes [j].title.compareTo(lakes[i+1].title)>0){
                    Lake rab=lakes[j];
                    lakes[j] = lakes[j + 1];
                    lakes[j + 1] = rab;
                }
            }
        }
        System.out.println("\nВідсортований список за назвами:");
        for (int i = 0; i < lakes.length; i++) {
            System.out.println(""+lakes[i].title);
        }

        sc.nextLine();
        System.out.println("Введіть назву озера для пошуку");
        String name=sc.nextLine();
        int nom = -1;
        for (int i = 0; i < lakes.length; i++){
            if (name.equalsIgnoreCase(lakes[i].title)) nom=i;
        }
        if (nom != -1) {
            System.out.println("Найшли, це озеро" +lakes[nom].title+" "+lakes[nom].square+" кв. км");
        }
        else System.out.println("Такого озера немає.");
        if(nom != -1){
            System.out.println("Відредагувати? (1-Так/2-Ні)");
            int ans = sc.nextInt();
            if(ans == 1){
                System.out.println("Оберіть поле для редагування" +
                        "\n1. Назва" +
                        "\n2. Місце розташування" +
                        "\n3. Площа");
                int ed=sc.nextInt();
                if(ed == 1){
                    System.out.println("Введіть нову назву: ");
                    String newname=sc.next();
                    lakes[nom].title = newname;
                }
                if(ed == 2){
                    System.out.println("Введіть нове місце розташування: ");
                    String newloc=sc.nextLine();
                    lakes[nom].location = newloc;
                }
                if(ed == 3){
                    System.out.println("Введіть нову площу: ");
                    double newsqr=sc.nextDouble();
                    lakes[nom].square = newsqr;
                }
                System.out.println("Озеро:" +lakes[nom].title+" Місце розташування: " +lakes[nom].location + " Площа: " +lakes[nom].square+" кв. км");
            }
        }



    }
}
