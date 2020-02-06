
public class Transaksi {
    private int idCustomer;
    private Long jumlah;
    private String tanggal;
    private String jenisTransaksi;

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public Transaksi(int idCustomer, Long jumlah, String tanggal, String jenisTransaksi) {
        this.idCustomer = idCustomer;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.jenisTransaksi = jenisTransaksi;
    }
}
