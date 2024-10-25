package com.panda.graph.dao.entity;
//MATCH (n)--() RETURN n

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author muxiaohui
 */
@RelationshipEntity()
@Data
public class BaseEntity {
    /**
     * 定义关系的起始节点 == StartNode
     */
    @StartNode
    private PersonEntity startNode;

    private String localSince;

    /**
     * 定义关系的终止节点 == EndNode1
     */
    @EndNode
    private LocalEntity endNode1;

    private String jobSince;

    /**
     * 定义关系的终止节点 == EndNode2
     */
    @EndNode
    private JobEntity endNode2;


}
