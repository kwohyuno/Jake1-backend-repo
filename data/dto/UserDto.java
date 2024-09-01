package data.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import data.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.entity.UserEntity;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String userid;
    private String email;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Timestamp created_at;

    public static UserDto toUserDto(UserEntity entity){
        return UserDto.builder()
                .id(entity.getId())
                .userid(entity.getUserId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .created_at(entity.getCreatedAt())
                .build();
    }
}
