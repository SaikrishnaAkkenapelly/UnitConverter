package com.unitconverter.configuration;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpToHttpsRedirectionConfigurer {

	@Bean
	WebServerFactoryCustomizer<TomcatServletWebServerFactory> getCustomisedTomcatConfigurationBean() {
		WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactoryCustomizer = new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
			@Override
			public void customize(TomcatServletWebServerFactory factory) {
				Connector cutomisedTomcatConnector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
				cutomisedTomcatConnector.setScheme("http");
				cutomisedTomcatConnector.setPort(8080);
				cutomisedTomcatConnector.setSecure(false);
				cutomisedTomcatConnector.setRedirectPort(8443);
				factory.addAdditionalTomcatConnectors(cutomisedTomcatConnector);
			}
		};
		return webServerFactoryCustomizer;
	}
}
