package kr.co.farmstory.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.dto.UserPageRequestDTO;
import kr.co.farmstory.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Test
    public void selectsUsers(){

        UserPageRequestDTO userPageRequestDTO = UserPageRequestDTO.builder()
                .sort("name-desc")
                .build();

        Pageable pageable = userPageRequestDTO.getPageable();

        Page<Tuple> tuples = userRepository.selectsUsers(userPageRequestDTO, pageable);

        log.info(tuples);

        List<UserDTO> dtoList = tuples.getContent().stream()
                .map(tuple ->
                        {
                            User user = tuple.get(0, User.class);
                            Integer totalPrice = tuple.get(1, Integer.class);

                            int totalPriceValue = (totalPrice != null) ? totalPrice : 0;
                            user.setTotalPrice(totalPriceValue);

                            return modelMapper.map(user, UserDTO.class);
                        }
                )
                .toList();

        log.info(dtoList);


    }

}