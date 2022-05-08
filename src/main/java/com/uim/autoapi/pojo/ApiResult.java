package com.uim.autoapi.pojo;

import lombok.Data;

@Data
public class ApiResult {
    private int no;
    private String casename;
    private String url;
    private String testversion;
    private String testresult;
    private String excutedate;
    private String description;

}
