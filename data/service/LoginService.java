package data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;
import data.entity.UserEntity;
import data.dto.UserDto;
import data.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;


    public UserDto login(UserDto dto, HttpSession session) {
        // 사용자 ID로 데이터베이스에서 사용자 정보 조회
        Optional<UserEntity> userOptional = userRepository.findByUserId(dto.getUserid());

        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();

            // 비밀번호 비교 (데이터베이스 비밀번호는 암호화된 상태여야 함)
            if (dto.getPassword().equals(userEntity.getPassword())) {
                // 로그인 성공: 세션에 사용자 정보 저장
                session.setAttribute("user", userEntity.getUserId());
                logger.info("User logged in: {}", userEntity.getUserId());

                // 필요에 따라 UserDto 반환
                return UserDto.toUserDto(userEntity);
            } else {
                // 비밀번호 불일치
                logger.warn("Password mismatch for user: {}", dto.getUserid());
                throw new RuntimeException("Invalid password");
            }
        } else {
            // 사용자 ID가 존재하지 않음
            logger.warn("User not found: {}", dto.getUserid());
            throw new RuntimeException("User not found");
        }
    }
}
