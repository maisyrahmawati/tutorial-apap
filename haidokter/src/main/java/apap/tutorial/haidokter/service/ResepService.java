package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import java.util.List;
import java.util.Optional;

public interface ResepService {
    // untuk menambahkan Resep
    void addResep(ResepModel resep);

    // void deleteResep(ResepModel resep);

    // untuk mendapatkan semua data Resep yang telah terseimpan
    List<ResepModel> getResepList();

    // untuk mendapatkan data sebuah resep berdasarkan nomor resep
    Optional<ResepModel> getResepByNomorResep(Long noResep);

    // untuk update resep
    ResepModel updateResep(ResepModel resepModel);

    // List<ResepModel> getAllResepDesc();

    // untuk delete resep
    void deleteResep(Long noResep);
}
