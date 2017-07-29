package com.github.kunimido.eztrade.service.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "server.tomcat.apr")
@Getter
@Setter
public class TomcatAprProperties {
    @Getter
    @Setter
    public static class Ssl {
        private boolean enabled;

        private String certificateKeyFile;

        private String certificateFile;

        private String certificateChainFile;
    }

    private boolean enabled;

    private boolean http2;

    private final Ssl ssl = new Ssl();
}