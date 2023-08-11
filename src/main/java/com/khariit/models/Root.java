package com.khariit.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ROOT")
public class Root {
    @Id
    @SequenceGenerator(
            name = "root_id_sequence",
            sequenceName = "root_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "root_id_sequence"
    )

    public Integer id;
    @OneToMany(mappedBy = "root")
    private Set<Form> forms;
    private String letters;
    private String engLetters;
    private String verbNoun;



    public Root(Integer id, String letters, String engLetters, String verbNoun) {
        this.id = id;
        this.letters = letters;
        this.engLetters = engLetters;
        this.verbNoun = verbNoun;
    }

    public Root() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getEngLetters() {
        return engLetters;
    }

    public void setEngLetters(String engLetters) {
        this.engLetters = engLetters;
    }

    public String getVerbNoun() {
        return verbNoun;
    }

    public void setVerbNoun(String verbNoun) {
        this.verbNoun = verbNoun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Objects.equals(id, root.id) && Objects.equals(forms, root.forms) && Objects.equals(letters, root.letters) && Objects.equals(engLetters, root.engLetters) && Objects.equals(verbNoun, root.verbNoun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forms, letters, engLetters, verbNoun);
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", forms=" + forms +
                ", letters='" + letters + '\'' +
                ", engLetters='" + engLetters + '\'' +
                ", verbNoun='" + verbNoun + '\'' +
                '}';
    }
}

