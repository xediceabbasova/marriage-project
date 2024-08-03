package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.UserRequest;
import com.company.marriageproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {
        userRepository.save(userRequest.toUser());
    }
}
