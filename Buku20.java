public class Buku20 {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    // konstruktor default
    Buku20() {
    }

    // konstruktor berparameter
    Buku20 (String kode, String judul, int tahun) {
        kodeBuku = kode;
        this.judul = judul;
        tahunTerbit = tahun;
    }

    void tampilBuku() {
        System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}