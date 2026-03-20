package org.dreamdevzone.service.impl;

import java.util.List;

import org.dreamdevzone.exception.ResourcesNotFoundException;
import org.dreamdevzone.mapper.ParentRowMapper;
import org.dreamdevzone.model.dto.ParentDto;
import org.dreamdevzone.service.ParentService;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ParentServiceImpl implements ParentService{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void add(ParentDto dto) {
        jdbcTemplate.update("INSERT INTO Parents(FirstName,LastName,PhoneNumber,Email) Values(?,?,?,?)",
            dto.getFirstName(),
            dto.getLastName(),
            dto.getPhone(),
            dto.getEmail()
        );
    }

    @Override
    public ParentDto get(Integer id) {
       try {
        return jdbcTemplate.queryForObject("SELECT ParentId, FirstName, LastName, PhoneNumber, Email FROM Parents WHERE ParentID = ?",
         new ParentRowMapper());
       } catch (RuntimeException e) {
        throw new ResourcesNotFoundException("Parent not found with the id : "+id);
       }
    }

    @Override
    public List<ParentDto> getAll(Pageable pageable) {
        String sql = "SELECT ParentId, FirstName, LastName, PhoneNumber, Email " +
                "FROM Parents LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new ParentRowMapper(), pageable.getPageSize(), pageable.getOffset());
    }

    @Override
    public void delete(Integer id) {
         try {
            jdbcTemplate.update("DELETE FROM Parents WHERE ParentID = ?", id);
        }catch (ResourcesNotFoundException ex) {
            throw new ResourcesNotFoundException("Parent not found");
        }
    }

    @Override
    public ParentDto update(Integer id, ParentDto dto) {
        String checkSql = "SELECT COUNT(*) FROM Parents WHERE ParentID = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, id);

        if (count == null || count == 0) {
            throw new ResourcesNotFoundException("Student not found with ID: " + id);
        }
        String updateSql = """
            UPDATE Students 
            SET ParentId = ?, 
                FirstName = ?, 
                LastName = ?, 
                PhoneNumber = ?, 
                Email = ? 
            WHERE ParentId = ?
            """;
        dto.setId(id);
        jdbcTemplate.update(updateSql,
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhone(),
                dto.getEmail(),
                id
        );
        return dto;
    }
    
}
