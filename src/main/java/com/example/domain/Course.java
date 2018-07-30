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
public class Course {

    private int id;
    private String courseName;
    private Collection<Student> student;

}
