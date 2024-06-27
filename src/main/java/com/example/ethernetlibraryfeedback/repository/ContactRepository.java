package com.example.ethernetlibraryfeedback.repository;

import com.example.ethernetlibraryfeedback.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
