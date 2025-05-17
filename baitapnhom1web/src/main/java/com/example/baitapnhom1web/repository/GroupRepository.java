package com.example.baitapnhom1web.repository;
import com.example.baitapnhom1web.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository để làm việc với cơ sở dữ liệu
public interface GroupRepository extends JpaRepository<Group, Long> {
}
