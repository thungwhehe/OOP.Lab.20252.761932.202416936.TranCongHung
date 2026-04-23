import javax.swing.JOptionPane;
public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String tmp1 = JOptionPane.showInputDialog(null,
                "Nhap so dau tien: ", "Input",
                JOptionPane.INFORMATION_MESSAGE);

        String tmp2 = JOptionPane.showInputDialog(null,
                "Nhap so thu hai: ", "Input",
                JOptionPane.INFORMATION_MESSAGE);
        double so1 = Double.parseDouble(tmp1);
        double so2 = Double.parseDouble(tmp2);
        double sum = so1 + so2;
        double difference = so1 - so2;
        double product = so1 * so2;
        String result = "Results for " + so1 + " and " + so2 + ":\n" +
                "Sum: " + sum + "\n" +
                "Difference: " + difference + "\n" +
                "Product: " + product + "\n";
        if (so2 != 0) {
            double quotient = so1 / so2;
            result += "Quotient: " + quotient;
        } else {
            result += "Quotient: Khong the chia cho 0!";
        }
        JOptionPane.showMessageDialog(null, result,
                "Calculation", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}