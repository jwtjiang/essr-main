package eley.model;

public class sysUser {
    private String ID;

    private String NAME;

    private String AGE;

    public sysUser(String id,String name,String age){
        this.ID = id;
        this.NAME = name;
        this.AGE = age;
    }
    public sysUser(){};
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }
}