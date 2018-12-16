package com.lwen.pandora.template;

import com.lwen.pandora.handler.Handler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;

@AllArgsConstructor
public class DefaultServiceTemplate implements Template {
    private static Logger logger = null;
    private Handler handler = null;
}
