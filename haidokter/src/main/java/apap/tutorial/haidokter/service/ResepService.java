package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;
import java.util.Optional;

public interface ResepService {
    void addResep(ResepModel resep);

    List<ResepModel> getResepList();

    Optional<ResepModel> getResepByNomorResep(Long noResep);

    ResepModel updateResep(ResepModel resepModel);

    void deleteResep(Long noResep);
}
