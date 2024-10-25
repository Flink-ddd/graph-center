package com.panda.graph;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author muxiaohui
 * @desc 功能描述: 启动主类
 */
@SpringBootApplication(scanBasePackages = "com.panda.graph")
@EnableNeo4jRepositories(basePackages = "com.panda.graph.dao.*")
@Slf4j
public class GraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

}
