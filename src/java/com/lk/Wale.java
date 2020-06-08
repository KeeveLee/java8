package com.lk;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-13 16:30
 */
@Data
public class Wale {
    @Getter(AccessLevel.NONE)
    private String id;
    private String name;
}
