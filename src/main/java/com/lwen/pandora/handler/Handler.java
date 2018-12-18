package com.lwen.pandora.handler;

import com.lwen.pandora.entity.ResultEntity;
import org.slf4j.Logger;

public interface Handler {
    void handle(Exception e, ResultEntity result, Logger logger);
}
