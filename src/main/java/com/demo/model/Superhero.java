package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.einnovator.util.model.ToStringCreator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class Superhero {

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private String villain;

    public Superhero() {
        super();
    }

    public Superhero(Object obj) {
        super(obj);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setVillain(String villain) {
        this.villain = villain;
    }

    public String getVillain() {
        return this.villain;
    }

    @Override()
    public void toString0(ToStringCreator creator) {
        return super.toString0(creator);
    }

    @Override()
    public void toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("name", name)
                    .append("description", description)
                    .append("villain", villain);
    }

    @Override()
    public void toString2(ToStringCreator creator) {
        return super.toString2(creator);
    }
}
