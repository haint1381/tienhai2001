package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class CodeBook {
    @Id
    private int id;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private int codeBook;
}
