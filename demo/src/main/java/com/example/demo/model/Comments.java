package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String comment;
    private int note;
    @Column(nullable=false)
    private  String stuudentid;
    @Column(nullable=false)
    private String companyid;

    public Comments() {
    }

    public Comments(long id, String comment, int note, String stuudentid, String companyid) {
        this.id = id;
        this.comment = comment;
        this.note = note;
        this.stuudentid = stuudentid;
        this.companyid = companyid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getStuudentid() {
        return stuudentid;
    }

    public void setStuudentid(String stuudentid) {
        this.stuudentid = stuudentid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }
}
