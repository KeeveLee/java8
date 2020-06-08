package com.lk.dubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:36
 */
@Data
@AllArgsConstructor
public class URL {
    private String hostName;
    private Integer port;
}
