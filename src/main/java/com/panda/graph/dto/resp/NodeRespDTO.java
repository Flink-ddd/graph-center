package com.panda.graph.dto.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author muxiaohui
 */
@Data
public class NodeRespDTO {
    @ApiModelProperty("唯一ID")
    private String identity;

    @ApiModelProperty("标签库")
    private String[] labels;

    @ApiModelProperty("属性")
    private Properties properties;

    @ApiModelProperty("对象ID")
    private String elementId;
}
