package com.khariit.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "FORMS")
public class Form {

    @Id
    @GeneratedValue
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

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
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
        return Objects.equals(id, form.id) && Objects.equals(root, form.root) && Objects.equals(formVer, form.formVer) && Objects.equals(engDef, form.engDef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, root, formVer, engDef);
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", root=" + root +
                ", formVer='" + formVer + '\'' +
                ", engDef='" + engDef + '\'' +
                '}';
    }
}
