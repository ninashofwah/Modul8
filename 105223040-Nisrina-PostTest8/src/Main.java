class Vehicle {
    void startEngine() {
        System.out.println("Mesin Nyala");
    }
}

class Car extends Vehicle {
    void startEngine() {
        System.out.println("Mesin Mobil Nyala");
    }
}

class Motorcycle extends Vehicle {
    void startEngine() {
        System.out.println("Mesin Motor Nyala");
    }
}

class License {
    String nomor;
    String tanggalBerlaku;

    License(String nomor, String tanggalBerlaku) {
        this.nomor = nomor;
        this.tanggalBerlaku = tanggalBerlaku;
    }
}

class Driver {
    String nama;
    Vehicle kendaraan;
    License license;

    Driver(String nama, Vehicle kendaraan, License license) {
        this.nama = nama;
        this.kendaraan = kendaraan;
        this.license = license;
    }

    void tampilkanInfo() {
        System.out.println("Nama Pengemudi: " + nama);

        if (kendaraan instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (kendaraan instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        }

        System.out.print("Status Mesin: ");
        kendaraan.startEngine();

        System.out.println("Nomor Lisensi: " + license.nomor);
        System.out.println("Tanggal Berlaku Lisensi: " + license.tanggalBerlaku);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motor = new Motorcycle();

        License lisensi1 = new License("777", "2028-12-01");
        License lisensi2 = new License("666", "2028-12-02");

        Driver driver1 = new Driver("Rippun", car, lisensi1);
        Driver driver2 = new Driver("Tisam", motor, lisensi2);

        driver1.tampilkanInfo();
        System.out.println();
        driver2.tampilkanInfo();
    }
}