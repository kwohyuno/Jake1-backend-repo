package data.entity;

import data.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import data.dto.UserDto;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Entity(name = "user")
@Table(name = "user")
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="userid", unique = true, nullable = false)
    private String userId;
    @Column(name ="password")
    private String password;
    @Column(name ="email")
    private String email;
    @Column(name ="createdat")
    private Timestamp createdAt;

    public static UserEntity toEntity(UserDto userDto) {
        return UserEntity.builder()
                .userId(userDto.getUserid())
                .password(userDto.getPassword())
                .id(userDto.getId())
                .email(userDto.getEmail())
                .createdAt(userDto.getCreated_at())
                .build();
    }

}

