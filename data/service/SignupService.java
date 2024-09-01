package data.service;


import data.dto.UserDto;
import data.entity.UserEntity;
import data.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import data.entity.UserEntity;

@Service
public class SignupService {
    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserDto signup(UserDto dto, HttpSession session) {
        try{
            UserEntity user = UserEntity.toEntity(dto);
            userRepository.save(user);

            session.setAttribute("user", dto.getUserid());
            return dto;
        }catch(Exception e) {
            logger.error("signup Error", e);
            throw e;
        }
    }


}
