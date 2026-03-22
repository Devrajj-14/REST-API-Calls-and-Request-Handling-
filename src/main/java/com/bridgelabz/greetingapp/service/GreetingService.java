package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreeting() {
        return "Hello World";
    }

    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello " + firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello " + lastName;
        }
        return "Hello World";
    }

    public Greeting saveGreeting(String firstName, String lastName) {
        String message = getGreeting(firstName, lastName);
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String message) {
        Greeting greeting = findGreetingById(id);
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }
}
