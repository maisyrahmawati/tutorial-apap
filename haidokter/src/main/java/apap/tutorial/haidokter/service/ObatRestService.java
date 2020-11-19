package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;

import java.util.List;

public interface ObatRestService {
    ObatModel createObat(ObatModel obat);

    ObatModel changeObat(Long id, ObatModel obatUpdate);

    ObatModel getObatById(Long id);

    List<ObatModel> retrieveListObat();

    void deleteObat(Long id);
}
