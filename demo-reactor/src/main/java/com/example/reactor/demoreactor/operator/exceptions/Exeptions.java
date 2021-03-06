package com.example.reactor.demoreactor.operator.exceptions;

import com.example.reactor.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Exeptions
{
    private static final Logger log = LoggerFactory.getLogger(Exeptions.class);

    public void retry(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ONE ERROR OCURRIED")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ONE ERROR OCURRIED")))
                .onErrorReturn(new Person(0, "XYZ", 99))
                .subscribe(p -> log.info(p.toString()));
    }

    public void errorResume(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ONE ERROR OCURRIED")))
                .onErrorResume(e -> Mono.just(new Person(0, "XYZ", 99)))
                .subscribe(p -> log.info(p.toString()));
    }

    public void errorMap(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ONE ERROR OCURRIED")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(p -> log.info(p.toString()));
    }
}
