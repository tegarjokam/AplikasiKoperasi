import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void tambahAdmin(List<Admin> kumpulanAdmin) {

        Scanner input = new Scanner(System.in);
        System.out.println("#### Create ####");

        try {
            System.out.print("# Id            : ");
            Integer id = input.nextInt();
            System.out.print("# Nama          : ");
            String nama = input.next();
            System.out.print("# Jenis Kelamin : ");
            String jenisKelamin = input.next();

            List adminLength = new ArrayList();
            for (Admin admin : kumpulanAdmin) {
                adminLength.add(admin.getId());
                if (id == admin.getId()) {
                    System.out.println("\nId customer sudah ada, cari id lain");
                    break;
                } else if (kumpulanAdmin.size() == adminLength.size() && id != admin.getId()) {
                    kumpulanAdmin.add(new Admin(id,nama,jenisKelamin));
                    System.out.println("\n################");
                    System.out.println("ADMIN SUKSES TERBUAT...");
                    System.out.println("################");
                    break;
                }
            }

            if (kumpulanAdmin.size() == 0) {
                kumpulanAdmin.add(new Admin(id,nama,jenisKelamin));
                System.out.println("\n################");
                System.out.println("ADMIN SUKSES TERBUAT...");
                System.out.println("################");
            }
        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
            System.err.println("");
        }

    }

    public static void perbaruiAdmin(List<Admin> kumpulanAdmin) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n#### Update ####");

        try {
            System.out.print("# Id : ");

            Integer cariId = input.nextInt();
            if ( kumpulanAdmin.size() == 0) {
                System.out.println("\n################");
                System.out.println("Id tidak ditemukan");
                System.out.println("################");
            }
            for (int i = 0; i < kumpulanAdmin.size(); i++) {
                if (cariId == kumpulanAdmin.get(i).getId()) {
                    System.out.println("\n### Ditemukan ###");
                    System.out.print("# Nama : ");
                    String nama = input.next();
                    System.out.print("# Jenis Kelamin : ");
                    String jenisKelamin = input.next();
                    kumpulanAdmin.get(i).setNama(nama);
                    kumpulanAdmin.get(i).setJenisKelamin(jenisKelamin);
                    System.out.println("\n Sukses Update ...");
                } else {
                    if ( i == kumpulanAdmin.size()-1 || kumpulanAdmin.size() == 0 ) {
                        System.out.println("\n################");
                        System.out.println("Id tidak ditemukan");
                        System.out.println("################");
                    }
                }
            }


        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
            System.err.println("");
        }

    }

    public static void hapusAdmin(List<Admin> kumpulanAdmin) {

        Scanner input = new Scanner(System.in);
        tampilkanListAdmin(kumpulanAdmin);

        try  {
            System.out.println("\n#### Hapus #####");
            System.out.print("# Pilih [id] : ");
            Integer pilihanHapus = input.nextInt();
            System.out.println("################");
            for ( int i = 0; i < kumpulanAdmin.size(); i++) {
                if ( pilihanHapus == kumpulanAdmin.get(i).getId() ) {
                    kumpulanAdmin.remove(i);
                    System.out.println("\nBerhasil menghapus ...");
                } else {
                    if ( i == kumpulanAdmin.size()-1 || kumpulanAdmin.size() == 0) {
                        System.out.println("id tidak ditemukan ...");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
            System.err.println("");
        }
    }

    public static void tampilkanListAdmin(List<Admin> kumpulanAdmin) {
        System.out.println("\n### List Admin ###");
        if (kumpulanAdmin.size() == 0) {
            System.out.println("- tidak ada data -");
        }
        for (int i = 0; i < kumpulanAdmin.size(); i++) {
            System.out.println( kumpulanAdmin.get(i).getId() + ". " + kumpulanAdmin.get(i).getNama());
        }
    }


    public static void tambahCustomer(List<Customer> kumpulanCustomer, List<DataUang> kumpulanDataUang) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n#### Create ####");

        try {
            System.out.print("# Id              : ");
            Integer id = input.nextInt();
            System.out.print("# Nama            : ");
            String nama = input.next();
            System.out.print("# Jenis Kelamin   : ");
            String jenisKelamin = input.next();

            List customerLength = new ArrayList();
            for (Customer customer : kumpulanCustomer) {
                customerLength.add(customer.getId());
                if (id == customer.getId()) {
                    System.out.println("\nId customer sudah ada, Cari id lain");
                    break;
                } else if (kumpulanCustomer.size() == customerLength.size() && id != customer.getId()) {
                    Date date = new Date();
                    SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");
                    String tanggal = formatTanggal.format(date);
                    kumpulanCustomer.add(new Customer(id,nama,jenisKelamin));
                    kumpulanDataUang.add(new DataUang(id,0,tanggal));
                    System.out.println("\n################");
                    System.out.println("CUSTOMER SUKSES TERBUAT...");
                    System.out.println("################");
                    break;
                }
            }

            if (kumpulanCustomer.size() == 0) {
                Date date = new Date();
                SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");
                String tanggal = formatTanggal.format(date);
                kumpulanCustomer.add(new Customer(id,nama,jenisKelamin));
                kumpulanDataUang.add(new DataUang(id,0,tanggal));
                System.out.println("\n################");
                System.out.println("CUSTOMER SUKSES TERBUAT...");
                System.out.println("################");
            }
        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
            System.err.println("");
        }


    }

    public static void perbaruiCustomer(List<Customer> kumpulanCustomer) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n#### Update ####");

        try {
            System.out.print("# Id : ");

            Integer cariId = input.nextInt();
            if ( kumpulanCustomer.size() == 0) {
                System.out.println("\n################");
                System.out.println("Id tidak ditemukan");
                System.out.println("################");
            }
            List customerLength = new ArrayList();
            for (Customer customer : kumpulanCustomer) {
                customerLength.add(customer.getId());
                if (cariId == customer.getId()) {
                    System.out.println("\n### Ditemukan ###");
                    System.out.print("# Nama : ");
                    String nama = input.next();
                    System.out.print("# Jenis Kelamin : ");
                    String jenisKelamin = input.next();
                    customer.setNama(nama);
                    customer.setJenisKelamin(jenisKelamin);
                    System.out.println("\n Sukses Update ...");
                    break;
                } else {
                    if ( kumpulanCustomer.size() == customerLength.size()) {
                        System.out.println("\n################");
                        System.out.println("Id Customer tidak ditemukan");
                        System.out.println("################");
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
            System.err.println("");
        }

    }

    public static void tampilkanListCustomer(List<Customer> kumpulanCustomer) {

        System.out.println("\nId\t Nama Customer");
        System.out.println("========================");

        if (kumpulanCustomer.size() == 0) {
            System.out.println("- Tidak ada data -");
        }

        for (Customer customer : kumpulanCustomer) {
            System.out.println(customer.getId() + "\t " + customer.getNama());
        }
    }


    public static void depositUang(List<DataUang> kumpulanDataUang, List<Customer> kumpulanCustomer, List<Transaksi> kumpulanTransaksi) {

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\n### Deposit ###");
            System.out.print("# Id Customer : ");
            Integer idCustomer = input.nextInt();
            System.out.println("################");

            //Cek Isi Customer
            if (kumpulanCustomer.size() == 0) {
                System.out.println("\nId customer tidak ditemukan");
            }

            List customerLength = new ArrayList();
            for (Customer customer : kumpulanCustomer) {
                customerLength.add(customer.getId());
                if (idCustomer == customer.getId()) {
                    try {
                        //cek isi kumpulanDataUang
                        if (kumpulanDataUang.size() == 0) {
                            System.out.println("Nama : " + customer.getNama());
                            System.out.print("#Jumlah Uang : ");
                            Long jumlahUang = input.nextLong();
                            Date date = new Date();
                            SimpleDateFormat formaterTgl = new SimpleDateFormat("dd-MM-yyyy");
                            String tanggal = formaterTgl.format(date);
                            kumpulanDataUang.add(new DataUang(idCustomer, jumlahUang, tanggal));
                            kumpulanTransaksi.add(new Transaksi(idCustomer, jumlahUang, tanggal, "deposit"));
                            System.out.println("\n################");
                            System.out.println("Deposit Sukses ...");
                            System.out.println("################");
                        } else {
                            //looping pada kumpulanDataUang
                            for (DataUang dataUang : kumpulanDataUang) {
                                if (idCustomer == dataUang.getIdCustomer()){
                                    System.out.println("Nama : " + customer.getNama());
                                    System.out.print("# Jumlah Uang : ");
                                    Long jumlahUang = input.nextLong();
                                    Date date = new Date();
                                    SimpleDateFormat formaterTgl = new SimpleDateFormat("dd-MM-yyyy");
                                    String tanggal = formaterTgl.format(date);
                                    Long tambahJumlahUang = jumlahUang + dataUang.getSaldo();
                                    dataUang.setSaldo(tambahJumlahUang);
                                    dataUang.setTanggal(tanggal);
                                    kumpulanTransaksi.add(new Transaksi(idCustomer, jumlahUang, tanggal, "deposit"));
                                    System.out.println("\n################");
                                    System.out.println("Deposit Sukses ...");
                                    System.out.println("################");
                                }
                            }
                        }
                        break;
                    } catch (Exception e) {
                        System.err.println("Input tidak dikenali");
                    }
                } else if (kumpulanCustomer.size() == customerLength.size()) {
                    System.out.println("\nId customer tidak ditemukan");
                }
            }
        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
        }


    }

    public static void tarikUang(List<DataUang> kumpulanDataUang, List<Customer> kumpulanCustomer, List<Transaksi> kumpulanTransaksi) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\n## Tarik Uang ##");
            System.out.print("# Id Customer : ");
            Integer idCustomer = input.nextInt();
            System.out.println("################");

            //Cek Isi Customer
            if (kumpulanCustomer.size() == 0) {
                System.out.println("\nId customer tidak ditemukan");
            }

            List customerLength = new ArrayList();
            for (Customer customer : kumpulanCustomer) {
                customerLength.add(customer.getId());
                if (idCustomer == customer.getId()) {
                    try {
                        for (DataUang dataUang : kumpulanDataUang) {
                            if (idCustomer == dataUang.getIdCustomer()){

                                System.out.println("Nama : " + customer.getNama());
                                System.out.print("# Jumlah Penarikan : ");
                                Long jumlahPenarikan = input.nextLong();

                                if (jumlahPenarikan <= dataUang.getSaldo()) {
                                    Date date = new Date();
                                    SimpleDateFormat formaterTgl = new SimpleDateFormat("dd-MM-yyyy");
                                    String tanggal = formaterTgl.format(date);
                                    Long sisaUang = dataUang.getSaldo() - jumlahPenarikan;
                                    dataUang.setSaldo(sisaUang);
                                    dataUang.setTanggal(tanggal);
                                    kumpulanTransaksi.add(new Transaksi(idCustomer, jumlahPenarikan, tanggal, "kredit"));
                                    System.out.println("\n################");
                                    System.out.println("Penarikan Sukses ...");
                                    System.out.println("################");
                                    break;
                                } else {
                                    System.out.println("\n################");
                                    System.out.println("Penarikan Gagal");
                                    System.out.println("Jumlah Saldo tidak mencukupi");
                                    System.out.println("################");
                                    break;
                                }
                            }
                        }
                        break;
                    } catch (Exception e) {
                        System.err.println("Input tidak dikenali");
                    }
                } else if (kumpulanCustomer.size() == customerLength.size()) {
                    System.out.println("\nId customer tidak ditemukan");
                }
            }



        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
        }


    }

    public static void cekSaldo(List<DataUang> kumpulanDataUang, List<Customer> kumpulanCustomer) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n### Cek Saldo ###");
        try {
            System.out.print("# Id : ");
            Integer idCustomer = input.nextInt();

            if (kumpulanCustomer.size() == 0) {
                System.out.println("\nCustomer tidak ditemukan");
            }

            List customerLength = new ArrayList();
            for (Customer customer : kumpulanCustomer) {
                customerLength.add(customer.getId());
                if (idCustomer == customer.getId()) {
                    for (DataUang datauang : kumpulanDataUang)  {
                        if (idCustomer  == datauang.getIdCustomer()) {
                            System.out.println("\nNama  : " + customer.getNama());
                            System.out.println("Saldo : Rp " + datauang.getSaldo());
                        }
                    }
                    break;
                } else if (kumpulanCustomer.size() == customerLength.size()) {
                    System.out.println("\nId customer tidak ditemukan");
                }

            }


        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
        }

    }


    public static void semuaTransaksi(List<Transaksi> kumpulanTransaksi, List<Customer> kumpulanCustomer) {

        System.out.println("\n\t\t\t\t  SEMUA TRANSAKSI");
        System.out.println("=================================================");
        System.out.println("Tanggal \tNama Customer \tJumlah Uang\t Jenis");
        System.out.println("=================================================");

        if (kumpulanTransaksi.size() == 0) {
            System.out.println("- tidak ada transaksi -");
        }

        for (Transaksi transaksi : kumpulanTransaksi) {
            for (Customer customer : kumpulanCustomer)  {
                if (transaksi.getIdCustomer() == customer.getId()) {
                    String namaCustomer = customer.getNama();
                    Long jumlahUang = transaksi.getJumlah();
                    String tanggal = transaksi.getTanggal();
                    String jenisTransaksi = transaksi.getJenisTransaksi();
                    System.out.println(tanggal + "\t" + namaCustomer + "\t\t\tRp. " + jumlahUang + "\t\t" + jenisTransaksi);
                }
            }
        }


    }

    public static void individualTransaksi(List<Transaksi> kumpulanTransaksi, List<Customer> kumpulanCustomer) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\tCARI CUSTOMER");


        try {
            System.out.print("# Id : ");
            Integer idCustomer = input.nextInt();
            System.out.println("\n\t\t\t\tINDIVIDUAL TRANSAKSI");
            System.out.println("=================================================");
            System.out.println("Tanggal \tNama Customer \tJumlah Uang\t Jenis");
            System.out.println("=================================================");


            for (Transaksi transaksi : kumpulanTransaksi) {
                if (transaksi.getIdCustomer() == idCustomer) {
                    for (Customer customer : kumpulanCustomer)  {
                        if (customer.getId() == idCustomer) {
                            String namaCustomer = customer.getNama();
                            Long jumlahUang = transaksi.getJumlah();
                            String tanggal = transaksi.getTanggal();
                            String jenisTransaksi = transaksi.getJenisTransaksi();
                            System.out.println(tanggal + "\t" + namaCustomer + "\t\t\tRp. " + jumlahUang + "\t\t" + jenisTransaksi);
                            break;
                        }
                    }
                }
            }

            if (kumpulanTransaksi.size() == 0) {
                System.out.println("- data tidak ditemukan -");
            }


        } catch (Exception e) {
            System.err.println("Input tidak dikenali");
        }


    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean perulanganUtama = true;
        List<Admin> kumpulanAdmin = new ArrayList<>();
        List<Customer> kumpulanCustomer = new ArrayList<>();
        List<DataUang> kumpulanDataUang = new ArrayList<>();
        List<Transaksi> kumpulanTransaksi = new ArrayList<>();

        while(perulanganUtama) {
            try {
                System.out.println("\n################");
                System.out.println("### KOPERASI ###");
                System.out.println("################");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Data Uang");
                System.out.println("4. Transaksi");
                System.out.println("5. Selesai");
                System.out.println("################");
                System.out.print("# Pilih : ");
                Integer pilih = input.nextInt();
                System.out.println("################");

                boolean perulanganPilihan = true;
                switch (pilih) {
                    case 1:
                        while(perulanganPilihan) {
                            try {
                                System.out.println("\n##### Admin ####");
                                System.out.println("1. Create");
                                System.out.println("2. Update");
                                System.out.println("3. Delete");
                                System.out.println("4. Lihat List Admin");
                                System.out.println("5. Kembali");
                                System.out.println("################");
                                System.out.print("# Pilih :  ");
                                pilih = input.nextInt();
                                System.out.println("################");

                                switch (pilih) {
                                    case 1:
                                        tambahAdmin(kumpulanAdmin);
                                        break;
                                    case 2:
                                        perbaruiAdmin(kumpulanAdmin);
                                        break;
                                    case 3:
                                        hapusAdmin(kumpulanAdmin);
                                        break;
                                    case 4:
                                        tampilkanListAdmin(kumpulanAdmin);
                                        break;
                                    case 5:
                                        perulanganPilihan = false;
                                        break;
                                    default:
                                        System.out.println("\nInputlah sesuai dengan pilihan yang tersedia");
                                        break;
                                }


                            } catch (Exception e) {
                                System.err.println("Input tidak dikenali");
                                System.err.println("");
                                input.next();
                            }

                        }
                        break;
                    case 2:
                        while(perulanganPilihan) {
                            try {
                                System.out.println("\n### Customer ###");
                                System.out.println("1. Create");
                                System.out.println("2. Update");
                                System.out.println("3. List Customer");
                                System.out.println("4. Kembali");
                                System.out.println("################");
                                System.out.print("# Pilih :  ");
                                pilih = input.nextInt();
                                System.out.println("################");

                                switch (pilih) {
                                    case 1:
                                        tambahCustomer(kumpulanCustomer, kumpulanDataUang);
                                        break;
                                    case 2:
                                        tampilkanListCustomer(kumpulanCustomer);
                                        perbaruiCustomer(kumpulanCustomer);
                                        break;
                                    case 3:
                                        tampilkanListCustomer(kumpulanCustomer);
                                        break;
                                    case 4:
                                        perulanganPilihan = false;
                                        break;
                                    default:
                                        System.out.println("\nInputlah sesuai dengan pilihan yang tersedia");
                                        break;
                                }

                            } catch (Exception e) {
                                System.err.println("Input tidak dikenali");
                                System.err.println("");
                                input.next();
                            }

                        }
                        break;
                    case 3:
                        while (perulanganPilihan) {
                            try {
                                System.out.println("\n### Data Uang ###");
                                System.out.println("1. Deposit");
                                System.out.println("2. Tarik Uang");
                                System.out.println("3. Cek Saldo");
                                System.out.println("4. Kembali");
                                System.out.println("################");
                                System.out.print("# Pilih :  ");
                                pilih = input.nextInt();
                                System.out.println("################");

                                switch (pilih) {
                                    case 1:
                                        depositUang(kumpulanDataUang, kumpulanCustomer, kumpulanTransaksi);
                                        break;
                                    case 2:
                                        tarikUang(kumpulanDataUang, kumpulanCustomer, kumpulanTransaksi);
                                        break;
                                    case 3:
                                        cekSaldo(kumpulanDataUang, kumpulanCustomer);
                                        break;
                                    case 4:
                                        perulanganPilihan = false;
                                        break;
                                    default:
                                        System.out.println("\nInputlah sesuai dengan pilihan yang tersedia");
                                        break;
                                }

                            } catch (Exception e) {
                                System.err.println("Input tidak dikenali");
                                System.err.println("");
                                input.next();
                            }

                        }
                        break;
                    case 4:
                        while (perulanganPilihan) {
                            try {
                                System.out.println("\n### Transaksi ###");
                                System.out.println("1. Semua");
                                System.out.println("2. Individual");
                                System.out.println("3. Kembali");
                                System.out.println("################");
                                System.out.print("# Pilih :  ");
                                pilih = input.nextInt();
                                System.out.println("################");

                                switch (pilih) {
                                    case 1:
                                        semuaTransaksi(kumpulanTransaksi, kumpulanCustomer);
                                        break;
                                    case 2:
                                        individualTransaksi(kumpulanTransaksi, kumpulanCustomer);
                                        break;
                                    case 3:
                                        perulanganPilihan = false;
                                        break;
                                    default:
                                        System.out.println("\nInputlah sesuai dengan pilihan yang tersedia");
                                        break;
                                }

                            } catch (Exception e) {
                                System.err.println("Input tidak dikenali");
                                System.err.println("");
                                input.next();
                            }
                        }
                        break;
                    case 5:
                        perulanganUtama = false;
                        System.out.println("--TERIMA KASIH--");
                        break;
                    default:
                        System.out.println("\nPilihan tidak ditemukan");
                        break;

                }

            } catch (Exception e) {
                System.err.println("Input tidak dikenali");
                System.out.println("");
                input.next();
            }
        }
    }
}
