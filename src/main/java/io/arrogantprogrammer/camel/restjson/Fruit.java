package io.arrogantprogrammer.camel.restjson;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Fruit extends PanacheEntity {

    private String name;
    private String description;

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Fruit() {
    }

    @Override
    public String toString() {
        return "Fruit{" +
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
