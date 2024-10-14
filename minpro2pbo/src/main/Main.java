package main;

import crud.CRUD;
import model.Jurnal;
import model.PrivateJurnal;
import model.PublicJurnal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements CRUD {
    private final ArrayList<Jurnal> daftarJurnal = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            System.out.println("\n=== Jurnal Harian ===");
            System.out.println("1. Tambah Jurnal");
            System.out.println("2. Baca Jurnal");
            System.out.println("3. Edit Jurnal");
            System.out.println("4. Hapus Jurnal");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("\n======================");

            switch (pilihan) {
                case 1:
                    main.tambahJurnal();
                    break;
                case 2:
                    main.bacaIsiJurnal();
                    break;
                case 3:
                    main.editJurnal();
                    break;
                case 4:
                    main.hapusJurnal();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void tambahJurnal(Jurnal jurnal) {
        daftarJurnal.add(jurnal);
    }

    public void tambahJurnal() {
        System.out.print("Masukkan judul jurnal: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan isi jurnal: ");
        String isi = scanner.nextLine();
        System.out.print("Masukkan tanggal jurnal (DD/MM/YYYY): ");
        String tanggal = scanner.nextLine();

        System.out.println("Pilih jenis jurnal:");
        System.out.println("1. Jurnal Biasa");
        System.out.println("2. Jurnal Private");
        System.out.print("Pilih opsi: ");
        int tipe = scanner.nextInt();
        scanner.nextLine(); 

        Jurnal jurnal;
        if (tipe == 1) {
            jurnal = new PublicJurnal(judul, isi, tanggal);
        } else {
            System.out.print("Masukkan password untuk jurnal private: ");
            String password = scanner.nextLine();
            jurnal = new PrivateJurnal(judul, isi, tanggal, password);
        }
        tambahJurnal(jurnal);
        System.out.println("Jurnal berhasil ditambahkan!");
    }

    @Override
    public void lihatSemuaJurnal() {
    if (daftarJurnal.isEmpty()) {
        System.out.println("Tidak ada jurnal.");
    } else {
        for (int i = 0; i < daftarJurnal.size(); i++) {
            // Cetak judul terbaru dari jurnal, baik itu jurnal biasa atau private
            System.out.println((i + 1) + ". " + daftarJurnal.get(i).getJudul());
            System.out.println( "Tanggal :"+ daftarJurnal.get(i).getTanggal());
        }
    }
}
    
    @Override
    public void bacaIsiJurnal(int index) {
        if (index > 0 && index <= daftarJurnal.size()) {
            Jurnal jurnalDipilih = daftarJurnal.get(index - 1);
            if (jurnalDipilih instanceof PrivateJurnal) {
                System.out.print("Masukkan password untuk jurnal private: ");
                String password = scanner.nextLine();
                PrivateJurnal privateJurnal = (PrivateJurnal) jurnalDipilih;
                if (privateJurnal.getPassword().equals(password)) {
                    privateJurnal.tampilkanIsiLengkap();
                } else {
                    System.out.println("Password salah! Akses ditolak.");
                }
            } else {
                jurnalDipilih.tampilkanIsiLengkap();
            }
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }

    public void bacaIsiJurnal() {
        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal untuk membaca isinya: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n======================");

        bacaIsiJurnal(index);
    }

    @Override
    public void editJurnal(int index) {
        if (index > 0 && index <= daftarJurnal.size()) {
            Jurnal jurnal = daftarJurnal.get(index - 1);

            if (jurnal instanceof PrivateJurnal) {
                System.out.print("Masukkan password untuk jurnal private: ");
                String password = scanner.nextLine();
                PrivateJurnal privateJurnal = (PrivateJurnal) jurnal;
                if (!privateJurnal.getPassword().equals(password)) {
                    System.out.println("Password salah! Akses ditolak.");
                    return;
                }

                System.out.println("Judul jurnal private tidak dapat diubah: " + privateJurnal.getJudul());

            } else if (jurnal instanceof PublicJurnal) {
                System.out.print("Judul saat ini: " + jurnal.getJudul() + ". Tekan Enter jika tidak ingin mengubah: ");
                String judulBaru = scanner.nextLine();
                if (!judulBaru.isEmpty()) {
                    jurnal.setJudul(judulBaru);
                }
            }

            System.out.print("Isi saat ini: " + jurnal.getIsi() + ". Tekan Enter jika tidak ingin mengubah: ");
            String isiBaru = scanner.nextLine();
            if (!isiBaru.isEmpty()) {
                jurnal.setIsi(isiBaru);
            }

            System.out.print("Tanggal saat ini: " + jurnal.getTanggal() + ". Tekan Enter jika tidak ingin mengubah: ");
            String tanggalBaru = scanner.nextLine();
            if (!tanggalBaru.isEmpty()) {
                jurnal.setTanggal(tanggalBaru);
            }

            System.out.println("Jurnal berhasil diupdate!");
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }

    public void editJurnal() {
        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal yang ingin diedit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 
        editJurnal(index);
    }

    @Override
    public void hapusJurnal(int index) {
        if (index > 0 && index <= daftarJurnal.size()) {
            daftarJurnal.remove(index - 1);
            System.out.println("Jurnal berhasil dihapus!");
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }

    public void hapusJurnal() {
        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 
        hapusJurnal(index);
    }
}
