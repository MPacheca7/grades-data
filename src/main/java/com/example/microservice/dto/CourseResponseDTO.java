package com.example.microservice.dto;

import com.example.microservice.models.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

    private long id;
    private String name;
    private List<Grade> gradeDTOList;
}
