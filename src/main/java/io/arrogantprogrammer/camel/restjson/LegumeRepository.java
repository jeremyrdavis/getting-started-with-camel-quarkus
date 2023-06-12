package io.arrogantprogrammer.camel.restjson;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LegumeRepository implements PanacheRepository<Legume> {
}
