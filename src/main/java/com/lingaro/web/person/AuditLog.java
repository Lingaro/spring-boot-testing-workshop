package com.lingaro.web.person;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuditLog {
    public static final Logger LOG = Logger.getLogger(AuditLog.class.getName());

    public void notify(String message) {
        LOG.fine(message);
    }
}
