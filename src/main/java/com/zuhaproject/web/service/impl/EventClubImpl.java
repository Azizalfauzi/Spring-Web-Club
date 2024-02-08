package com.zuhaproject.web.service.impl;

import com.zuhaproject.web.dto.EventDto;
import com.zuhaproject.web.models.Club;
import com.zuhaproject.web.models.Event;
import com.zuhaproject.web.repository.ClubRepository;
import com.zuhaproject.web.repository.EventRepository;
import com.zuhaproject.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zuhaproject.web.mapper.EventMapper.mapToEvent;

@Service
public class EventClubImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    public EventClubImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }



}
