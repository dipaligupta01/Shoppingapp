package com.example.user.project_test2;

import java.io.Serializable;

public class Product implements Serializable {
    private int pImage;
    private String pModel;
    private String pProcessor;
    private String pRam;
    private String pOs;
    private String pCamera;
    private String pDisplay;
    private String pPrice;

    public int getpImage() {
        return pImage;
    }

    public void setpImage(int pImage) {
        this.pImage = pImage;
    }

    public String getpModel() {
        return pModel;
    }

    public void setpModel(String pModel) {
        this.pModel = pModel;
    }

    public String getpProcessor() {
        return pProcessor;
    }

    public void setpProcessor(String pProcessor) {
        this.pProcessor = pProcessor;
    }

    public String getpRam() {
        return pRam;
    }

    public void setpRam(String pRam) {
        this.pRam = pRam;
    }

    public String getpOs() {
        return pOs;
    }

    public void setpOs(String pOs) {
        this.pOs = pOs;
    }

    public String getpCamera() {
        return pCamera;
    }

    public void setpCamera(String pCamera) {
        this.pCamera = pCamera;
    }

    public String getpDisplay() {
        return pDisplay;
    }

    public void setpDisplay(String pDisplay) {
        this.pDisplay = pDisplay;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }
}
