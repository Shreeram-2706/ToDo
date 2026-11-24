package dev.HelloWorld.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    @Schema(name = "title", example = "Complete Spring Boot")
    private String title;

//    @NotNull
//    @NotBlank
//    @Size(min = 5, max = 255)
//    @Column(length = 255)
//    private String description;

    private Boolean isCompleted;

//    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
//    @Column(name = "phone_number", nullable = true)
//    private String phone_number;
//
//    @Email
//    private String email;
}
