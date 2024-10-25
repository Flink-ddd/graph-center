package com.panda.graph.dao.entity;


import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author muxiaohui
 */
@RelationshipEntity(type = "职业")
@Data
public class RelationEntity {
    @Property(name = "id")
    private Long id;

    /**
     * 定义关系的起始节点 == StartNode
     */
    @StartNode
    private PersonEntity startNode;

    private String since;

    /**
     * 定义关系的终止节点 == EndNode
     */
    @EndNode
    private JobEntity endNode;

}
