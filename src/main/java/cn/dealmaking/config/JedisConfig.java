package cn.dealmaking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-24
 * @time: 上午11:09
 * @Description: TODO..
 */

@Component
public class JedisConfig {

    @Value("${redis.config.connect}")
    private String redisConnect;

    @Bean
    public JedisCluster jedisCluster() {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();

        Arrays.asList(redisConnect.split(",")).stream().forEach(node->{
            String [] nodeArr = node.split(":");
            jedisClusterNodes.add(new HostAndPort(nodeArr[0], Integer.parseInt(nodeArr[1])));
        });

        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        return jedisCluster;
    }
}
