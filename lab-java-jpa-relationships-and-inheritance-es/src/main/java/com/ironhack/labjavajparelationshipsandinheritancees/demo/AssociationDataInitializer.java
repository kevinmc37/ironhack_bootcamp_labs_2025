package com.ironhack.labjavajparelationshipsandinheritancees.demo;

import com.ironhack.labjavajparelationshipsandinheritancees.enums.memberStatus;
import com.ironhack.labjavajparelationshipsandinheritancees.model.Association.Association;
import com.ironhack.labjavajparelationshipsandinheritancees.model.Association.Division;
import com.ironhack.labjavajparelationshipsandinheritancees.model.Association.Member;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.AssociationRepository;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.DivisionRepository;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AssociationDataInitializer implements CommandLineRunner {
        private final AssociationRepository associationRepository;
        private final DivisionRepository divisionRepository;
        private final MemberRepository memberRepository;

        public AssociationDataInitializer(AssociationRepository associationRepository,
                                          DivisionRepository divisionRepository,
                                          MemberRepository memberRepository) {
            this.associationRepository = associationRepository;
            this.divisionRepository = divisionRepository;
            this.memberRepository = memberRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            LocalDate nextYear = LocalDate.now().plusYears(1);
            Association association = new Association();
            association.setName("Dog's World Association");

            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();
            Member member4 = new Member();

            member1.setName("John Holder");
            member1.setStatus(memberStatus.ACTIVE);
            member1.setRenewalDate(nextYear);

            member2.setName("Mary Chaers");
            member2.setStatus(memberStatus.ACTIVE);
            member2.setRenewalDate(nextYear);

            member3.setName("Dick Doverson");
            member3.setStatus(memberStatus.ACTIVE);
            member3.setRenewalDate(nextYear);

            member4.setName("Franko Serna");
            member4.setStatus(memberStatus.LAPSED);
            member4.setRenewalDate(nextYear);

            Division division1 = new Division();
            Division division2 = new Division();
            Division division3 = new Division();
            Division division4 = new Division();
            Division division5 = new Division();
            Division division6 = new Division();
            Division division7 = new Division();

            division1.setName("Institute of Capillarity");
            division1.setDistrict("Barcelona");
            division1.setPresident(member1);

            division2.setName("Institute of Singularities");
            division2.setDistrict("Madrid");
            division1.setPresident(member3);

            division3.setName("Institute of Little Dogs");
            division3.setDistrict("Valencia");
            division1.setPresident(member1);

            division4.setName("Union of the Big Dogs");
            division4.setDistrict("Valencia");
            division1.setPresident(member1);

            division5.setName("University of Tasmania (Only for Dogs");
            division5.setDistrict("Tasmania");
            division1.setPresident(member2);

            division6.setName("Investigation Unit");
            division6.setDistrict("Madrid");
            division1.setPresident(member3);

            division7.setName("Center of Singular-Haired Dogs");
            division7.setDistrict("Tokyo");
            division1.setPresident(member4);

            member1.setDivisions(List.of(division1, division3, division4, division6));
            member2.setDivisions(List.of(division2, division5, division6, division7));
            member3.setDivisions(List.of(division2, division3, division6, division7));
            member4.setDivisions(List.of(division1, division4, division5, division7));

            division1.setMembers(List.of(member1, member4));
            division2.setMembers(List.of(member2, member3));
            division3.setMembers(List.of(member1, member3));
            division4.setMembers(List.of(member1, member4));
            division5.setMembers(List.of(member2, member4));
            division6.setMembers(List.of(member1, member2, member3));
            division7.setMembers(List.of(member2, member3, member4));

            division1.setAssociation(association);
            division2.setAssociation(association);
            division3.setAssociation(association);
            division4.setAssociation(association);
            division5.setAssociation(association);
            division6.setAssociation(association);
            division7.setAssociation(association);

            association.setDivisions(List.of(division1, division2, division3, division4,
                    division5, division6, division7));

            associationRepository.save(association);
            divisionRepository.saveAll(List.of(division1, division2, division3, division4,
                    division5, division6, division7));
            memberRepository.saveAll(List.of(member1, member2, member3, member4));

            System.out.println("Association, Divisions and Members created");
        }
}
