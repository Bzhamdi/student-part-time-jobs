/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author hamdi
 */
@Entity
@Table(name = "bahta")
public class bahta {
    @Id
    private String nom;
	private String pr;
	private String password;
	private String type;
        @Lob
    private byte[] cv;
        @Lob
    private byte[] ph;
        /*************new****/
        private String fileName;

    private String fileType;
    /*****************/

    public bahta(String nom, String pr, String password, String type, byte[] data) {
        this.nom = nom;
        this.pr = pr;
        this.password = password;
        this.type = type;
       
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getCv() {
        return cv;
    }

    public bahta(String nom, String pr, String password, String type, byte[] cv, byte[] ph) {
        this.nom = nom;
        this.pr = pr;
        this.password = password;
        this.type = type;
        this.cv = cv;
        this.ph = ph;
    }

    public bahta(String nom, String pr, String password, String type, byte[] cv, byte[] ph, String fileName, String fileType) {
        this.nom = nom;
        this.pr = pr;
        this.password = password;
        this.type = type;
        this.cv = cv;
        this.ph = ph;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getPh() {
        return ph;
    }

    public void setPh(byte[] ph) {
        this.ph = ph;
    }

    

    public bahta() {
    }

    
}
