package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ResepInMemoryService implements ResepService {
    private List<ResepModel> listResep;

    // Constructor
    public ResepInMemoryService(){
        listResep = new ArrayList<>();
    }

    @Override
    public void addResep(ResepModel resep){
        listResep.add(resep);
    }

    /*@Override
    public void deleteResep(ResepModel resep){
        listResep.remove(resep);
    }*/

    @Override
    public List<ResepModel> getResepList(){
        return listResep;
    }

    @Override
    public Optional<ResepModel> getResepByNomorResep(Long noResep) {
        return null;
    }

    @Override
    public ResepModel updateResep(ResepModel resepModel) {
        return null;
    }

    @Override
    public void deleteResep(Long noResep) {

    }

    /*@Override
    public ResepModel getResepByNomorResep(String nomorResep){
        //ResepModel i;
        for(ResepModel i : listResep){
            if(nomorResep.equals(i.getNoResep())){
                return i;
            }
            else{
                return null;
            }
        }
        return null;
    }*/
}
