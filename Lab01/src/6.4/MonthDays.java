import java.util.Scanner;

public class MonthDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tháng2");
            String input = sc.next();
            System.out.print("Nhập năm: ");
            int year = sc.nextInt();
            int month = 0;
            // So sánh chuỗi giống strcmp trong C
            if (input.equals("January") || input.equals("Jan.") || input.equals("Jan") || input.equals("1")) {
                month = 1;
            } else if (input.equals("February") || input.equals("Feb.") || input.equals("Feb") || input.equals("2")) {
                month = 2;
            } else if (input.equals("March") || input.equals("Mar.") || input.equals("Mar") || input.equals("3")) {
                month = 3;
            } else if (input.equals("April") || input.equals("Apr.") || input.equals("Apr") || input.equals("4")) {
                month = 4;
            } else if (input.equals("May") || input.equals("5")) {
                month = 5;
            } else if (input.equals("June") || input.equals("Jun") || input.equals("6")) {
                month = 6;
            } else if (input.equals("July") || input.equals("Jul") || input.equals("7")) {
                month = 7;
            } else if (input.equals("August") || input.equals("Aug.") || input.equals("Aug") || input.equals("8")) {
                month = 8;
            } else if (input.equals("September") || input.equals("Sept.") || input.equals("Sep") || input.equals("9")) {
                month = 9;
            } else if (input.equals("October") || input.equals("Oct.") || input.equals("Oct") || input.equals("10")) {
                month = 10;
            } else if (input.equals("November") || input.equals("Nov.") || input.equals("Nov") || input.equals("11")) {
                month = 11;
            } else if (input.equals("December") || input.equals("Dec.") || input.equals("Dec") || input.equals("12")) {
                month = 12;
            }
            if (month == 0 || year < 0) {
                System.out.println("Tháng hoặc năm không hợp lệ. Vui lòng nhập lại!");
                continue;
            }

            int days = 0;
            if (month == 2) {

                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;
            } else {
                days = 31;
            }

            System.out.println("Tháng " + input + " năm " + year + " có " + days + " ngày.");
            break;
        }
    }
}