package edu.icet.dto;

import edu.icet.util.Department;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Department department;
}
