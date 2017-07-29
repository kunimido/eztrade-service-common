package com.github.kunimido.eztrade.service.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TomcatAprPropertiesIT.class)
@TestPropertySource("classpath:/tomcat-apr-properties-test.properties")
@EnableConfigurationProperties(TomcatAprProperties.class)
public class TomcatAprPropertiesIT {
    @Autowired
    private TomcatAprProperties properties;

    @Test
    public void shouldReturnTrueForEnabled() {
        assertTrue(properties.isEnabled());
    }

    @Test
    public void shouldReturnTrueForHttp2() {
        assertTrue(properties.isHttp2());
    }

    @Test
    public void shouldNotReturnNullForSsl() {
        assertNotNull(properties.getSsl());
    }

    @Test
    public void shouldReturnTrueForSslEnabled() {
        assertTrue(properties.getSsl().isEnabled());
    }

    @Test
    public void shouldReturnSslCertificateKeyFile() {
        assertEquals("conf/key.pem", properties.getSsl().getCertificateKeyFile());
    }

    @Test
    public void shouldReturnSslCertificateFile() {
        assertEquals("conf/cert.pem", properties.getSsl().getCertificateFile());
    }

    @Test
    public void shouldReturnSslCertificateChainFile() {
        assertEquals("conf/chain.pem", properties.getSsl().getCertificateChainFile());
    }
}