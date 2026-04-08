public class Mahasiswa20 {
    String nim;
    String nama;
    String prodi;

    // konstruktor default
    Mahasiswa20() {
    }

    // konstruktor berparameter
    Mahasiswa20 (String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    void tampilMahasiswa() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}