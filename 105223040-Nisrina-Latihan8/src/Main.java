class HealthRecord {
    String nomor;
    String tanggal;

    HealthRecord(String nomor, String tanggal) {
        this.nomor = nomor;
        this.tanggal = tanggal;
    }
}

class Animal {
    HealthRecord healthRecord;

    Animal(String nomor, String tanggal) {
        this.healthRecord = new HealthRecord(nomor, tanggal);
    }

    void makeSound() {
        System.out.println("Suara hewan");
    }
}

class Dog extends Animal {
    Dog(String nomor, String tanggal) {
        super(nomor, tanggal);
    }

    void makeSound() {
        System.out.println("Guk-Guk!");
    }
}

class Cat extends Animal {
    Cat(String nomor, String tanggal) {
        super(nomor, tanggal);
    }

    void makeSound() {
        System.out.println("Meong!");
    }
}

class Owner {
    String nama;
    Animal hewan;

    Owner(String nama, Animal hewan) {
        this.nama = nama;
        this.hewan = hewan;
    }

    void tampilkanInfo() {
        System.out.println("Pemilik: " + nama);

        if (hewan instanceof Dog) {
            System.out.println("Jenis hewan: Anjing");
        } else if (hewan instanceof Cat) {
            System.out.println("Jenis hewan: Kucing");
        }

        System.out.print("Suara: ");
        hewan.makeSound();

        System.out.println("No rekam medis: " + hewan.healthRecord.nomor);
        System.out.println("Tanggal rekam medis: " + hewan.healthRecord.tanggal);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("40", "2025-01-18");
        Cat cat = new Cat("41", "2025-01-26");

        Owner pemilik1 = new Owner("Nina", dog);
        Owner pemilik2 = new Owner("Tiara", cat);

        pemilik1.tampilkanInfo();
        System.out.println();
        pemilik2.tampilkanInfo();
    }
}