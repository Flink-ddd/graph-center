package com.panda.graph.service.impl;

import com.alibaba.fastjson.JSON;
import com.panda.graph.dao.entity.BaseEntity;
import com.panda.graph.dao.entity.LocalRelationEntity;
import com.panda.graph.dao.entity.PersonEntity;
import com.panda.graph.dao.entity.RelationEntity;
import com.panda.graph.dao.mapper.LocalRelationRepository;
import com.panda.graph.dao.mapper.PersonRepository;
import com.panda.graph.dao.mapper.RelationRepository;
import com.panda.graph.dto.req.NodeQueryDTO;
import com.panda.graph.dto.req.NodeReqDTO;
import com.panda.graph.dto.resp.PersonRespDTO;
import com.panda.graph.service.PersonService;
import com.panda.graph.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author muxiaohui
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private LocalRelationRepository localRelationRepository;

    @Override
    public List<PersonRespDTO> selectAll() {
        List<PersonEntity> personEntityList = personRepository.selectAll();
        List<PersonRespDTO> personRespDTOS = BeanUtils.convertList(personEntityList, PersonRespDTO.class);
        return personRespDTOS;
    }

    @Override
    public Object queryNodeDetail(NodeQueryDTO queryNode) {
        if (null != queryNode.getNodeId()) {
            Optional<PersonEntity> personEntity = personRepository.findById(queryNode.getNodeId());
            PersonEntity person = personEntity.orElse(null);
            log.info("返回标签下节点信息[{}]", JSON.toJSONString(person));
            return person;
        }
        return null;
    }

    @Override
    public void saveNode(NodeReqDTO createNodeReqDTO) {
        log.info("新增标签下新节点的请求参数[{}]", JSON.toJSONString(createNodeReqDTO));
        PersonEntity personEntity = BeanUtils.convertBean(createNodeReqDTO, PersonEntity.class);
        personRepository.save(personEntity);
    }

    @Override
    public void updateNode(NodeReqDTO updateNode) {
        log.info("修改标签下节点的请求参数[{}]", JSON.toJSONString(updateNode));
        personRepository.updateNode(updateNode.getName(), updateNode.getNewName());
    }

    @Override
    public void deleteNode(NodeQueryDTO deleteNode) {
        log.info("删除标签下节点的请求参数[{}]", JSON.toJSONString(deleteNode));
        //如果当前标签下节点有关联关系，不允许删除
        if (null != deleteNode.getNodeId()) {
            personRepository.deleteById(deleteNode.getNodeId());
        } else if (StringUtils.isNotBlank(deleteNode.getName())) {
            personRepository.deleteNode(deleteNode.getName());
        } else if (null != deleteNode.getNodeId() && StringUtils.isNotBlank(deleteNode.getName())) {
            personRepository.deleteById(deleteNode.getNodeId());
        }
    }

    @Override
    public Object queryInfo() {
        return personRepository.selectInfo();
    }

    @Override
    public List<RelationEntity> getTitle() {
        List<RelationEntity> relationEntityList = new ArrayList<>();
        List<RelationEntity> relationEntities = relationRepository.getTitle();
        relationEntities.stream().forEach(relationEntity -> {
            RelationEntity relation = BeanUtils.convertBean(relationEntity, RelationEntity.class);
            relation.setSince("职业");
            relationEntityList.add(relation);
        });
        return relationEntityList;
    }

    @Override
    public List<LocalRelationEntity> getLocal() {
        List<LocalRelationEntity> localRelationEntityList = new ArrayList<>();
        List<LocalRelationEntity> localRelationEntities = localRelationRepository.getLocal();
        localRelationEntities.stream().forEach(localRelationEntity -> {
            LocalRelationEntity localRelation = BeanUtils.convertBean(localRelationEntity, LocalRelationEntity.class);
            localRelation.setSince("居住");
            localRelationEntityList.add(localRelation);
        });
        return localRelationEntityList;
    }

    @Override
    public List<BaseEntity> getAll() {
        return null;
    }


}
