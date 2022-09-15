import java.util.Scanner;
class Strana2{
    String name; double square;
}
public class RecordCountry2 {
    public static Strana[] setCountryArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Strana country[] = new Strana[k];
        System.out.println("Введіть інформацію про країни: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("Назва " + (i + 1) + "-ї країни => ");
            country[i].name = sc.nextLine();
            System.out.print("Площа " + (i + 1) + "-ї країни => ");
            country[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }
    public static void showArray (Strana[]cntr){
        for (int i = 0; i < cntr.length; i++) {
            System.out.println(cntr[i].name + "\t" + cntr[i].square + " млн. кв. км");
        }
    }
    public static void showCountry(Strana cntr){
        System.out.println(""+cntr.name+"\t"+cntr.square+" млн. кв. км");
    }
    public static int NomMax (Strana []st) {
        int nommax=0;
        double max=st[nommax].square;
        for (int i = 0; i <st.length; i++){
            if (st[i].square>max) {
                max = st [i]. square;
                nommax=i;
            }
        }
        return nommax;
    }
    public static void sortSquare (Strana [] cntr) {
        for (int i = 0; i < cntr.length-1; i++){
            for (int j = 0; j <cntr.length-1-i; j++){
                if (cntr[j].square>cntr[j+1].square){
                    Strana rab=cntr[j];
                    cntr[j]=cntr[j+1];
                    cntr[j+1] =rab;
                }
            }
        }
    }
    public static void sortName (Strana [] cntr) {
        for (int i = 0; i < cntr.length-1; i++){
            for (int j = 0; j <cntr.length-i-1; j++)
                if(cntr[j].name.compareTo(cntr[i+1].name)>0){
                Strana rab=cntr[j];
                cntr[j]=cntr[j+1];
                cntr[j+1]=rab;
            }
        }
    }
    public static double avgSquare(Strana [] cntr) {
        double s=0;
        for (int i = 0; i < cntr.length; i++){
            s+=cntr[i].square;
        }
        double sr=s/cntr.length;
        return sr;
    }
    public static Strana [] Bigger(Strana cntr[]){
        double sred=avgSquare(cntr);
        int kol=0;
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square>sred){
                ++kol;
            }
        }
        if (kol!= 0) {
            Strana [] bigCountry = new Strana [kol];
            int n=-1;
            for (int i = 0; i <cntr.length; i++){
                if (cntr[i].square>sred) {
                    bigCountry[++n]=cntr[i];
                }
            }
            return bigCountry;
        } else return null;
    }
    public static Strana findForName(Strana cntr [], String name) {
        int n=-1;
        for (int i = 0; i < cntr.length; i++){
            if (name.equals(cntr[i].name)){
                n=i;
            }
        }
        if (n!= -1) {
            return cntr[n];
        } else return null;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість країн => ");
        int n = sc.nextInt();
        Strana country[] = setCountryArr(n);

        System.out.println("\nХарактеристики країн:");
        showArray(country);

        int nommax = NomMax(country);
        System.out.println("\nКраїна з максимальною площею:");
        showCountry(country[nommax]);

        sortSquare(country);
        System.out.println("\nВідсортований список за площею:");
        showArray(country);

        sortName(country);
        System.out.println("\nВідсортований список за назвою:");
        showArray(country);

        System.out.println("Середня площа =" + avgSquare(country));

        System.out.println("\nКраїни, з площею більше середньої");
        Strana[] larger = Bigger(country);
        showArray(larger);

        System.out.println("\nПошук країни \n Введіть назву країни => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(country, sname);
        if (sfind != null){
            showCountry(sfind);
        } else{
            System.out.println("Такої країни немає у списку!");
        }
    }
}


