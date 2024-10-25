package com.panda.graph.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author muxiaohui
 */
@Data
public class NodeReqDTO {
    @ApiModelProperty("节点名称")
    private String name;
    @ApiModelProperty("新节点名称")
    private String newName;
}
