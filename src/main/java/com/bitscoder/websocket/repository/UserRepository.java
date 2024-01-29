package com.bitscoder.websocket.repository;

import com.bitscoder.websocket.enums.Status;
import com.bitscoder.websocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
