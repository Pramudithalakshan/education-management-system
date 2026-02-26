package org.dreamdevzone.mapper;

import org.dreamdevzone.model.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDto(
                rs.getInt("UserID"),
                rs.getString("username"),
                rs.getString("Password"),
                rs.getBoolean("IsActive"),
                rs.getString("role")
        );
    }
}
