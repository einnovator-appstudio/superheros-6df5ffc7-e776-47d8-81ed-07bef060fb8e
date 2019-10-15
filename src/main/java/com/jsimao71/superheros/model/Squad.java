package com.jsimao71.superheros.model;

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

public enum Squad {

    MARVEL("Marvel"), DC("DC");

    @Column()
    private String displayValue;

    private Squad(String displayValue) {
        this.displayValue = displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }
}
