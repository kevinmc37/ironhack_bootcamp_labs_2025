package com.ironhack.labjavajparelationshipsandinheritancees.demo;

import com.ironhack.labjavajparelationshipsandinheritancees.model.PublicRelations.Contact;
import com.ironhack.labjavajparelationshipsandinheritancees.model.PublicRelations.Name;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.ContactRepository;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.NameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicRelationsDataInitializer implements CommandLineRunner {
    private final ContactRepository contactRepository;
    private final NameRepository nameRepository;

    public PublicRelationsDataInitializer(ContactRepository contactRepository,
                                          NameRepository nameRepository) {
        this.contactRepository = contactRepository;
        this.nameRepository = nameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        Contact contact3 = new Contact();
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();

        name1.setFirstName("John");
        name1.setMiddleName("'Paco'");
        name1.setLastName("Doe");
        name1.setSalutation("Hi! They call me John Paquito.");

        name2.setFirstName("Pablo");
        name2.setMiddleName("Antonio");
        name2.setLastName("Devisa");
        name2.setSalutation("Hola, soy Pablo Antonio, llámame Pablo.");

        name3.setFirstName("Maria");
        name3.setMiddleName("Dolores");
        name3.setLastName("De La Huerta");
        name3.setSalutation("Ey.");

        contact1.setCompany("Ironhack");
        contact1.setTitle("Head Lead");
        contact1.setName(name1);

        contact2.setCompany(contact1.getCompany());
        contact2.setTitle("Manager");
        contact2.setName(name2);

        contact3.setCompany("Fresas S.A.");
        contact3.setTitle("Hortelana");
        contact3.setName(name3);

        contactRepository.saveAll(List.of(contact1, contact2, contact3));
        nameRepository.saveAll(List.of(name1, name2, name3));

        System.out.println("Contact data initialized");
    }
}
