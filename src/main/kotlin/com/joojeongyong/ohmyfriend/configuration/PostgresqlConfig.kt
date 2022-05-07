package com.joojeongyong.ohmyfriend.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class PostgresqlConfig() {

    @Bean
    @ConfigurationProperties(value = "spring.datasource.hikari")
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun hikariDatasouce(): DataSource {
        return HikariDataSource(this.hikariConfig());
    }
}