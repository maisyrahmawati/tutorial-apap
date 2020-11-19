package apap.tutorial.haidokter.restcontroller;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/api/v1")
public class HospitalRestController {
    private final String url = "http://www.communitybenefitinsight.org/api/get_hospitals.php";
    public void read(@Valid @RequestBody String url, BindingResult bindingResult) {
        try {
            if (bindingResult.hasFieldErrors()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
                );
            } else {
                URL urls = new URL (url);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
