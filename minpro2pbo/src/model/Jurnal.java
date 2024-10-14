package model;

public abstract class Jurnal {
    private String judul;  
    private String isi;
    private String tanggal;

    public Jurnal(String judul, String isi, String tanggal) {
        this.judul = judul; 
        this.isi = isi;
        this.tanggal = tanggal;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void tampilkanRingkasan() {
        System.out.println("Judul: " + judul);
        System.out.println("Tanggal: " + tanggal);
    }

    public abstract void tampilkanIsiLengkap();
}
