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
        String sql = "SELECT StudentID, UserId, FirstName, LastName, DateOfBirth, Gender, Address, PhoneNumber, ParentID " +
                "FROM Students WHERE StudentID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        } catch (ResourcesNotFoundException ex) {
            throw new ResourcesNotFoundException("Student not found");
        }
    }

    @Override
    public List<@NotNull StudentDto> getAll(Pageable pageable) {
        String sql = "SELECT StudentID, UserId, FirstName, LastName, DateOfBirth, Gender, Address, PhoneNumber, ParentID " +
                "FROM Students LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new StudentRowMapper(), pageable.getPageSize(), pageable.getOffset());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Students WHERE StudentID = ?";
        try {
            jdbcTemplate.update(sql, id);
        }catch (ResourcesNotFoundException ex) {
            throw new ResourcesNotFoundException("Student not found");
        }
    }

    @Override
    public StudentDto update(StudentDto student, Integer id) {
        String checkSql = "SELECT COUNT(*) FROM Students WHERE StudentID = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, id);

        if (count == null || count == 0) {
            throw new ResourcesNotFoundException("Student not found with ID: " + id);
        }
        String updateSql = """
            UPDATE Students 
            SET UserId = ?, 
                FirstName = ?, 
                LastName = ?, 
                DateOfBirth = ?, 
                Gender = ?, 
                Address = ?, 
                PhoneNumber = ?, 
                ParentID = ? 
            WHERE StudentID = ?
            """;
        student.setId(id);
        jdbcTemplate.update(updateSql,
                student.getUserId(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate(),
                student.getGender() != null ? student.getGender().name() : null,
                student.getAddress(),
                student.getPhone(),
                student.getParentId(),
                id
        );
        return student;
    }
}
