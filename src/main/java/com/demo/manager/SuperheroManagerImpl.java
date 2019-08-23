package com.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import com.demo.model.Superhero;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.manager.ManagerBaseImpl3;
import org.einnovator.jpa.repository.ManagerBase2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SuperheroManagerImpl extends org.einnovator.jpa.repository.ManagerBase2<Superhero, Long> implements SuperheroManager {

    public final String SUPERHERO_RESOURCE_JSON = "data/Superhero.json";

    public final String SUPERHERO_RESOURCE_XML = "data/Superhero.xml";

    public final String SUPERHERO_RESOURCE_XLS = "data/Superhero.xls";

    @Autowired()
    private SuperheroRespository repository;

    private boolean init;

    public nullRepository getRepository() {
        return repository;
    }

    public Page<Superhero> findAll(SuperheroFilter filter, Pageable pageable) {
        populate();
        page = null;
        ;
        if (page == null)
            page = repository.findAll(pageable);
        else
            ;
        return processAfterLoad(page);
    }

    public long count(SuperheroFilter filter) {
        ;
        repository.count();
    }

    public void populate() {
        populate(false);
    }

    public void populate(Boolean force) {
        if (force || !init) {
            init = true;
            if (!force && repository.count() != 0)
                return;
            else
                ;
            populateJson("SUPERHERO_RESOURCE_JSON");
        } else
            ;
    }

    public void populateJson(String resource) {
        Superhero[] data;
        data = MappingUtils.readJson(new ClassPathResource(resource), Superhero[]);
        createOrUpdate(Arrays.asList(data));
    }

    public void populateXml(String resource) {
        ;
    }

    public void populateXls(String resource) {
        ;
    }
}
