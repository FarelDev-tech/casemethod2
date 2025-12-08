import java.util.Scanner;

public class CM2Magang08 {
    static String[][] dataMagang = new String[10000][6];
    static int totalPendaftar = 0;

    public static void main(String[] args) {
        menu();
    }

    static void tambahData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Tambah Data Magang --");

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
            if (status.equalsIgnoreCase("Diterima") || 
                status.equalsIgnoreCase("Menunggu") || 
                status.equalsIgnoreCase("Ditolak")) {
                break;
            } else {
                System.out.println("Input Salah! Status harus Diterima, Menunggu, atau Ditolak.");
            }
        }

        dataMagang[totalPendaftar][0] = nama;
        dataMagang[totalPendaftar][1] = String.valueOf(nim);
        dataMagang[totalPendaftar][2] = prodi;
        dataMagang[totalPendaftar][3] = perusahaan;
        dataMagang[totalPendaftar][4] = String.valueOf(semester);
        dataMagang[totalPendaftar][5] = status;

        totalPendaftar++;
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total Pendaftar: " + totalPendaftar);
    }

    static void tampilkanData() {
        System.out.println("-- Tampilkan Data Magang --");
        if (totalPendaftar == 0) {
            System.out.println("Belum ada pendaftar.");
        } else {
            System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", "Nama Mahasiswa", "NIM", "Program Studi", "Perusahaan Tujuan Magang", "Semester", "Status Magang");
            for (int i = 0; i < totalPendaftar; i++) {
                System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", dataMagang[i][0], dataMagang[i][1], dataMagang[i][2], dataMagang[i][3], dataMagang[i][4], dataMagang[i][5]);
            }
        }
    }

    static void cariProgramStudi() {
        Scanner sc = new Scanner(System.in);
        String cariProdi;

        System.out.print("Masukkan Program Studi yang dicari: ");
        cariProdi = sc.nextLine();

        System.out.println("-- Hasil Pencarian --");
        if (totalPendaftar == 0) {
            System.out.println("Data tidak Ditemukan");
        } else {
            System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", "Nama Mahasiswa", "NIM", "Program Studi", "Perusahaan Tujuan Magang", "Semester", "Status Magang");
            for (int i = 0; i < totalPendaftar; i++) {
                if (dataMagang[i][2].equalsIgnoreCase(cariProdi)) {
                    System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", dataMagang[i][0], dataMagang[i][1], dataMagang[i][2], dataMagang[i][3], dataMagang[i][4], dataMagang[i][5]);
                }
            }
        }
    }

    static void hitungJumlahPendaftar() {
        int diterima = 0, menunggu = 0, ditolak = 0;

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

        do {
            System.out.println("-- Menu --");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Data Magang");
            System.out.println("3. Cari Program Studi");
            System.out.println("4. Jumlah Status Pendaftar");
            System.out.println("5. Keluar");
            System.out.print("Pilihan menu(1-5): ");

            menu = sc.nextInt();

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

/*
Rubrik Penilaian KodeNo Kriteria Penilaian Skor1 Alur ProgramProgram statis, tidak memakai menuProgram dinamis, menu lengkap dan alur jelas052 Penerapan PemilihanTidak ada validasi inputValidasi sebagian (hanya satu parameter input)Validasi lengkap sesuai aturan studi kasus07153 Penerapan PerulanganTidak menggunakan perulanganMenggunakan perulangan sederhanaMenggunakan nested loop untuk menampilkan atau memproses data07154 Penerapan ArrayTidak menggunakan arrayMenggunakan array satu dimensiMenggunakan array dua dimensi07155 Penerapan FungsiTidak menggunakan fungsiMenggunakan beberapa fungsi sajaSemua fitur ditangani oleh fungsi terpisah sesuai tujuannya0715Total Penilaian Kode 65
*/

/*
import java.util.Scanner;

public class CM2Magang08 {
    // === GLOBAL VARIABLES ===
    // Array 2D ditaruh disini agar bisa dibaca semua fungsi
    // Maksimal 100 pendaftar, 6 kolom (Nama, NIM, Prodi, PT, Sem, Status)
    static String[][] dataMagang = new String[100][6]; 
    static int totalPendaftar = 0; 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Method main untuk menjalankan program pertama kali
        menu();
    }

    // Fungsi a) Menambahkan data
    static void tambahData() {
        System.out.println("\n--- Tambah Data Magang ---");
        
        // Membersihkan buffer scanner
        sc.nextLine(); 

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        
        System.out.print("Program Studi: ");
        String programStudi = sc.nextLine();
        
        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        // VALIDASI SEMESTER (Rubrik: Penerapan Pemilihan & Perulangan)
        int semester = 0;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine(); // consume newline
            if (semester == 6 || semester == 7) {
                break; // input valid, keluar loop
            } else {
                System.out.println("Input Salah! Semester harus 6 atau 7.");
            }
        }

        // VALIDASI STATUS (Rubrik: Penerapan Pemilihan & Perulangan)
        String status = "";
        while (true) {
            System.out.print("Status Magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            // IgnoreCase agar user bisa ketik "diterima" atau "Diterima"
            if (status.equalsIgnoreCase("Diterima") || 
                status.equalsIgnoreCase("Menunggu") || 
                status.equalsIgnoreCase("Ditolak")) {
                
                // Standarisasi format string agar rapi saat dihitung nanti
                if(status.equalsIgnoreCase("Diterima")) status = "Diterima";
                if(status.equalsIgnoreCase("Menunggu")) status = "Menunggu";
                if(status.equalsIgnoreCase("Ditolak")) status = "Ditolak";
                break;
            } else {
                System.out.println("Input Salah! Status harus Diterima, Menunggu, atau Ditolak.");
            }
        }

        // Simpan ke Array 2D (Rubrik: Penerapan Array)
        dataMagang[totalPendaftar][0] = nama;
        dataMagang[totalPendaftar][1] = nim;
        dataMagang[totalPendaftar][2] = programStudi;
        dataMagang[totalPendaftar][3] = perusahaan;
        dataMagang[totalPendaftar][4] = String.valueOf(semester);
        dataMagang[totalPendaftar][5] = status;

        totalPendaftar++; // Tambah counter agar data berikutnya mengisi baris baru
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total Pendaftar: " + totalPendaftar);
    }

    // Fungsi b) Menampilkan seluruh data
    static void tampilkanData() {
        System.out.println("\n--- Data Pendaftar Magang ---");
        if (totalPendaftar == 0) {
            System.out.println("Belum ada pendaftar.");
        } else {
            // Header Tabel
            System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", 
                "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            
            // Nested Loop / Loop Array 2D (Rubrik: Penerapan Perulangan & Array)
            for (int i = 0; i < totalPendaftar; i++) {
                System.out.printf("%-20s %-15s %-20s %-20s %-10s %-15s\n", 
                    dataMagang[i][0], // Nama
                    dataMagang[i][1], // NIM
                    dataMagang[i][2], // Prodi
                    dataMagang[i][3], // Perusahaan
                    dataMagang[i][4], // Semester
                    dataMagang[i][5]  // Status
                );
            }
        }
    }

    // Fungsi c) Cari berdasarkan Prodi
    static void cariProgramStudi() {
        sc.nextLine(); // membersihkan buffer
        System.out.print("\nMasukkan Program Studi yang dicari: ");
        String cariProdi = sc.nextLine();
        
        boolean ditemukan = false;
        
        System.out.println("\n--- Hasil Pencarian ---");
        System.out.printf("%-20s %-15s %-20s %-15s\n", "Nama", "NIM", "Prodi", "Status");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < totalPendaftar; i++) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (dataMagang[i][2].equalsIgnoreCase(cariProdi)) {
                System.out.printf("%-20s %-15s %-20s %-15s\n", 
                    dataMagang[i][0], dataMagang[i][1], dataMagang[i][2], dataMagang[i][5]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data dengan Program Studi '" + cariProdi + "' tidak ditemukan.");
        }
    }

    // Fungsi d) Hitung jumlah per status
    static void hitungJumlahPendaftar() {
        int diterima = 0;
        int menunggu = 0;
        int ditolak = 0;

        for (int i = 0; i < totalPendaftar; i++) {
            String status = dataMagang[i][5];
            if (status.equals("Diterima")) {
                diterima++;
            } else if (status.equals("Menunggu")) {
                menunggu++;
            } else if (status.equals("Ditolak")) {
                ditolak++;
            }
        }

        System.out.println("\n--- Rekap Jumlah Pendaftar ---");
        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
    }

    // Fungsi Menu Utama
    static void menu() {
        int menu = 0;
        // Menggunakan do-while agar menu terus muncul sampai user pilih keluar (Rubrik: Alur Program)
        do {
            System.out.println("\n== Sistem Pendaftaran Magang ==");
            System.out.println("1. Tambahkan Data Magang");
            System.out.println("2. Tampilkan Data Magang");
            System.out.println("3. Cari Pendaftar Berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu(1-5): ");
            
            menu = sc.nextInt();

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
                    System.out.println("Terima kasih!");
                    break; // Loop akan berhenti karena while(menu != 5)
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        } while (menu != 5);
    }
}
*/

/*

*/