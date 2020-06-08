package com.lk.dubbo.framework;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 发送对象
 *
 * @author likai
 * @date 2019-11-25 23:50
 */
@Data
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;
}
