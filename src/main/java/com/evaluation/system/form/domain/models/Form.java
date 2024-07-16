package com.evaluation.system.form.domain.models;

import java.util.List;

import com.evaluation.system.question.domain.model.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Form {

    private Long id;
    private String title;
    private String description;

    private List<Question> questions;
    
}
