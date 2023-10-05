package com.example.demo.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    public UserCommandLineRunner(UserDetailsRepository repository) {
        super();
        this.repository = repository;
    }

    // Object to Log info in the console
    /*Logger logger = LoggerFactory.getLogger(getClass());*/

    private final UserDetailsRepository repository;

    // Runs automatically the following code when program starts
    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************+ Starting Execution Code ***********************");

        repository.save(new UserDetails("Vini", "Admin"));
        repository.save(new UserDetails("Billy Whats", "Admin"));
        repository.save(new UserDetails("Patola", "User"));

        List<UserDetails> users = repository.findByRole("Admin");

        users.forEach(user -> System.out.println(user.toString()));
    }
}
