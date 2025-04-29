package edu.icet.dto;

import edu.icet.util.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer Id;
    @NotBlank(message = "Nam can not be null")
    private String name;
    @NotBlank(message = "Email is Mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Department is Mandatory")
    private Department department;
}
