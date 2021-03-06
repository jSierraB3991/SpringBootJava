package com.example.reactor.demoreactor.operator.filter;

import com.example.reactor.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter
{
    private static final Logger log = LoggerFactory.getLogger(Filter.class);

    public void filter(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .filter(p -> p.getOld() > 28)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .distinct(Person::getId)
                .subscribe(p -> log.info(p.toString()));

        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(1);list.add(2);list.add(3);
        Flux.fromIterable(list)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .take(1)
                .subscribe(p -> log.info("Take: " + p.toString()));
        takeLast(persons);
    }

    private void takeLast(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .takeLast(1)
                .subscribe(p -> log.info("TakeLast: " +  p.toString()));
    }

    public void skip(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .skip(1)
                .subscribe(p -> log.info("Skip: " + p.toString()));
        skipLast(persons);
    }

    private void skipLast(List<Person> persons)
    {
        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(p -> log.info("Skip Last: " + p.toString()));
    }
}
