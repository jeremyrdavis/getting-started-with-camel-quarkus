package io.arrogantprogrammer.camel.restjson;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Legume extends PanacheEntity {

    private String name;
    private String description;

    public Legume(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Legume() {
    }

    @Override
    public String toString() {
        return "Legume{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
