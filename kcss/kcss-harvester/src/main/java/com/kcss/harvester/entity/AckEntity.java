package com.kcss.harvester.entity;


import com.kcss.harvester.entity.def.ProtocolName;
import com.kcss.harvester.entity.def.ProtocolVersion;

public class AckEntity extends BaseEntity {

    public AckEntity(ProtocolName protocolName, ProtocolVersion protocolVersion) {
        this.protocolName = protocolName;
        this.protocolVersion = protocolVersion;
    }

    public AckEntity(ProtocolName protocolName) {
        this.protocolName = protocolName;
        this.protocolVersion = ProtocolVersion.V_1_0;
    }
}
