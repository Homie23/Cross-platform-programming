import java.util.Scanner;
class Lake_{
    String title, location;
    double square;
}
public class RecLake2 {
    public static Lake_ [] setLakeArr(int k){
        Scanner sc= new Scanner(System.in,"cp1251");
        Lake_ lakes[] = new Lake_[k];
        System.out.println("Введіть інформацію про озера:");
        for (int i = 0; i<lakes.length; i++){
            lakes[i] = new Lake_();
            System.out.print("Назва "+(i+1)+"-го озера:");
            lakes[i].title = sc.nextLine();
            System.out.print("Місце розташування "+(i+1)+"-го озера:");
            lakes[i].location = sc.nextLine();
            System.out.print("Площа "+(i+1)+"-го озера:");
            lakes[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return lakes;
    }
    public static void showLakes(Lake_ lks[]){
        for (int i =0; i < lks.length; i++){
            System.out.println("Озеро:" +lks[i].title+" Місце розташування: " +lks[i].location + " Площа: " +lks[i].square+" кв. км");
        }
    }
    public static void showLake(Lake_ lks){
        System.out.println("Озеро:" +lks.title+" Місце розташування: " +lks.location + " Площа: " +lks.square+" кв. км");

    }
    public static int largestLake(Lake_ [] lks){
        int idx = 0;
        double max = lks[idx].square;
        for (int i = 0; i < lks.length; i++){
            if(lks[i].square > max){
                max = lks[i].square;
                idx = i;
            }
        }
        return idx;
    }
    public static int lessThanAVG(Lake_ lks[]){
        double s = 0;
        int avgs = 0;
        for (int i = 0; i < lks.length; i++){
            s+=lks[i].square;
        }
        double sr = s/ lks.length;
        for (int i = 0; i < lks.length; i++){
            if(lks[i].square < sr){
                avgs++;
            }
        }
        return avgs;
    }
    public static void sortByName(Lake_ [] lks){
        for (int i = 0; i < lks.length-1; i++){
            for (int j = 0; j < lks.length-i-1; j++){
                if(lks [j].title.compareTo(lks[i+1].title)>0){
                    Lake_ rab=lks[j];
                    lks[j] = lks[j + 1];
                    lks[j + 1] = rab;
                }
            }
        }
    }
    public static  Lake_ findByName(Lake_ lks[], String title){
        int n = -1;
        for (int i = 0; i < lks.length; i++){
            if(title.equals(lks[i].title)){
                n=i;
            }
        }
        if(n != -1) return lks[n];
        else return null;
    }
    public static void editFieldByTitle(Lake_ lks[], String title, String newValue){
        Lake_ x = findByName(lks,title);
        if (x == null) System.out.println("Нема :(");
        else x.title = newValue;
    }
    public static void editFieldByLocation(Lake_ lks[], String title, String newValue){
        Lake_ x = findByName(lks,title);
        if (x == null) System.out.println("Нема :(");
        else x.location = newValue;
    }
    public static void editFieldBySquare(Lake_ lks[], String title, double newSquare){
        Lake_ x = findByName(lks,title);
        if (x == null) System.out.println("Нема :(");
        else x.square = newSquare;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in,"cp1251");
        System.out.println("Введіть кількіть озер: ");
        int n = sc.nextInt();
        Lake_ lakes[] = setLakeArr(n);

        int lrg = largestLake(lakes);
        System.out.println("\nНайбільше озеро: ");
        showLake(lakes[lrg]);

        System.out.println("\nКількість озер із площею меншою за середню: ");
        System.out.println(lessThanAVG(lakes));

        sortByName(lakes);
        System.out.println("\nВідсортований список за назвою:");
        showLakes(lakes);

        sc.nextLine();
        System.out.println("\nВведіть назву озера для пошуку");
        String title = sc.nextLine();
        Lake_ find = findByName(lakes, title);
        if(find!= null){
            showLake(find);
        } else{
            System.out.println("Нема :(");
        }

        System.out.println("\nВведіть назву озера для редагування");
        String title_ = sc.nextLine();
        System.out.println("Оберіть поле для редагування" +
                "\n1. Назва" +
                "\n2. Місце розташування" +
                "\n3. Площа");
        int chose = sc.nextInt();
        switch (chose){
            case 1:
                sc.nextLine();
                System.out.println("Введіть нову назву: ");
                String newVal = sc.nextLine();
                editFieldByTitle(lakes,title_, newVal);
                break;
            case 2:
                System.out.println("Введіть нове місце розташування: ");
                String newVal_ = sc.nextLine();
                editFieldByLocation(lakes, title_, newVal_);
                break;
            case 3:
                System.out.println("Введіть нову площу: ");
                double newSqr = sc.nextDouble();
                editFieldBySquare(lakes,title_,newSqr);
                break;
            default:
                break;
        }
        showLakes(lakes);





    }
}
