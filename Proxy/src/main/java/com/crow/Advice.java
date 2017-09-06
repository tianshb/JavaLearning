package com.crow;

import java.lang.reflect.Method;

/**
 * Created by CrowHawk on 17/2/20.
 */
public interface Advice {
    void forwardMethod(Method method);
    void backMethod(Method method);
}
