package com.company.auditdemo.listener;

import com.company.auditdemo.entity.ExtAuditLogItem;
import com.company.auditdemo.session.ClientSession;
import org.springframework.stereotype.Component;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Component("auditdemo_ExtAuditLogItemListener")
public class ExtAuditLogItemListener {

    @PrePersist
    @PreUpdate
    public void enrichAuditLogItem(ExtAuditLogItem entity) {
        // Lấy IP client
        String ip = ClientSession.getIp();
        if (ip == null || ip.isEmpty()) {
            ip = "unknown";
        }
        entity.setIp(ip);
        if (entity.getDescription() == null || entity.getDescription().isEmpty()) {
            entity.setDescription("Default log description");
        }
    }
}
