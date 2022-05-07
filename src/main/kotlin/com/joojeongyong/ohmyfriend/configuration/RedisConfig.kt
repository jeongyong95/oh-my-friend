package com.joojeongyong.ohmyfriend.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import java.time.Duration

@EnableRedisRepositories(basePackages = ["com.joojeongyong.ohmyfriend.**.cache"])
@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
    }

    @Bean
    fun redisCacheManager(connectionFactory: RedisConnectionFactory): RedisCacheManager {
        val cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(30))
            .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(cacheConfig)
            .build()
    }

    @Bean
    fun templateForRepository(connectionFactory: RedisConnectionFactory): RedisTemplate<ByteArray, ByteArray> {
        val template = RedisTemplate<ByteArray, ByteArray>()
        template.setConnectionFactory(connectionFactory)
        return template
    }

    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
        return StringRedisTemplate(connectionFactory);
    }

}