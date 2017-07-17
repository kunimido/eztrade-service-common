package com.github.kunimido.eztrade.service.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TomcatAprPropertiesIT.class)
@TestPropertySource("classpath:/tomcat-apr-properties-test.properties")
@EnableConfigurationProperties(TomcatAprProperties.class)
public class TomcatAprPropertiesIT {
    @Autowired
    private TomcatAprProperties properties;

    @Test
    public void shouldReturnTrueForEnabled() {
        Assert.assertTrue(properties.isEnabled());
    }

    @Test
    public void shouldNotReturnNullForSsl() {
        Assert.assertNotNull(properties.getSsl());
    }

    @Test
    public void shouldReturnTrueForSslEnabled() {
        Assert.assertTrue(properties.getSsl().isEnabled());
    }

    @Test
    public void shouldReturnSslCertificateKeyFile() {
        Assert.assertEquals("conf/key.pem", properties.getSsl().getCertificateKeyFile());
    }

    @Test
    public void shouldReturnSslCertificateFile() {
        Assert.assertEquals("conf/cert.pem", properties.getSsl().getCertificateFile());
    }

    @Test
    public void shouldReturnSslCertificateChainFile() {
        Assert.assertEquals("conf/chain.pem", properties.getSsl().getCertificateChainFile());
    }
}