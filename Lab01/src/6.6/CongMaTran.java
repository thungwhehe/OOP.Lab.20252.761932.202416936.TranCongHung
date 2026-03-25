import java.util.Scanner;
public class CongMaTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so hang");
        int n = sc.nextInt();
        System.out.print("Nhap so cot");
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int[][] c = new int[n][m];

        System.out.println("Nhap ma tran A:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Nhap ma tran B:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("Ma trận tổng C:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}