package apap.tutorial.haidokter.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObatDetail {
    private String status;

    @JsonProperty("obat-license")
    private Integer obatLicense;

    @JsonProperty("obat-valid-until")
    private Date obatValidUntil;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getObatLicense() {
        return obatLicense;
    }

    public void setObatLicense(Integer obatLicense) {
        this.obatLicense = obatLicense;
    }

    public Date getObatValidUntil() {
        return obatValidUntil;
    }

    public void setObatValidUntil(Date obatValidUntil) {
        this.obatValidUntil = obatValidUntil;
    }
}
