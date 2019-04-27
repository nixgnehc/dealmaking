package cn.dealmaking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

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


    @Bean
    public JedisCluster jedisCluster() {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//        jedisClusterNodes.add(new HostAndPort("10.200.70.7", 6380));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 8001));
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        return jedisCluster;
    }
}
