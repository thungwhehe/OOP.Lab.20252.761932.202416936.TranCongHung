package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo sẵn một vài dữ liệu mẫu trong Store để thầy cô test cho tiện
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new Book(2, "Java Programming", "Education", 25.00f));

        CompactDisc cd = new CompactDisc(3, "Starboy", "Pop", 15.50f, "The Weeknd", 0, "The Weeknd");
        cd.addTrack(new Track("Starboy", 4));
        cd.addTrack(new Track("False Alarm", 3));
        store.addMedia(cd);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Chống trôi lệnh khi đọc chuỗi phía sau

            switch (choice) {
                case 1:
                    storeMenuHandler();
                    break;
                case 2:
                    updateStoreHandler();
                    break;
                case 3:
                    cartMenuHandler();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống AIMS. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        } while (choice != 0);
    }

    // --- CÁC GIAO DIỆN MENU ĐỀ BÀI YÊU CẦU ---

    public static void showMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3 -> ");
    }

    public static void storeMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4 -> ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2 -> ");
    }

    public static void cartMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5 -> ");
    }

    // --- CÁC HÀM XỬ LÝ LOGIC ĐIỀU KHIỂN ---

    private static void storeMenuHandler() {
        int choice;
        do {
            System.out.println("\n--- ITEMS IN STORE ---");
            store.printStore(); // Hiển thị danh sách cửa hàng
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Xem chi tiết Media
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media foundMedia = store.searchByTitle(title);
                    if (foundMedia != null) {
                        System.out.println("\n[MEDIA DETAILS]\n" + foundMedia.toString());
                        mediaDetailsMenuHandler(foundMedia); // Mở tiếp Menu con (Add/Play)
                    } else {
                        System.out.println("Invalid title! Media not found.");
                    }
                    break;

                case 2: // Thêm thẳng sản phẩm vào giỏ
                    System.out.print("Enter the title of the media to add: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaToAdd = store.searchByTitle(titleAdd);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                        System.out.println("Current number of items in cart: " + cart.getQuantity());
                    } else {
                        System.out.println("Invalid title! Media not found.");
                    }
                    break;

                case 3: // Chạy thử nhạc/video
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaToPlay = store.searchByTitle(titlePlay);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("This media type cannot be played!");
                        }
                    } else {
                        System.out.println("Invalid title! Media not found.");
                    }
                    break;

                case 4: // Xem giỏ hàng luôn
                    cartMenuHandler();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void mediaDetailsMenuHandler(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add to cart từ menu chi tiết
                    cart.addMedia(media);
                    System.out.println("Current number of items in cart: " + cart.getQuantity());
                    break;
                case 2: // Play từ menu chi tiết
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media type (Book) does not support Play feature!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0 && choice != 1); // Thoát nếu chọn Back hoặc sau khi Add thành công
    }

    private static void updateStoreHandler() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.print("Your choice: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        if (subChoice == 1) {
            System.out.print("Enter media type (1: DVD, 2: CD, 3: Book): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Title: "); String title = scanner.nextLine();
            System.out.print("Enter Category: "); String category = scanner.nextLine();
            System.out.print("Enter Cost: "); float cost = scanner.nextFloat();
            scanner.nextLine();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title, category, cost));
            } else if (type == 2) {
                System.out.print("Enter Artist: "); String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(title, category, "", cost, artist));
            } else if (type == 3) {
                store.addMedia(new Book(100, title, category, cost));
            }
        } else if (subChoice == 2) {
            System.out.print("Enter the title of the media to remove from Store: ");
            String titleRemove = scanner.nextLine();
            Media m = store.searchByTitle(titleRemove);
            if (m != null) {
                store.removeMedia(m);
            } else {
                System.out.println("Media not found!");
            }
        }
    }

    private static void cartMenuHandler() {
        int choice;
        do {
            System.out.println("\n--- YOUR CURRENT CART ---");
            cart.print(); // Gọi hàm in giỏ hàng
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Lọc sản phẩm trong giỏ
                    System.out.println("1. Filter by ID");
                    System.out.println("2. Filter by Title");
                    System.out.print("Choose option: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: "); int id = scanner.nextInt();
                        cart.searchById(id);
                    } else {
                        System.out.print("Enter Title keyword: "); String keyword = scanner.nextLine();
                        cart.searchByTitle(keyword);
                    }
                    break;

                case 2: // Sắp xếp sản phẩm (Tích hợp Phần 12 của bạn)
                    System.out.println("1. Sort by Title -> Cost");
                    System.out.println("2. Sort by Cost -> Title");
                    System.out.print("Choose option: ");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else {
                        cart.sortByCost();
                    }
                    break;

                case 3: // Xóa khỏi giỏ hàng
                    System.out.print("Enter the title of the media to remove from Cart: ");
                    String titleRemove = scanner.nextLine();
                    Media mRemove = cart.searchByTitleReturnMedia(titleRemove);
                    if (mRemove != null) {
                        cart.removeMedia(mRemove);
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;

                case 4: // Phát nhạc sản phẩm trong giỏ
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mPlay = cart.searchByTitleReturnMedia(titlePlay);
                    if (mPlay != null && mPlay instanceof Playable) {
                        ((Playable) mPlay).play();
                    } else {
                        System.out.println("This media cannot be played or is not in cart!");
                    }
                    break;

                case 5: // Đặt hàng (Place order)
                    System.out.println("An order has been successfully created! Thank you.");
                    cart = new Cart(); // Làm trống giỏ hàng theo đúng luật đề bài
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }
}