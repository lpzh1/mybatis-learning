package tk.mybatis.sample.model;

import lombok.Data;

@Data
public class SysDict {

    private Long id;
    private String code;
    private String name;
    private String value;

}
