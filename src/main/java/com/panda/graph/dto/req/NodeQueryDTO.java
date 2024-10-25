package com.panda.graph.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author muxiaohui
 */
@Data
public class NodeQueryDTO {
    @ApiModelProperty("节点ID")
    private Long nodeId;

    @ApiModelProperty("节点名称")
    private String name;

}
