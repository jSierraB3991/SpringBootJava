package com.example.reactor.demoreactor.operator.combination;

import com.example.reactor.demoreactor.model.Person;
import com.example.reactor.demoreactor.model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combination
{
    private static final Logger log = LoggerFactory.getLogger(Combination.class);

    public void merge(List<Person> persons)
    {
        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Jose", 31));
        persons2.add(new Person(4, "Carlos", 32));
        persons2.add(new Person(5, "Willbert", 33));
        persons2.add(new Person(6, "Ricardo", 34));

        List<Sale> ventas = new ArrayList<>();
        ventas.add(new Sale(1, LocalDateTime.now()));
        ventas.add(new Sale(2, LocalDateTime.now()));

        Flux.merge(Flux.fromIterable(persons),
                Flux.fromIterable(persons2),
                Flux.fromIterable(ventas))
                .subscribe(p -> log.info("Merge: " + p.toString()));
    }

    public void zip(List<Person> persons)
    {
        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Jose", 31));
        persons2.add(new Person(4, "Carlos", 32));
        persons2.add(new Person(5, "Willbert", 33));
        persons2.add(new Person(6, "Ricardo", 34));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDateTime.now()));
        sales.add(new Sale(2, LocalDateTime.now()));
        sales.add(new Sale(3, LocalDateTime.now()));
        sales.add(new Sale(4, LocalDateTime.now()));

        Flux.zip(Flux.fromIterable(persons),
                Flux.fromIterable(persons2),
                (p1, p2) -> String.format("FLux 1: %s, Flux 2: %s", p1, p2))
             .subscribe(p -> log.info(p));

        Flux.zip(Flux.fromIterable(persons),
                Flux.fromIterable(persons2),
                Flux.fromIterable(sales))
             .subscribe(p -> log.info("Zip: " + p.toString()));

        Flux.fromIterable(persons)
            .zipWith(Flux.fromIterable(sales),
                    (p1, v1) -> String.format("FLuxWith: %s, %s", p1, v1))
             .subscribe(p -> log.info(p));
    }
}
