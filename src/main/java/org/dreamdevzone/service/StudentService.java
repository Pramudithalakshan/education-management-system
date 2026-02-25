
package org.dreamdevzone.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.model.dto.StudentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    void add(StudentDto student);
    StudentDto get(Integer id);
    List<@NotNull StudentDto> getAll(Pageable pageable);
    void delete(Integer id);
    StudentDto update(StudentDto student, Integer id);
}
