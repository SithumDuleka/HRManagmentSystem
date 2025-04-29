package edu.icet.entity;

import edu.icet.util.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @Email(message = "Email should be vaild")
    @NotBlank(message = "Email is Mandatory")
    @NotNull
    private String email;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Department department;

}
