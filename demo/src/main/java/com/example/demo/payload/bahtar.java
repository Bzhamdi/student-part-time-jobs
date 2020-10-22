/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.payload;

/**
 *
 * @author hamdi
 */
public class bahtar {
    private String nom;
	private String pr;
	private String password;
	private String type;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public bahtar(String nom, String pr, String password, String type) {
        this.nom = nom;
        this.pr = pr;
        this.password = password;
        this.type = type;
    }

    public bahtar(String nom, String pr, String password, String type, String fileName, String fileDownloadUri, String fileType, long size) {
        this.nom = nom;
        this.pr = pr;
        this.password = password;
        this.type = type;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getNom() {
        return nom;
    }

    public bahtar() {
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        
}
