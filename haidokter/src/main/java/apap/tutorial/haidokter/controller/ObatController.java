package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addResepFormPage(
            @PathVariable Long noResep,
            Model model
    ) {
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep).get();
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";
    }

    @PostMapping("/obat/add")
    private String addObatSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ) {
        obatService.addObat(obat);
        model.addAttribute("nama", obat.getNama());

        return "add-obat";
    }

    @GetMapping("/obat/change/{idObat}")
    private String changeObatFormPage(
            @PathVariable Long idObat,
            Model model
    ) {
        ObatModel existingObat = obatService.getObatById(idObat);
        model.addAttribute("obat", existingObat);

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ) {
        ObatModel newObatData = obatService.changeObat(obat);
        model.addAttribute("obat", newObatData.getNama());

        return "update-obat";
    }

    @PostMapping(value="/obat/delete")
    public String deleteMenuFormSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        model.addAttribute("obatCount", resep.getListobat().size());
        for (ObatModel obat : resep.getListobat()) {
            obatService.deleteObatById(obat.getId());
        }
        return "delete-obat";
    }

    /*@GetMapping("/obat/delete/{idObat}")
    private String deleteObat(
            @PathVariable Long idObat,
            Model model
    ) {
        ObatModel obat = obatService.getObatById(idObat);
        model.addAttribute("obat", obat.getNama());
        obatService.deleteObatById(idObat);

        return "delete-obat";
    }*/
}
