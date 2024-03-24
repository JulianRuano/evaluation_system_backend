package com.evaluation.system.category.domain.models;

import java.util.HashSet;
import java.util.Set;

import com.evaluation.system.question.domain.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;
    private String name;
    private String description;
    
    private Set<Question> questions = new HashSet<>();
}
