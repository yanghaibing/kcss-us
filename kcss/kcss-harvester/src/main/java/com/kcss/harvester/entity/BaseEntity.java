package com.kcss.harvester.entity;

import com.kcss.harvester.entity.def.ProtocolName;
import com.kcss.harvester.entity.def.ProtocolVersion;

public class BaseEntity {

    protected ProtocolVersion protocolVersion;
    protected ProtocolName protocolName;

    public ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public ProtocolName getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(ProtocolName protocolName) {
        this.protocolName = protocolName;
    }

}
