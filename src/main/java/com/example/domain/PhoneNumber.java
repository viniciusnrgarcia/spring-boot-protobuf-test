/**
 * 
 */
package com.example.domain;

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
public class PhoneNumber {

    private String number;
    private PhoneType type;

}

enum PhoneType {
    MOBILE(0), LANDLINE(1);

    private int code;

    private PhoneType(final int code) {
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
