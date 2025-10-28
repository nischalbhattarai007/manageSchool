package com.school.manageschool.repository;
import com.school.manageschool.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClassInfoRepository extends JpaRepository<ClassInfo, Long> {
    Optional<ClassInfo> findByClassNumberAndSection(String classNumber, String section);
}
