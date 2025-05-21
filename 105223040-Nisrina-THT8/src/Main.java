import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> pengguna = new ArrayList<>();
    static Random random = new Random();
    static String[] daftarItem = {"Pedang", "Perisai", "Panah"};
    static String[] daftarMusuh = {"Goblin", "Orc", "Naga"};

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                daftar();
            } else if (pilihan.equals("2")) {
                if (masuk()) {
                    menuPermainan(new Player());
                }
            } else if (pilihan.equals("3")) {
                System.out.println("Keluar dari permainan");
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
        }
    }

    static void daftar() {
        System.out.print("Nama pengguna: ");
        String uname = scanner.nextLine();
        System.out.print("Kata sandi: ");
        String pass = scanner.nextLine();
        pengguna.add(new User(uname, pass));
        System.out.println("Pendaftaran berhasil!");
    }

    static boolean masuk() {
        System.out.print("Nama pengguna: ");
        String uname = scanner.nextLine();
        System.out.print("Kata sandi: ");
        String pass = scanner.nextLine();

        for (User u : pengguna) {
            if (u.login(uname, pass)) {
                System.out.println("Berhasil masuk!");
                return true;
            }
        }
        System.out.println("Gagal masuk!");
        return false;
    }

    static void menuPermainan(Player pemain) {
        while (true) {
            System.out.println("\n1. Buka Ransel");
            System.out.println("2. Mulai petualangan");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            String ch = scanner.nextLine();

            if (ch.equals("1")) {
                pemain.tampilkanRansel();
                System.out.print("Kembali ke permainan? (ya/tidak): ");
                if (!scanner.nextLine().equalsIgnoreCase("ya")) break;
            } else if (ch.equals("2")) {
                mulaiPetualangan(pemain);
            } else if (ch.equals("3")) {
                System.out.println("Terima kasih telah bermain!");
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
        }
    }

    static void mulaiPetualangan(Player pemain) {
        while (true) {
            System.out.println("\nNyawa: " + pemain.getNyawa());
            System.out.println("Level: " + pemain.getLevel());
            System.out.println("1. Maju");
            System.out.println("2. Belok kanan");
            System.out.println("3. Belok kiri");
            System.out.println("4. Mundur");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("5")) {
                System.out.println("Keluar dari petualangan");
                break;
            } else {
                picuEvent(pemain);
            }
        }
    }

    static void picuEvent(Player pemain) {
        int event = random.nextInt(3);
        if (event == 0) {
            Item item = new Item(daftarItem[random.nextInt(daftarItem.length)]);
            item.temui(pemain);
        } else if (event == 1) {
            int kekuatan = random.nextInt(40) + 10;
            Enemy musuh = new Enemy(daftarMusuh[random.nextInt(daftarMusuh.length)], kekuatan);
            musuh.temui(pemain);
        } else {
            System.out.println("Tidak terjadi apa-apa");
        }
    }
}