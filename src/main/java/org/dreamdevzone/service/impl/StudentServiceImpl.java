package org.dreamdevzone.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.exception.ResourcesNotFoundException;
import org.dreamdevzone.mapper.StudentRowMapper;
import org.dreamdevzone.model.dto.StudentDto;
import org.dreamdevzone.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void add(StudentDto student) {
        String sql = "INSERT INTO Students(UserID,FirstName,LastName,DateOfBirth,Gender,Address," +
                "PhoneNumber,ParentID) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                        student.getUserId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getBirthDate(),
                        student.getGender() != null ? student.getGender().name() : null,
                        student.getAddress(),
                        student.getPhone(),
                        student.getParentId()
                );
    }

    @Override
    public StudentDto get(Integer id) {
        String sql = "SELECT StudentID,UserId,FirstName,LastName,DateOfBirth,Gender,Addresss,PhoneNumber,ParentID" +
                "FROM Students WHERE StudentID = ?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public List<@NotNull StudentDto> getAll(Pageable pageable) {
        String sql = "SELECT StudentID,UserId,FirstName,LastName,DateOfBirth,Gender,Addresss,PhoneNumber,ParentID" +
                "FROM Students";
        return jdbcTemplate.query(sql, new StudentRowMapper(), pageable);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Students WHERE StudentID = ?";
        int affectedRow = jdbcTemplate.update(sql, id);
        if (affectedRow > 0) {
            throw new ResourcesNotFoundException("Student not found");
        }
    }

    @Override
    public StudentDto update(StudentDto student, Integer id) {
        String sql = "UPDATE Students SET UserId =?, FiestName=?, LastName=?,DateOfBirth=?,Gender=?,Addresss=?," +
                "PhoneNumber=? WHERE StudentID = ?";

        student.setId(id);
        jdbcTemplate.update(sql,
                student.getUserId(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate(),
                student.getGender(),
                student.getAddress(),
                student.getPhone(),
                student.getParentId());
        return student;
    }
}
