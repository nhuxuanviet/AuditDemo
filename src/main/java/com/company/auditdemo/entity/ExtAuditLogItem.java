package com.company.auditdemo.entity;

import com.company.auditdemo.listener.ExtAuditLogItemListener;
import io.jmix.audit.entity.EntityLogItem;
import io.jmix.core.entity.annotation.ReplaceEntity;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;

@JmixEntity
@Entity
@EntityListeners(ExtAuditLogItemListener.class)
@ReplaceEntity(EntityLogItem.class)
public class ExtAuditLogItem extends EntityLogItem {
    @Column(name = "IP")
    private String ip;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}