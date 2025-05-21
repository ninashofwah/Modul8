import java.util.*;

abstract class Entity {
    String nama;

    public Entity(String nama) {
        this.nama = nama;
    }

    public abstract void temui(Player pemain);
}

class Item extends Entity {
    public Item(String nama) {
        super(nama);
    }

    public void temui(Player pemain) {
        System.out.println("Kamu menemukan item: " + nama);
        pemain.tambahItem(this);
    }
}

class Enemy extends Entity {
    int kekuatan;

    public Enemy(String nama, int kekuatan) {
        super(nama);
        this.kekuatan = kekuatan;
    }

    public void temui(Player pemain) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Musuh muncul: " + nama + " (Kekuatan: " + kekuatan + ")");
        System.out.print("(Lawan/Lari) ");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("lawan")) {
            int serangan = new Random().nextInt(40) + 10;
            if (serangan >= kekuatan) {
                System.out.println("Kamu berhasil mengalahkan " + nama);
                pemain.naikLevel();
            } else {
                int damage = kekuatan - serangan;
                pemain.kurangiNyawa(damage);
                System.out.println("Kamu terkena serangan! Nyawa berkurang: " + damage);
                if (pemain.getNyawa() <= 0) {
                    System.out.println("Kamu mati. Permainan selesai");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Kamu melarikan diri");
        }
    }
}
