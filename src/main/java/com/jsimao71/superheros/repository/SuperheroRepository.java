package com.jsimao71.superheros.repository;

import com.jsimao71.superheros.model.Superhero;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.repository.RepositoryBase2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SuperheroRepository extends org.einnovator.jpa.repository.RepositoryBase2<Superhero, Long> {
}
