package com.panda.graph.dao.mapper;

import com.panda.graph.dao.entity.BaseEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muxiaohui
 */
@Repository
public interface BaseRepository extends Neo4jRepository<BaseEntity, Long> {
    /**
     * 查询所有关系的节点
     *
     * @return
     */
    @Query("MATCH (n)--() RETURN n")
    List<BaseEntity> getAll();
}
