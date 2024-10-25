package com.panda.graph.dao.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.model.Node;

/**
 * @author muxiaohui
 */
@Data
@NodeEntity(label = "Location")
@ApiModel(description = "地址实体")
public class LocalEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private String country;
}
