package com.zuhaproject.web.service;

import com.zuhaproject.web.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
