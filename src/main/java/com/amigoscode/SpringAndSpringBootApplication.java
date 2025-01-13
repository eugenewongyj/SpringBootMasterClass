package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class SpringAndSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAndSpringBootApplication.class, args);
	}

	public enum Gender { MALE, FEMALE }

	public record Person(int id, String name, int age, Gender gender) {

	}

	public static List<Person> people = new ArrayList<>();

	static {
		people.add(new Person(1, "John", 20, Gender.MALE));
		people.add(new Person(2, "Mariam", 18, Gender.FEMALE));
		people.add(new Person(3, "Samba", 30, Gender.MALE));
	}

	@GetMapping
	public List<Person> getPersons() {
		return people;
	}

	@GetMapping("/{id}")
	public Optional<Person> getPersonById(@PathVariable("id") Integer id) {
		return people.stream().filter(person -> person.id == id).findFirst();
	}

}
