package com.example.reactor.demoreactor;

import com.example.reactor.demoreactor.model.Person;
import com.example.reactor.demoreactor.operator.conditionals.Conditionals;
import com.example.reactor.demoreactor.operator.exceptions.Exeptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner
{
	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Mito", 27));
		persons.add(new Person(1, "Code", 28));
		persons.add(new Person(2, "Jaime", 29));
		persons.add(new Person(3, "Juan", 30));

		Conditionals app = new Conditionals();
		app.timeOut(persons);
	}
}
