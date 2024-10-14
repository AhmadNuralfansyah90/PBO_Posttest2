package model;

public final class PrivateJurnal extends Jurnal {
    private final String password;  
    private final String judul;    

    public PrivateJurnal(final String judul, String isi, String tanggal, final String password) {
        super(judul,isi, tanggal);
        this.judul = judul;
        this.password = password;
    }


    @Override
    public String getJudul() {
        return judul;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void tampilkanIsiLengkap() {
        System.out.println("Judul (Private): " + judul);
        System.out.println("Tanggal: " + getTanggal());
        System.out.println("Isi: " + getIsi());
        System.out.println("\n======================");
    }
}
