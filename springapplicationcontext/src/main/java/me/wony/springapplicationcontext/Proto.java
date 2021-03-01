package me.wony.springapplicationcontext;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * 1. @Component @Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
 * 2. private ObjectProvider<Proto> proto;
 *    return proto.getIfAvailable();
 * 3.
 */

//@Component @Scope(value = "prototype")
@Component @Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {
}
