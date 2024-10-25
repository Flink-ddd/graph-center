//package com.panda.graph.service.impl;
//
//import com.panda.graph.dao.entity.RelationEntity;
//import com.panda.graph.dao.mapper.PersonRepository;
//import com.panda.graph.dao.mapper.RelationRepository;
//import com.panda.graph.dto.req.RelationReqDTO;
//import com.panda.graph.service.RelationService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.neo4j.ogm.model.Node;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author muxiaohui
// */
//@Service
//@Slf4j
//public class RelationServiceImpl implements RelationService {
//    @Autowired
//    private RelationRepository relationRepository;
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Override
//    public void nodeBind(RelationReqDTO relationReqDTO) {
//        Node start = personRepository.findByName(relationReqDTO.getStartName());
//        Node end = personRepository.findByName(relationReqDTO.getEndName());
//        RelationEntity relation = new RelationEntity();
//        relation.setStartNode(start);
//        relation.setEndNode(end);
//        relation.setRelation(relationReqDTO.getRelation());
//        relationRepository.save(relation);
//    }
//}
