package com.ironhack.labjavajparelationshipsandinheritancees.demo;

import com.ironhack.labjavajparelationshipsandinheritancees.enums.guestStatus;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Conference;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Event;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Exhibition;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Guest;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Speaker;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EventDataInitializer implements CommandLineRunner {
    private final EventRepository eventRepository;
    private final ConferenceRepository conferenceRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final GuestRepository guestRepository;
    private final SpeakerRepository speakerRepository;

    public EventDataInitializer(EventRepository eventRepository,
                                ConferenceRepository conferenceRepository,
                                ExhibitionRepository exhibitionRepository,
                                GuestRepository guestRepository,
                                SpeakerRepository speakerRepository) {
        this.eventRepository = eventRepository;
        this.conferenceRepository = conferenceRepository;
        this.exhibitionRepository = exhibitionRepository;
        this.guestRepository = guestRepository;
        this.speakerRepository = speakerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate nextYear = LocalDate.now().plusYears(1);

        Event event = new Event();
        Conference conference = new Conference();
        Exhibition exhibition = new Exhibition();

        event.setTitle("Event");
        event.setDate(nextYear);
        event.setDuration(60); // In minutes
        event.setLocation("Your house.");

        conference.setTitle("Conference");
        conference.setDate(nextYear);
        conference.setDuration(60);
        conference.setLocation("Manhattan");

        exhibition.setTitle("Exhibition");
        exhibition.setDate(nextYear);
        exhibition.setDuration(60);
        exhibition.setLocation("Bahamas");
        exhibition.setDescription("We will dance in the beach.");

        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Speaker speaker = new Speaker();

        guest1.setName("John Morrison");
        guest1.setStatus(guestStatus.NOT_ATTENDING);

        guest2.setName("Jessica Parlon");
        guest2.setStatus(guestStatus.NO_RESPONSE);

        speaker.setName("Christina Nice");
        speaker.setStatus(guestStatus.ATTENDING);
        speaker.setPresentationDuration(60); // In minutes

        event.setGuests(List.of(guest1, guest2));

        conference.setGuests(List.of(guest2));
        conference.setSpeakers(List.of(speaker));

        exhibition.setGuests(List.of(guest1, speaker));

        eventRepository.save(event);
        conferenceRepository.save(conference);
        exhibitionRepository.save(exhibition);
        guestRepository.saveAll(List.of(guest1, guest2));
        speakerRepository.saveAll(List.of(speaker));

        System.out.println("Events and Guests have been initialized");
    }
}
