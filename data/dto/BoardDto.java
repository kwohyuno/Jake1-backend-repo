package data.dto;
import data.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import data.entity.BoardEntity;
import org.hibernate.annotations.CreationTimestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private int id;
    private UserEntity userId;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Timestamp createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Timestamp updatedAt;

    public static BoardDto toBoardDto(BoardEntity entity){
        return BoardDto.builder()
                .id(entity.getId())
                .userId(entity.getUserid())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedat())
                .updatedAt(entity.getUpdatedat())
                .build();
    }
}
