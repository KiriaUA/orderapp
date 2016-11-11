package com.starikov;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
}
