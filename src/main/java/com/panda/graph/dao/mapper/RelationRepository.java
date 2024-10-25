package com.panda.graph.dao.mapper;

import com.panda.graph.dao.entity.PersonEntity;
import com.panda.graph.dao.entity.RelationEntity;
import org.neo4j.ogm.model.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muxiaohui
 */
@Repository
public interface RelationRepository extends Neo4jRepository<RelationEntity, Long> {

    /**
     * 根据职业查询对应关系
     *
     * @return
     */
    @Query("match p = (n)-[r:职业]->(b) return p")
    List<RelationEntity> getTitle();

//    /**
//     * 创建节点关联关系
//     */
//    @Query("MATCH p=(n:Person)-[r:Relation]->(m:Person) " +
//            "WHERE id(n)={startNode} and id(m)={endNode} and r.relation={relation}" +
//            "RETURN p")
//    List<RelationEntity> findRelation(@Param("startNode") Node startNode,
//                                      @Param("endNode") Node endNode,
//                                      @Param("relation") String relation);
}
