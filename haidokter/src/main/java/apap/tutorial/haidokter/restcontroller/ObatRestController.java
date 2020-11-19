package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.service.ObatRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class ObatRestController {
    @Autowired
    private ObatRestService obatRestService;

    @PostMapping(value = "/obat")
    private ObatModel createObat(@Valid @RequestBody ObatModel obat, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else {
            return obatRestService.createObat(obat);
        }
    }

    @PutMapping(value = "/obat/{id}")
    private ObatModel updateObat(@PathVariable(value = "id") Long id, @RequestBody ObatModel obat) {
        try {
            return obatRestService.changeObat(id, obat);
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(id) + " not found!"
            );
        }
    }

    @GetMapping(value = "/obat/{id}")
    private ObatModel retrieveObat(@PathVariable(value = "id") Long id) {
        try {
            return obatRestService.getObatById(id);
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(id) + " not found!"
            );
        }
    }

    @GetMapping(value = "/obat-all")
    private List<ObatModel> retrieveListObat() {
        return obatRestService.retrieveListObat();
    }

    @DeleteMapping(value = "/obat/{id}")
    private ResponseEntity<String> deleteObat(@PathVariable("id") Long id) {
        try {
            obatRestService.deleteObat(id);
            return ResponseEntity.ok("Obat with Id " + String.valueOf(id) + " has been deleted!");
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(id) + " not found!"
            );
        }
    }
}
