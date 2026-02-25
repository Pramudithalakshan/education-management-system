package org.dreamdevzone.mapper;

import org.dreamdevzone.enums.Gender;
import org.dreamdevzone.model.dto.StudentDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentDto> {
    @Override
    public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        String genderStr = rs.getString("Gender");

        Gender gender = null;
        if (genderStr != null) {
            try {
                gender = Gender.valueOf(genderStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                gender = null;
            }
        }
        return new StudentDto(
                rs.getInt("StudentID"),
                rs.getInt("UserID"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getDate("DateOfBirth"),
                gender,
                rs.getString("Address"),
                rs.getString("PhoneNumber"),
                rs.getInt("ParentID")
        );
    }
}
