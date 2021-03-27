package org.dvdrental.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "org.dvdrental.domain")
public class EntityConfig {
}
