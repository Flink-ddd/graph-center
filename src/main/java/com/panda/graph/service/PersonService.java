package com.panda.graph.service;

import com.panda.graph.dao.entity.BaseEntity;
import com.panda.graph.dao.entity.LocalEntity;
import com.panda.graph.dao.entity.LocalRelationEntity;
import com.panda.graph.dao.entity.RelationEntity;
import com.panda.graph.dto.req.NodeQueryDTO;
import com.panda.graph.dto.req.NodeReqDTO;
import com.panda.graph.dto.req.RelationQueryDTO;
import com.panda.graph.dto.resp.PersonRespDTO;

import java.util.List;

/**
 * @author muxiaohui
 */
public interface PersonService {
    List<PersonRespDTO> selectAll();

    Object queryNodeDetail(NodeQueryDTO queryNode);

    void saveNode(NodeReqDTO createNode);

    void updateNode(NodeReqDTO updateNode);

    void deleteNode(NodeQueryDTO deleteNode);

    Object queryInfo();

    List<RelationEntity> getTitle();

    List<LocalRelationEntity> getLocal();

    List<BaseEntity> getAll();
}
