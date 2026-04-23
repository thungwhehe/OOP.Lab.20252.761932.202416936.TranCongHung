package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store cuaHang = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");

        cuaHang.addDVD(dvd1);
        cuaHang.removeDVD(dvd1);
    }
}