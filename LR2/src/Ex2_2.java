public class Ex2_2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            System.out.println("1");
            throw new RuntimeException("Неперевірена помилка");
        } catch (Exception e) {
            System.out.println("2" + e);
        }
        System.out.println("3");

    }
}
