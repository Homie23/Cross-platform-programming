import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static Scanner scn;

    public static void main(String[] args) {
        scn = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Cпосіб заповнення" +
                "\n1. Введення з клавіатури. " +
                "\n2. Рандом.");
        int chose = scn.nextInt();
        scn.nextLine();
        switch (chose) {
            case 1:
                int[] array = arrayCreate(chose);
                System.out.println(findMaximum(array));
                break;
            case 2:
                int[] array_ = arrayCreate(chose);
                System.out.println("Масив: " + Arrays.toString(array_));
                System.out.println(findMaximum(array_));
                break;
        }
    }

    private static void inputElements(int[] array) {
        System.out.println("Елементи масиву:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scn.nextInt(); //ввод элементов массива
        }
    }

    private static void inputRandElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    private static int findMaximum(int[] array) {
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
        return max;
    }

    private static int[] arrayCreate(int choose) {
        System.out.println("Розмір масиву: ");
        int size;
        try {
            size = scn.nextInt(); //ввод размера массива
            scn.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            throw new InputMismatchException("\n" + "Введення лише чисел");
        }
        int[] array = new int[size];
        try {
            switch (choose) {
                case 1:
                    inputElements(array);
                    break;
                case 2:
                    inputRandElements(array);
                    break;
            }
        } catch (InputMismatchException inputMismatchException) {
            throw new InputMismatchException("Введення лише чисел");
        }
        return array;
    }
}