package com.example.jWebApiSpringBoot.Repositories;

import com.example.jWebApiSpringBoot.Models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, String> {
}
