package com.panda.graph.dto.req;

import lombok.Data;
import org.neo4j.ogm.annotation.Property;

/**
 * @author muxiaohui
 */
@Data
public class RelationReqDTO {
    @Property
    private String startName;

    @Property
    private String endName;

    @Property
    private String relation;
}
