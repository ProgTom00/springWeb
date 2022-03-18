package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class TrelloList {
    private String id;
    private String name;
    private boolean isClosed;
}
