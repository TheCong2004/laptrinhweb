package com.example.baitapnhom1web.controller;


import com.example.baitapnhom1web.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public String listGroups(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
            return "groups"; // trỏ tới templates/groups.html
    }
}
