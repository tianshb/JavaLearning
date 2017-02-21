package com.crow.Proxy;

import java.lang.reflect.*;

/**
 * Created by CrowHawk on 17/2/20.
 */
public interface Advice {
    void forwardMethod(Method method);
    void backMethod(Method method);
}
