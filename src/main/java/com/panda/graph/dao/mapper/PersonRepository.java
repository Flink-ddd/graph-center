package com.panda.graph.dao.mapper;

import com.panda.graph.dao.entity.PersonEntity;
import com.panda.graph.dto.resp.NodeRespDTO;
import org.neo4j.ogm.model.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muxiaohui
 */
@Repository
public interface PersonRepository extends Neo4jRepository<PersonEntity, Long> {
    /**
     * 查询person节点信息
     */
    @Query("MATCH p=(n:Person) RETURN p")
    List<PersonEntity> selectAll();

    /**
     * 查询person节点下name属性的信息
     */
    @Query(value = "MATCH (n:Person {name:$name}) return n")
    String findByName(String name);

    /**
     * 查询全部节点信息
     */
    @Query("MATCH (a:Person)-[:职业]->(b:Job {title:'学生'}) RETURN a,b")
    Object selectInfo();

    /**
     * 修改person标签下某节点的名字
     */
    @Query("MATCH (n:Person {name:$name})set n.name=$newName")
    void updateNode(String name, String newName);

    /**
     * 根据节点名字删除节点
     */
    @Query(value = "MATCH (n:Person {name:$name}) delete n")
    void deleteNode(String name);
}
