public class StoreTest {
    public static void main(String[] args) {
        Store cuaHang = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");

        cuaHang.addDVD(dvd1);
        cuaHang.removeDVD(dvd1);
    }
}