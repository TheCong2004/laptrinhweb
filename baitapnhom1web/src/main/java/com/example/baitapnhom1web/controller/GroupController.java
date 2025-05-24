package com.example.baitapnhom1web.controller;

import com.example.baitapnhom1web.model.Group;
import com.example.baitapnhom1web.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    // Danh sách nhóm
    @GetMapping
    public String listGroups(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "groups";
    }

    // Chi tiết nhóm
    @GetMapping("/{id}")
    public String getGroupDetail(@PathVariable Long id, Model model) {
        Group group = groupRepository.findById(id).orElseThrow();
        model.addAttribute("group", group);
        return "detail";
    }

    // Form thêm nhóm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("group", new Group());
        return "group_form"; // form thêm/sửa dùng chung
    }

    // Xử lý thêm nhóm mới
    @PostMapping("/add")
    public String addGroup(@ModelAttribute Group group) {
        groupRepository.save(group);
        return "redirect:/groups";
    }

    // Form sửa nhóm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Group group = groupRepository.findById(id).orElseThrow();
        model.addAttribute("group", group);
        return "group_form";
    }

    // Xử lý sửa nhóm
    @PostMapping("/edit/{id}")
    public String editGroup(@PathVariable Long id, @ModelAttribute Group group) {
        group.setId(id);
        groupRepository.save(group);
        return "redirect:/groups";
    }

    // Xóa nhóm
    @GetMapping("/delete/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupRepository.deleteById(id);
        return "redirect:/groups";
    }
}
