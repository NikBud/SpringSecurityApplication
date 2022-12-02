package com.budeanski.springCourse.SpringSecurityApp.services;

import com.budeanski.springCourse.SpringSecurityApp.models.Person;
import com.budeanski.springCourse.SpringSecurityApp.repositories.PeopleRepository;
import com.budeanski.springCourse.SpringSecurityApp.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found! Recheck your login and try again. Thank you!");

        return new PersonDetails(person.get());
    }
}
