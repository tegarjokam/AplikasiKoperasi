public class Customer {
    private int id;
    private String nama;
    private String jenisKelamin;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Customer(int id, String nama, String jenisKelamin) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }
}
