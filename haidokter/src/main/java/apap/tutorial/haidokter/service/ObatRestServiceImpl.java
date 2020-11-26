package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import apap.tutorial.haidokter.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ObatRestServiceImpl implements ObatRestService {
    private final WebClient webClient;

    @Autowired
    private ObatDb obatDb;

    @Override
    public ObatModel createObat(ObatModel obat) {
        return obatDb.save(obat);
    }

    @Override
    public ObatModel changeObat(Long id, ObatModel obatUpdate) {
        ObatModel obat = getObatById(id);
        obat.setNama(obatUpdate.getNama());
        obat.setBentuk(obatUpdate.getBentuk());
        obat.setKuantitas(obatUpdate.getKuantitas());
        return obatDb.save(obat);
    }

    @Override
    public ObatModel getObatById(Long id) {
        ObatModel obat = obatDb.findObatModelById(id);
        if (obat != null) {
            return obat;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<ObatModel> retrieveListObat() {
        return obatDb.findAll();
    }

    @Override
    public void deleteObat(Long id) {
        obatDb.deleteById(id);
    }

    public ObatRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.obatUrl).build();
    }
}
