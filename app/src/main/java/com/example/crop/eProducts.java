package com.example.crop;

public class eProducts {

    private String eproductId;
    private String eproductName;
    private String edate;
    private float eprice;
    private float ekg;

    public  eProducts(){

    }

    public eProducts(String eproductId, String eproductName, String edate, float eprice, float ekg) {
        this.eproductId = eproductId;
        this.eproductName = eproductName;
        this.edate = edate;
        this.eprice = eprice;
        this.ekg = ekg;
    }

    public String getEproductId() {
        return eproductId;
    }

    public String getEproductName() {
        return eproductName;
    }

    public String getEdate() {
        return edate;
    }

    public float getEprice() {
        return eprice;
    }

    public float getEkg() {
        return ekg;
    }

    public void setEproductId(String eproductId) {
        this.eproductId = eproductId;
    }

    public void setEproductName(String eproductName) {
        this.eproductName = eproductName;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public void setEprice(float eprice) {
        this.eprice = eprice;
    }

    public void setEkg(float ekg) {
        this.ekg = ekg;
    }
}

