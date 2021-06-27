package com.example.daoyun.domain;

import org.apache.catalina.filters.ExpiresFilter;

public class System {
    public static ExpiresFilter.XServletOutputStream out;
    private int id;
    private String pname;
    private String pkey;
    private String pvalue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }
}
