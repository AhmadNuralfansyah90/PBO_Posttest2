package model;

public class PublicJurnal extends Jurnal {
    private String judul;  

    public PublicJurnal(String judul, String isi, String tanggal) {
        super(judul,isi, tanggal);
        this.judul = judul;
    }

    @Override
    public String getJudul() {
        return judul;
    }

    @Override
    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public void tampilkanIsiLengkap() {
        System.out.println("Judul: " + judul);
        System.out.println("Tanggal: " + getTanggal());
        System.out.println("Isi: " + getIsi());
        System.out.println("\n======================");
    }
}
