package crud;

import model.Jurnal;

public interface CRUD {
    void tambahJurnal(Jurnal jurnal);
    void lihatSemuaJurnal();
    void bacaIsiJurnal(int index);
    void editJurnal(int index);
    void hapusJurnal(int index);
}
