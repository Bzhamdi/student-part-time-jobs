package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int note;
   @Column(nullable=false)
    private String studintcin;
   /* @JoinColumn(name = "studintcin", referencedColumnName = "cin")
    @ManyToOne(optional = false)
    private Student student;*/

    public long getId() {
        return id;
    }

    public skills(long id, String name, int note, String studintcin) {
        this.id = id;
        this.name = name;
        this.note = note;
       this.studintcin = studintcin;
      /*  this.student = student;*/
    }





    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getStudintcin() {
        return studintcin;
    }

    public void setStudintcin(String studintcin) {
        this.studintcin = studintcin;
    }
/*
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
*/
    public skills() {
    }
}
