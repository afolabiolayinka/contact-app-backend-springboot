package com.afolabiolayinka.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.afolabiolayinka.contact.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {


}