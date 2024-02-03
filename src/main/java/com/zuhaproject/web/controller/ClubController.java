package com.zuhaproject.web.controller;

import com.zuhaproject.web.dto.ClubDto;
import com.zuhaproject.web.models.Club;
import com.zuhaproject.web.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClub();
        model.addAttribute("clubs", clubs);
        return "club-list";
    }

    @GetMapping("/clubs/detail/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "club-detail";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "club-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "club-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "club-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "club-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
    @GetMapping("clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId")long clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query")String query,Model model){
        List<ClubDto> clubs = clubService.searchClub(query);
        model.addAttribute("clubs",clubs);
        return "club-list";
    }
}
