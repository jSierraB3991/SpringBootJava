package com.example.reactor.demoreactor.operator.creation;

import com.example.reactor.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Creation
{
    private static final Logger log = LoggerFactory.getLogger(Creation.class);

    public void justFrom(List<Person> personas)
    {
        reactor();
        flux(personas);
        fluxMono(personas);
    }

    // Stream empty
    public void empty(){
        Mono.empty();
        Flux.empty();
        // Observable.empty();
    }

    // Stream of data for range
    public void range()
    {
        Flux.range(5, 10)
            .doOnNext(p -> log.info("p: " + p))
        .subscribe();
    }

    public void repeat(List<Person> personas)
    {
        Flux.fromIterable(personas)
                .repeat(2)
                .subscribe(p -> log.info("Flux Repeat : " + p.toString()));

        Mono.just(new Person(1, "Juan David", 27))
                .repeat(1)
                .subscribe(p -> log.info("Mono Repeat : " + p.toString()));
    }

    // Mono represent to stream of one element
    private void reactor()
    {
        Mono.just(new Person(1, "Juan David", 27))
                .doOnNext(p -> {
                    //for more line of code
                    log.info("Mono: " + p.toString());
                }) //for debug
                .subscribe();
		/*
		in RxJava2
		Observable.just(new Persona(1, "Juan David", 27))
				.doOnNext(p -> log.info(p.toString()))
				.subscribe(p -> log.info(p.toString()));
		* */
    }

    // Reactor for more one element
    private void flux(List<Person> personas)
    {
        Flux.fromIterable(personas)
                .subscribe(p -> log.info("FLUX:{" + p.getId() + "}: " + p.toString()));
    }

    private void fluxMono(List<Person> personas){

        Flux.fromIterable(personas)
                .collectList()
                .subscribe(lista -> log.info("FluxMono: " +  lista.toString()));
    }
}
