    import javax.swing.JOptionPane;
    public class GiaiPT {
        public static void main(String[] args){
            String menu = "Chọn loại phương trình:\n" +
                    "1. Phương trình bậc nhất (1 ẩn)\n ax+b=0\n" +
                    "2. Hệ phương trình bậc nhất (2 ẩn):\n a11 x1 + a12 x2 = b1 \n a21 x1 + a22 x2 = b2 \n" +
                    "3. Phương trình bậc hai (1 ẩn):\n a x^2 + b x + c = 0 \n" +
                    "0. Thoát";
            while(true){
                String a=JOptionPane.showInputDialog(null, menu, "Menu",JOptionPane.QUESTION_MESSAGE);
                if(a==null || a.equals("0")) break;
                switch (a){
                    case "1":
                        void1();
                        break;
                    case "2":
                        void2();
                        break;
                    case "3":
                        void3();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Lỗi");
                }
            }
        }
        private static void void1() {
            double a = Double.parseDouble(JOptionPane.showInputDialog("nhap a"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("nhap b"));
            if (a == 0) {
                if (b == 0) JOptionPane.showMessageDialog(null, "phuong trinh vo so nghiem");
                else JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
            } else {
                JOptionPane.showMessageDialog(null, "nghiem x=" + (-b / a));
            }
        }
            private static void void2(){
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("nhap a11"));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("nhap a12"));
                double b1  = Double.parseDouble(JOptionPane.showInputDialog("nhap b1        "));

                double a21 = Double.parseDouble(JOptionPane.showInputDialog("nhap a21"));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("nhap a22"));
                double b2  = Double.parseDouble(JOptionPane.showInputDialog("nhap b2"));

                double D  = a11 * a22 - a21 * a12;
                double Dx = b1 * a22 - b2 * a12;
                double Dy = a11 * b2 - a21 * b1;

                if (D != 0) {
                    double x = Dx / D;
                    double y = Dy / D;
                    JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất:\nx = " + x + "\ny = " + y);
                } else {
                    if (Dx == 0 && Dy == 0) {
                        JOptionPane.showMessageDialog(null, "Hệ phương trình có vô số nghiệm.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hệ phương trình vô nghiệm.");
                    }
                }
            }
        private static void void3(){
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) JOptionPane.showMessageDialog(null, "Vô số nghiệm");
                    else JOptionPane.showMessageDialog(null, "Vô nghiệm");
                } else {
                    JOptionPane.showMessageDialog(null, "Nghiệm bậc nhất x = " + (-c / b));
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
                } else if (delta == 0) {
                    JOptionPane.showMessageDialog(null, "Nghiệm kép x = " + (-b / (2 * a)));
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
    }

