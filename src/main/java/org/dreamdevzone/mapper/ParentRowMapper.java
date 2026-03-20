package org.dreamdevzone.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dreamdevzone.model.dto.ParentDto;
import org.springframework.jdbc.core.RowMapper;

public class ParentRowMapper implements RowMapper<ParentDto> {

    @Override
    public ParentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ParentDto(
            rs.getInt("ParentId"),
            rs.getString("FirstName"),
            rs.getString("LastName"),
            rs.getString("PhoneNumber"),
            rs.getString("Email")
        );
    }
    
}
