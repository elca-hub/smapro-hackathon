package com.mokimaki.arput.infrastructure.elasticsearch;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
@ConfigurationProperties(prefix = "arput.es")
public class ElasticSearchConfig extends ElasticsearchConfiguration {
    @Setter
    private String host;

    @Setter
    private String port;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .build();
    }
}
