import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class MainWithoutMethods {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Розмір масиву");
        int size = 0;
        try {
            size = Integer.parseInt(scn.nextLine()); //ввод размера массива
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Введення лише чисел");
        }
        int[] array = new int[size];

        try {
            System.out.println("Елементи масиву:");
            for (int i = 0; i < size; i++) {
                array[i] = scn.nextInt(); //ввод элементов массива
            }
        } catch (InputMismatchException inputMismatchException) {
            throw new InputMismatchException("Введення лише чисел");
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0 && max < array[i]) { //поиск максимального числа кратного 3м
                max = array[i];
                idx = i;
            }

        }
        if (max == 0) {
            throw new IllegalArgumentException("Максимального числа кратного 3-м не знайдено");
        }
        System.out.println("Максимальне: " + max + " №: " + idx);


    }
}
