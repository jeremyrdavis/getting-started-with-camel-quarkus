package io.arrogantprogrammer.camel.restjson;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped @Named("FruitRepository")
public class FruitRepository implements PanacheRepository<Fruit> {

    static final Logger LOGGER = LoggerFactory.getLogger(FruitRepository.class);
    @Transactional
    public void persistFruit(Fruit fruit) {
        LOGGER.debug("persisting: {}", fruit);
        this.persist(fruit);
    }

    @Transactional
    public List<Fruit> listAllFruits() {
        return this.listAll();
    }
}
