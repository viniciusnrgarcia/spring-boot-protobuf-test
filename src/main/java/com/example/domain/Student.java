/**
 * 
 */
package com.example.domain;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vinicius-garcia
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Collection<PhoneNumber> phone;

}
