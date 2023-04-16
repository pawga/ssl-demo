package com.pawga777.ssldemo.security

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created by sivannikov on 14.03.2022 15:54
 */

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
    }
}