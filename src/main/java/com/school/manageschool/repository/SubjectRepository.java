package com.school.manageschool.repository;
import com.school.manageschool.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface SubjectRepository extends JpaRepository<subject, Long> {
    Optional<subject> findByName(String name);
}
