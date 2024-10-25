package com.panda.graph.dao.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author muxiaohui
 */
@Data
@NodeEntity(label = "Person")
@ApiModel(description = "个人实体")
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;




}
