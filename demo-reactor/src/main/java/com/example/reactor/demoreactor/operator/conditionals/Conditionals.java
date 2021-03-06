package com.example.reactor.demoreactor.operator.conditionals;

import com.example.reactor.demoreactor.model.Person;
import com.sun.deploy.perf.PerfRollup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Conditionals
{
    private static final Logger log = LoggerFactory.getLogger(Conditionals.class);

    public void defaultIfEmpty()
    {
        Mono.just(new Person(1, "Juan",  27))
        //Mono.empty()
             .defaultIfEmpty(new Person(0, "default", 99))
             .subscribe(p -> log.info(p.toString()));
    }

    public void takeUntil(List<Person> personList)
    {
        Flux.fromIterable(personList)
                .takeUntil(p -> p.getOld() > 27)
                .subscribe(p -> log.info(p.toString()));
    }

    public void timeOut(List<Person> personList) throws InterruptedException
    {
        Flux.fromIterable(personList)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(p -> log.info(p.toString()));
        Thread.sleep(10000);
    }
}
