package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ResepController {

    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model) {
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());

        return "add-resep";
    }

    @GetMapping({"/resep/change/{noResep}", "/resep/change"})
    private String changeResepFormPage(
            @PathVariable(required = false) Long noResep,
            Model model
    ) {
        if (noResep != null && isResepExists(noResep)) {
            ResepModel resep = resepService.getResepByNomorResep(noResep).get();
            model.addAttribute("resep", resep);

            return "form-update-resep";
        }
        model.addAttribute("msg", "Nomor Resep Tidak Ditemukan atau Nomor Resep Tidak Ada!");

        return "error";
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep);

        return "update-resep";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
            @RequestParam(value = "noResep") Long noResep,
            Model model
    ) {
        if (noResep != null && isResepExists(noResep)) {
            ResepModel resep = resepService.getResepByNomorResep(noResep).get();
            List<ObatModel> listobat = resep.getListobat();

            model.addAttribute("resep", resep);
            model.addAttribute("title", "Daftar Obat:");

            if (listobat.size() > 0) model.addAttribute("listobat", listobat);
            else model.addAttribute("title", "Resep belum memiliki daftar obat");

            return "view-resep";
        }
        model.addAttribute("msg", "Nomor Resep Tidak Ditemukan atau Nomor Resep Tidak Ada!");

        return "error";
    }

    @GetMapping("/resep/viewall")
    public String listResep(Model model) {
        List<ResepModel> listResep = resepService.getResepList();
        model.addAttribute("listResep", listResep);

        return "viewall-resep";
    }

    @GetMapping({"/resep/delete/no-resep/{noResep}", "/resep/delete/no-resep"})
    public String deleteResep(
            @PathVariable(value = "noResep", required = false) Long noResep,
            Model model
    ) {
        if (noResep != null) {
            if (isResepExists(noResep) && !hasObat(noResep)) {
                ResepModel resep = resepService.getResepByNomorResep(noResep).get();
                model.addAttribute("resep", resep);
                resepService.deleteResep(noResep);

                return "delete-resep";
            } else if (hasObat(noResep)) {
                model.addAttribute("msg", "Resep masih memiliki obat! Hapus obat terlebih dahulu!");

                return "error";
            }
        }
        model.addAttribute("msg", "Nomor Resep Tidak Ditemukan atau Nomor Resep Tidak Ada!");

        return "error";
    }

    private boolean isResepExists(Long noResep) {
        return resepService.getResepByNomorResep(noResep).isPresent();
    }

    private boolean hasObat(Long noResep) {
        return resepService.getResepByNomorResep(noResep).get().getListobat().size() != 0;
    }


    /*@Autowired
    private ResepService resepService;


    // routing url yang diinginkan
    @RequestMapping("/resep/add")
    public String addResep(
            // request param sesuai yang ingin dibawa
            @RequestParam(value = "noResep", required = true) String noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model
    ){
        // membuat sebuah objek ResepModel
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        // memanggil service addResep
        resepService.addResep(resep);

        // meng-add variabel dari nomor resep ke dalam "nomorResep" untuk dirender pada thymeleaf
        model.addAttribute("nomorResep", noResep);

        // return view "add-resep"
        return "add-resep";
    }

    @RequestMapping("/resep/viewall")
    public String listResep(Model model){
        // mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();

        // menambahkan variabel dari semua ResepModel ke "listResep" yang akan dirender ke thymeleaf
        model.addAttribute("listResep", listResep);

        // mereturn view template
        return "viewall-resep";
    }

    // melakukan routing URL untuk dapat melihat detail dari resep
    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") String noResep,
            Model model
    ){
        // mendapatkan ResepModel yang sesuai dengan nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        // meng-add variabel dari ResepModel ke dalam resep yang akan dirender pada thymeleaf
        model.addAttribute("resep", resep);

        // mereturn view template
        return "view-resep";
    }


    @GetMapping(value = "/resep/add/{noResep}/{namaDokter}/{namaPasien}/{catatan}")
    public String addResepPath(
            // request param sesuai yang ingin dibawa
            @PathVariable(value = "noResep", required = true) String noResep,
            @PathVariable(value = "namaDokter", required = true) String namaDokter,
            @PathVariable(value = "namaPasien", required = true) String namaPasien,
            @PathVariable(value = "catatan", required = true) String catatan,
            Model model
    ){
        // membuat sebuah objek ResepModel
        ResepModel resepPath = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        // memanggil service addResep
        resepService.addResep(resepPath);

        // meng-add variabel dari nomor resep ke dalam "nomorResep" untuk dirender pada thymeleaf
        model.addAttribute("nomorResep", noResep);

        // return view "add-resep"
        return "add-resep";
    }

    @GetMapping(value = "/resep/view/no-resep/{noResep}")
    public String detailResepWithPathVariable(
            @PathVariable(value = "noResep", required = true) String noResep,
            Model model
    ){
        ResepModel resepPath = resepService.getResepByNomorResep(noResep);

        model.addAttribute("resepPath", resepPath);

        return "view-resepPath";
    }

    @RequestMapping(value = "/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String editResepPath(
            @PathVariable(value = "noResep", required = true) String noResep,
            @PathVariable(value = "catatan", required = true) String catatan,
            Model model
    ){
        ResepModel resepPath = resepService.getResepByNomorResep(noResep);

        resepPath.setCatatan(catatan);

        model.addAttribute("resepPath", resepPath);

        return "view-resepPath";
    }

    @RequestMapping(value = "/resep/delete/no-resep/{no-resep}")
    public String deleteResepPath(
            @PathVariable(value = "noResep", required = true) String noResep,
            Model model
    ){
        ResepModel resepPath = resepService.getResepByNomorResep(noResep);

        resepService.deleteResep(resepPath);

        List<ResepModel> listResep = resepService.getResepList();

        model.addAttribute("resepPath", resepPath);

        return "viewall-resep";
    }*/
}
