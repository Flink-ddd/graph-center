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
@NodeEntity(label = "Job")
@ApiModel(description = "工作实体")
public class JobEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
}
