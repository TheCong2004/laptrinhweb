package com.example.baitapnhom1web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`group`") // Escape tên bảng vì 'group' là keyword trong SQL
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "member_count", nullable = false)
    private int memberCount;

    // Constructors
    public Group() {
    }

    public Group(String name, String description, int memberCount) {
        this.name = name;
        this.description = description;
        this.memberCount = memberCount;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
