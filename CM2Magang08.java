import java.util.Scanner;

public class CM2Magang08 {
    // Global Variabel
    static String[][] dataMagang = new String[10000][6];
    static int totalPendaftar = 0;

    // main
    public static void main(String[] args) {
        menu();
    }

    // fungsi tambah data
    static void tambahData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Tambah Data Magang --");

        // Variabel
        String nama, prodi, perusahaan, status;
        long nim;
        int semester = 0;

        // Nama Mahasiswa
        System.out.print("Nama Mahasiswa: ");
        nama = sc.nextLine();
        // NIM 
        System.out.print("NIM: ");
        nim = sc.nextLong();

        // buffering
        sc.nextLine();

        // Program Studi
        System.out.print("Program Studi: ");
        prodi = sc.nextLine();
        // Perusahaan Tujuan Magang
        System.out.print("Perusahaan Tujuan Magang: ");
        perusahaan = sc.nextLine();

        // Pengambilan Magang
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine();
            // Pengondisian Semester
            if (semester == 6 || semester == 7) {
                break; 
            } else {
                System.out.println("Input Salah! Semester harus 6 atau 7.");
            }
        }

        // Status Magang
        while (true) {
            System.out.print("Status Magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            // Pengondisian Status
            if (status.equalsIgnoreCase("Diterima") || 
                status.equalsIgnoreCase("Menunggu") || 
                status.equalsIgnoreCase("Ditolak")) {
                break;
            } else {
                System.out.println("Input Salah! Status harus Diterima, Menunggu, atau Ditolak.");
            }
        }

        // Menyimpan data 
        dataMagang[totalPendaftar][0] = nama;
        dataMagang[totalPendaftar][1] = String.valueOf(nim);
        dataMagang[totalPendaftar][2] = prodi;
        dataMagang[totalPendaftar][3] = perusahaan;
        dataMagang[totalPendaftar][4] = String.valueOf(semester);
        dataMagang[totalPendaftar][5] = status;

        // Menghitung total pendaftaran
        totalPendaftar++;
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total Pendaftar: " + totalPendaftar);
    }

    // fungsi tampilkan data
    static void tampilkanData() {
        System.out.println("-- Tampilkan Data Magang --");
        // Pengondisian untuk menampilkan daftar data nya
        if (totalPendaftar == 0) {
            System.out.println("Belum ada pendaftar.");
        } else {
            // Menampilkan data
            System.out.printf("%-22s %-15s %-21s %-20s %-10s %-20s\n", "Nama Mahasiswa", "NIM", "Program Studi", "Perusahaan Tujuan Magang", "Semester", "Status Magang");
            for (int i = 0; i < totalPendaftar; i++) {
                System.out.printf("%-22s %-15s %-21s %-20s %-10s %-20s\n", dataMagang[i][0], dataMagang[i][1], dataMagang[i][2], dataMagang[i][3], dataMagang[i][4], dataMagang[i][5]);
            }
        }
    }

    // fungsi cari program studi
    static void cariProgramStudi() {
        Scanner sc = new Scanner(System.in);
        String cariProdi;

        System.out.print("Masukkan Program Studi yang dicari: ");
        cariProdi = sc.nextLine();

        System.out.println("-- Hasil Pencarian --");
        // Pengondisian untuk mencari data menggunakan nest loop
        if (totalPendaftar == 0) {
            System.out.println("Data tidak Ditemukan");
        } else {
            System.out.printf("%-22s %-15s %-21s %-20s %-10s %-20s\n", "Nama Mahasiswa", "NIM", "Program Studi", "Perusahaan Tujuan Magang", "Semester", "Status Magang");
            for (int i = 0; i < totalPendaftar; i++) {
                if (dataMagang[i][2].equalsIgnoreCase(cariProdi)) {
                    System.out.printf("%-22s %-15s %-21s %-20s %-10s %-20s\n", dataMagang[i][0], dataMagang[i][1], dataMagang[i][2], dataMagang[i][3], dataMagang[i][4], dataMagang[i][5]);
                }
            }
        }
    }

    // Fungsi hitung jumlah pendaftar
    static void hitungJumlahPendaftar() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        // Pengondisian untuk menghitung status jumlah pendaftar
        for (int i = 0; i < totalPendaftar; i++) {
            if (dataMagang[i][5].equalsIgnoreCase("Diterima")) {
                diterima++;
            } else if (dataMagang[i][5].equalsIgnoreCase("Menunggu")) {
                menunggu++;
            } else if (dataMagang[i][5].equalsIgnoreCase("Ditolak")) {
                ditolak++;
            }
        }

        System.out.println("-- Jumlah Status Pendaftar --");
        System.out.println("Diterima: " + diterima);
        System.out.println("Menunggu: " + menunggu);
        System.out.println("Ditolak: " + ditolak);
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        int menu;

        // Perulangan do-while untuk menampilkan menu
        do {   
            System.out.println("-- Menu --");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Data Magang");
            System.out.println("3. Cari Program Studi");
            System.out.println("4. Jumlah Status Pendaftar");
            System.out.println("5. Keluar");
            System.out.print("Pilihan menu(1-5): ");

            menu = sc.nextInt();

            // Switch case untuk memilih menu
            switch (menu) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    cariProgramStudi();
                    break;
                case 4:
                    hitungJumlahPendaftar();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            } 
        } while (menu != 5);
    }
}