import java.util.Scanner;

public class SistemPeminjamanMain20 {
    public static void main(String[] args) {

        // data awal [cite: 31, 33]
        Mahasiswa20[] daftarMhs = {
            new Mahasiswa20("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa20("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa20("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku20[] daftarBuku = {
            new Buku20("B001", "Algoritma", 2020),
            new Buku20("B002", "Basis Data", 2019),
            new Buku20("B003", "Pemrograman", 2021),
            new Buku20("B004", "Fisika", 2024)
        };

        // Data Peminjaman [cite: 36]
        Peminjaman20[] pinjam = {
            new Peminjaman20(daftarMhs[0], daftarBuku[0], 7),
            new Peminjaman20(daftarMhs[1], daftarBuku[1], 3),
            new Peminjaman20(daftarMhs[2], daftarBuku[2], 10),
            new Peminjaman20(daftarMhs[2], daftarBuku[3], 6),
            new Peminjaman20(daftarMhs[0], daftarBuku[1], 4)
        };

        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa\n2. Tampil Buku\n3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda\n5. Cari Berdasarkan NIM\n0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1: 
                    System.out.println("\nDaftar Mahasiswa: ");
                    for (Mahasiswa20 m : daftarMhs) m.tampilMahasiswa();
                    break;
                case 2: 
                    System.out.println("\nDaftar Buku: ");
                    for (Buku20 b : daftarBuku) b.tampilBuku();
                    break;
                case 3: 
                    System.out.println("\nDaftar Peminjaman: ");
                    for (Peminjaman20 p : pinjam) p.tampilPeminjaman();
                    break;
                case 4:
                    // Insertion Sort (Denda Terbesar ke Terkecil) 
                    for (int i = 1; i < pinjam.length; i++) {
                        Peminjaman20 key = pinjam[i];
                        int j = i - 1;
                        while (j >= 0 && pinjam[j].denda < key.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = key;
                    }
                    System.out.println("\nSetelah diurutkan (Denda terbesar): ");
                    for (Peminjaman20 p : pinjam) p.tampilPeminjaman();
                    break;
                case 5:
                    // Binary Search (Data harus urut NIM dulu) 
                    for (int i = 1; i < pinjam.length; i++) {
                        Peminjaman20 key = pinjam[i];
                        int j = i - 1;
                        while (j >= 0 && pinjam[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = key;
                    }

                    System.out.print("Masukkan NIM: ");
                    String cariNim = sc.next();
                    int low = 0, high = pinjam.length - 1;
                    boolean found = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (pinjam[mid].mhs.nim.equals(cariNim)) {
                            pinjam[mid].tampilPeminjaman();
                            found = true;
                            
                            // Cek NIM yang sama di sekitar index ditemukan
                            int temp = mid - 1;
                            while(temp >= 0 && pinjam[temp].mhs.nim.equals(cariNim)) {
                                pinjam[temp--].tampilPeminjaman();
                            }
                            temp = mid + 1;
                            while(temp < pinjam.length && pinjam[temp].mhs.nim.equals(cariNim)) {
                                pinjam[temp++].tampilPeminjaman();
                            }
                            break;
                        } else if (pinjam[mid].mhs.nim.compareTo(cariNim) < 0) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    if (!found) System.out.println("Data tidak ditemukan.");
                    break;
            }
        } while (pilih != 0);
    }
}