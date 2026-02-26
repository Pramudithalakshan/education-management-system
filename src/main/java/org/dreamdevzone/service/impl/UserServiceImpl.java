package org.dreamdevzone.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.exception.ResourcesNotFoundException;
import org.dreamdevzone.mapper.UserRowMapper;
import org.dreamdevzone.model.dto.UserDto;
import org.dreamdevzone.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void add(UserDto user) {
        String sql = "INSERT INTO Users(UserID,username,Password,IsActive,role) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getIsActive(), user.getRole());
    }

    @Override
    public UserDto get(Integer id) {
        String sql = "SELECT UserID, username, Password, IsActive, role  FROM Users WHERE UserID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(),id);
        }catch (ResourcesNotFoundException ex){
            throw new ResourcesNotFoundException("User not found");
        }
    }

    @Override
    public List<UserDto> getAll(Pageable pageable) {
        String sql = "SELECT UserID, username, Password, IsActive, role  FROM Users LIMIT ? offset ?";
        try {
            return jdbcTemplate.query(sql, new UserRowMapper(), pageable.getPageSize(), pageable.getOffset());
        }catch (ResourcesNotFoundException ex){
            throw new ResourcesNotFoundException("User not found");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
        try {
            jdbcTemplate.update(sql, id);
        }catch (ResourcesNotFoundException ex){
            throw new ResourcesNotFoundException("User not found");
        }
    }

    @Override
    public UserDto update(UserDto user, Integer id) {
        String checkSql = "SELECT * FROM Users WHERE UserID = ?";
        try {
            jdbcTemplate.queryForObject(checkSql, new UserRowMapper(), id);
        }catch (ResourcesNotFoundException ex){
            throw new ResourcesNotFoundException("User not found with id "+id);
        }

        String updateSql = "UPDATE Users SET UserID = ?, username = ?, Password = ?, IsActive = ?, role = ? WHERE UserID = ?";
        user.setId(id);
        jdbcTemplate.update(updateSql,
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getIsActive(),
                user.getRole(),
                id);
        return user;
    }
}
