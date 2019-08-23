package com.demo.config;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("superheros")
public class SuperherosConfiguration extends ObjectBase {

    public SuperherosConfiguration() {
    }

    @Override
    public ToStringCreator toString(ToStringCreator creator) {
        return creator;
    }
}
