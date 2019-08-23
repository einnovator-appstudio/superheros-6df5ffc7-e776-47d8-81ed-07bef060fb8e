package com.demo.repository;

import com.demo.model.Superhero;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.repository.ManagerBase2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SuperheroManager implements org.einnovator.jpa.repository.ManagerBase2<Superhero, Long> {

    public Page<Superhero> findAll(SuperheroFilter filter, Pageable pageable) {
    }

    public long count(SuperheroFilter filter) {
    }

    public void populate() {
    }

    public void populate(Boolean force) {
    }

    public void populateJson(String resource) {
    }

    public void populateXml(String resource) {
    }

    public void populateXls(String resource) {
    }
}
