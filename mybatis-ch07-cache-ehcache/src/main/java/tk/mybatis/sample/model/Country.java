package tk.mybatis.sample.model;


import lombok.Data;

@Data
public class Country {
    private Long id;
    private String countryname;
    private String countrycode;
}
