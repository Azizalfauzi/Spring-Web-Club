package com.zuhaproject.web.mapper;

import com.zuhaproject.web.dto.EventDto;
import com.zuhaproject.web.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){
        return Event.builder().
                id(eventDto.getId()).
                name(eventDto.getName()).
                type(eventDto.getType()).
                photoUrl(eventDto.getPhotoUrl()).
                startTime(eventDto.getStartTime()).
                endTime(eventDto.getEndTime()).
                createdOn(eventDto.getCreatedOn()).
                updatedOn(eventDto.getUpdatedOn()).build();
    }
}
