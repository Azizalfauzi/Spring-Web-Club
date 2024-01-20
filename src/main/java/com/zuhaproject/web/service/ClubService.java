package com.zuhaproject.web.service;

import com.zuhaproject.web.dto.ClubDto;
import com.zuhaproject.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(long clubId);
}
