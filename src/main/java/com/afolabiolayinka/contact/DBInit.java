package com.afolabiolayinka.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import com.afolabiolayinka.contact.repository.ContactRepository;
import com.afolabiolayinka.contact.entity.Contact;

@Component
public class DBInit {
    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    private void postConstruct() {

        // Preload contacts
        Contact contact1 = new Contact(1L, "Olayinka","Afolabi","Adedeji","hello@afolabiolayinka.com","+234803000000");
        Contact contact2 = new Contact(2L, "Doe","John","","johndoe@example.com","+234803100000");
        Contact contact3 = new Contact(3L, "Doe","Jane","","janedoe@example.com","+234803200000");

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);

    }
}
