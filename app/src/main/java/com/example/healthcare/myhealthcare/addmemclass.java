package com.example.healthcare.myhealthcare;

public class addmemclass {

    String memID;
    String memname;
    String memrelation ;
    String memage ;
    String memgender;
    String memblood ;
    String memnumber;
    String mempres;
    public addmemclass(){

    }

    public addmemclass(String memID, String memname, String memrelation, String memage, String memgender, String memblood, String memnumber, String mempres) {
        this.memID = memID;
        this.memname = memname;
        this.memrelation = memrelation;
        this.memage = memage;
        this.memgender = memgender;
        this.memblood = memblood;
        this.memnumber = memnumber;
        this.mempres = mempres;
    }

    public String getMemID() {
        return memID;
    }

    public String getMemname() {
        return memname;
    }

    public String getMemrelation() {
        return memrelation;
    }

    public String getMemage() {
        return memage;
    }

    public String getMemgender() {
        return memgender;
    }

    public String getMemblood() {
        return memblood;
    }

    public String getMemnumber() {
        return memnumber;
    }

    public String getMempres() {
        return mempres;
    }
}
