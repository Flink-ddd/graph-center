package com.panda.graph.http;


import com.panda.graph.common.Result;
import com.panda.graph.dao.entity.LocalRelationEntity;
import com.panda.graph.dao.entity.RelationEntity;
import com.panda.graph.dto.req.NodeQueryDTO;
import com.panda.graph.dto.req.NodeReqDTO;
import com.panda.graph.dto.req.RelationQueryDTO;
import com.panda.graph.dto.resp.PersonRespDTO;
import com.panda.graph.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.ogm.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muxiaohui
 * @desc
 */
@RestController
@RequestMapping("/neo4j/")
@Api(value = "person标签相关接口", tags = "person标签相关接口")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * 通用方法（指定某一个图谱页面）
     * <p>
     * 创建单个节点、删除节点、修改节点、删除关系、修改关系、查看某一个节点数据以及明细关系数据、
     * 查看某一个节点标签的全部数据、按照属性名称查询、查看当前节点标签的所有关系节点、查看单个关系等等
     */

    @PostMapping("createPersoNode")
    @ApiOperation(value = "创建单个标签的新节点", notes = "创建单个标签的新节点")
    public Result createNode(@RequestBody NodeReqDTO createNode) {
        personService.saveNode(createNode);
        return Result.buildSuccess("创建单个标签的新节点成功");
    }

    @PostMapping("updateNode")
    @ApiOperation(value = "修改单个标签的节点", notes = "修改单个标签的节点")
    public Result updateNode(@RequestBody NodeReqDTO updateNode) {
        personService.updateNode(updateNode);
        return Result.buildSuccess("修改单个节点标签的节点成功");
    }

    @PostMapping("deleteNode")
    @ApiOperation(value = "删除单个标签的节点", notes = "支持按照节点ID、节点名称删除")
    public Result deleteNode(@RequestBody NodeQueryDTO deleteNode) {
        personService.deleteNode(deleteNode);
        return Result.buildSuccess("删除单个标签的节点成功");
    }

    @PostMapping("queryNodeDetail")
    @ApiOperation(value = "查询单个标签的节点", notes = "查询单个标签的节点")
    public Result<Object> queryNodeDetail(@RequestBody NodeQueryDTO queryNode) {
        return Result.of(personService.queryNodeDetail(queryNode), "查询单个节点标签的节点成功");
    }

    @PostMapping("queryPersonList")
    @ApiOperation(value = "查询单个标签的节点列表", notes = "查询单个标签的节点列表")
    public Result<List<PersonRespDTO>> queryPersonList() {
        return Result.of(personService.selectAll(), "查询节点列表成功");
    }

    @PostMapping("queryRelationByTitle")
    @ApiOperation(value = "根据职业查询对应关系", notes = "根据职业查询对应关系")
    public Result<List<RelationEntity>> queryRelationByTitle() {
        return Result.of(personService.getTitle(), "根据职业查询对应关系成功");
    }

    @PostMapping("queryRelationByLocal")
    @ApiOperation(value = "根据居住查询对应关系", notes = "根据居住查询对应关系")
    public Result<List<LocalRelationEntity>> queryRelationByLocal() {
        return Result.of(personService.getLocal(), "根据居住查询对应关系成功");
    }

}
