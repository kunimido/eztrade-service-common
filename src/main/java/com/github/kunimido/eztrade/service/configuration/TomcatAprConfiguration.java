package com.github.kunimido.eztrade.service.configuration;

import org.apache.catalina.core.AprLifecycleListener;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TomcatAprProperties.class)
public class TomcatAprConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "server.tomcat.apr", name = "enabled")
    public EmbeddedServletContainerFactory embeddedServletContainerFactory(final TomcatAprProperties tomcatAprProperties) {
        final TomcatEmbeddedServletContainerFactory result = new TomcatEmbeddedServletContainerFactory();
        result.setProtocol("org.apache.coyote.http11.Http11AprProtocol");

        final AprLifecycleListener aprLifecycleListener = new AprLifecycleListener();
        aprLifecycleListener.setUseAprConnector(true);
        result.addContextLifecycleListeners(aprLifecycleListener);

        if (tomcatAprProperties.getSsl().isEnabled()) {
            result.addConnectorCustomizers(connector -> {
                final Http11AprProtocol handler = (Http11AprProtocol) connector.getProtocolHandler();
                handler.setSSLEnabled(true);
                handler.setSSLCertificateKeyFile(tomcatAprProperties.getSsl().getCertificateKeyFile());
                handler.setSSLCertificateFile(tomcatAprProperties.getSsl().getCertificateFile());
                handler.setSSLCertificateChainFile(tomcatAprProperties.getSsl().getCertificateChainFile());

                connector.setScheme("https");
                connector.setSecure(true);
            });
        }

        return result;
    }
}