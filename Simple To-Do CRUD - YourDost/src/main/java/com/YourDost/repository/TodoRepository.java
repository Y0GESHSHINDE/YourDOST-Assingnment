package com.YourDost.repository;

import com.YourDost.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository  extends MongoRepository<Todo , String> {

}
