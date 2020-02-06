public class DataUang {
    private int idCustomer;
    private long saldo;
    private String tanggal;

    public int getIdCustomer() {
        return idCustomer;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public DataUang(int idCustomer, long saldo, String tanggal) {
        this.idCustomer = idCustomer;
        this.saldo = saldo;
        this.tanggal = tanggal;
    }
}
