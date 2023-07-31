package com.khariit.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "FORMS")
public class Form {

    @Id
    @SequenceGenerator(
            name = "form_id_sequence",
            sequenceName = "form_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "form_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="root_id", nullable = false)
    private Root root;

    private String formVer;
    private String engDef;

    public Form(Integer id, String formVer, String engDef, Integer rootId) {
        this.id = id;
        this.formVer = formVer;
        this.engDef = engDef;
        this.root.id = rootId;
    }

    public Form() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getRootId() {
        return root.id;}

    public void setRootId(Integer root_id) {
        this.root.id = root_id;
    }

    public String getFormVer() {
        return formVer;
    }

    public void setFormVer(String formVer) {
        this.formVer = formVer;
    }

    public String getEngDef() {
        return engDef;
    }
    public void setEngDef(String engDef) {
        this.engDef = engDef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return Objects.equals(id, form.id) && Objects.equals(formVer, form.formVer) && Objects.equals(engDef, form.engDef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formVer, engDef);
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", formVer='" + formVer + '\'' +
                ", engDef='" + engDef + '\'' +
                '}';
    }
}
