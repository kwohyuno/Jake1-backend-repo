package data.entity;
import jakarta.persistence.*;

import data.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Entity(name = "board")
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName="userid",nullable=false)
    private UserEntity Userid;
    @Column(name = "title")
    private String Title;
    @Column(name = "content")
    private String Content;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp Createdat;
    @Column(name = "updated_at")
    private Timestamp Updatedat;

    public static BoardEntity toEntity(BoardDto boardDto) {
        return BoardEntity.builder()
                .Content(boardDto.getContent())
                .Title(boardDto.getTitle())
                .Id(boardDto.getId())
                .Userid(boardDto.getUserId())
                .Createdat(boardDto.getCreatedAt())
                .Updatedat(boardDto.getUpdatedAt())
                .build();
    }
}
