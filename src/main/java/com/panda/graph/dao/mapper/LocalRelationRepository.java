package com.panda.graph.dao.mapper;

import com.panda.graph.dao.entity.LocalRelationEntity;
import com.panda.graph.dao.entity.RelationEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muxiaohui
 */
@Repository
public interface LocalRelationRepository extends Neo4jRepository<LocalRelationEntity, Long> {
    /**
     * 根据居住查询对应关系
     *
     * @return
     */
    @Query("match p = (n)-[r:居住]->(b) return p")
    List<LocalRelationEntity> getLocal();
}
