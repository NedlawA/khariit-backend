package com.khariit;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
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
    private Integer id;
    private String letters;
    private String engLetters;

    public Root(Integer id, String letters, String eng_letters) {
        this.id = id;
        this.letters = letters;
        this.engLetters = eng_letters;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Objects.equals(id, root.id) && Objects.equals(letters, root.letters) && Objects.equals(engLetters, root.engLetters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, letters, engLetters);
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", letters='" + letters + '\'' +
                ", eng_def='" + engLetters + '\'' +
                '}';
    }
}

