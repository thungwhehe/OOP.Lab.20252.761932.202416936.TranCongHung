import java.util.Arrays;
import java.util.Scanner;
public class sortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. Nhập số lượng phần tử
        System.out.print("Nhập số phần tử n = ");
        int n = sc.nextInt();
        int[] my_array = new int[n];
        // 2. Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử [" + (i+1) + "]: ");
            my_array[i] = sc.nextInt();
        }

        Arrays.sort(my_array);

        // 4. Tính Tổng và Trung bình
        int sum = 0;
        for (int x : my_array) {
            sum += x;
        }
        double avg = (double) sum / n;

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(my_array));
        System.out.println("Tổng: " + sum);
        System.out.println("Trung bình cộng: " + avg);
    }
}