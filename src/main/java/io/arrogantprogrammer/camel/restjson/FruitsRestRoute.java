package io.arrogantprogrammer.camel.restjson;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

@ApplicationScoped
public class FruitsRestRoute extends RouteBuilder {

    @Inject
    FruitRepository fruitRepository;

    @Inject
    LegumeRepository legumeRepository;

    @Override @Transactional
    public void configure() throws Exception {

        restConfiguration().bindingMode(RestBindingMode.json);

        rest("/fruits")
                .get()
                .to("direct:getFruits")

                .post()
                .type(Fruit.class)
                .to("direct:addFruit");

        rest("/legumes")
                .get()
                .to("direct:getLegumes");

        from("direct:getFruits")
                .setBody().method("FruitRepository", "listAllFruits");

        from("direct:addFruit")
                .process().body(Fruit.class, fruitRepository::persistFruit)
                .setBody().method("FruitRepository", "listAllFruits");

        from("direct:getLegumes")
                .setBody().constant(legumeRepository.listAll());
    }
}
