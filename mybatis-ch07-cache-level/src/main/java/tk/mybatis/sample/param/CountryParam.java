package tk.mybatis.sample.param;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryParam {
    private String countryname;
    private String countrycode;

//    public String getContryname() {
//        return contryname;
//    }
//
//    public void setContryname(String contryname) {
//        this.contryname = contryname;
//    }
//
//    public void setCountrycode(String countrycode) {
//        this.countrycode = countrycode;
//    }
//
//    public String getCountrycode() {
//        return countrycode;
//    }
}
