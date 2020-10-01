package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import java.util.List;

public interface ResepService {
    // untuk menambahkan Resep
    void addResep(ResepModel resep);

    void deleteResep(ResepModel resep);

    // untuk mendapatkan semua data Resep yang telah terseimpan
    List<ResepModel> getResepList();

    // untuk mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(String noResep);
}
