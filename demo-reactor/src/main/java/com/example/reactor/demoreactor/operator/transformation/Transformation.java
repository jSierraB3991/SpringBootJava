package com.example.reactor.demoreactor.operator.transformation;

import com.example.reactor.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Transformation
{
    private static final Logger log = LoggerFactory.getLogger(Transformation.class);

    public void map(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .map(p -> {
                    p.setOld(p.getOld() + 10);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));

        Flux.range(0 ,10)
                .map(p -> p + 10)
                .subscribe(p -> log.info("p: " + p.toString()));
    }

    public void flatMap(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .flatMap(p ->{
                    p.setOld(p.getOld() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .groupBy(Person::getId)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(p -> log.info(p.toString()));
    }
}
