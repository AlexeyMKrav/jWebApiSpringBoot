package com.example.jWebApiSpringBoot.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(generator = "GUID", strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "GUID",
            strategy = "org.hibernate.id.GUIDGenerator"
    )
    @Column(updatable = false, nullable = false, length = 36)
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
