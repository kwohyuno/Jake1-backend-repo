package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import data.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    // JpaRepository에서 기본 CRUD 메서드 제공
    // 필요한 경우 커스텀 쿼리 메서드를 추가할 수 있습니다.
}

