package com.example.reactor.demoreactor.model;

public class Person
{
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }
    public void setOld(Integer old) {
        this.old = old;
    }

    public Person(Integer id, String name, Integer old) {
        this.id = id;
        this.name = name;
        this.old = old;
    }

    private Integer id;
    private String name;
    private Integer old;

    @Override
    public String toString() {
        return "Persona:{ id: " + id +", name: '" + name + "', old: " + old + " }";
    }
}