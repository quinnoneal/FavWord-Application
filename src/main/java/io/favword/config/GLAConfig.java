package io.favword.config;

import core.GLA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GLAConfig {

    @Bean
<<<<<<< HEAD
    public GLA glaConfig() {
=======
    public GLA remoteGLA() {
>>>>>>> config
        return new GLA();
    }
}
