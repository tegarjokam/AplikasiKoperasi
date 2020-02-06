public class Peminjaman {
    private int idCustomer;
    private long jumlahPeminjaman;

    public int getIdCustomer() {
        return idCustomer;
    }

    public long getJumlahPeminjaman() {
        return jumlahPeminjaman;
    }

    public Peminjaman(int idCustomer, long jumlahPeminjaman) {
        this.idCustomer = idCustomer;
        this.jumlahPeminjaman = jumlahPeminjaman;
    }
}
