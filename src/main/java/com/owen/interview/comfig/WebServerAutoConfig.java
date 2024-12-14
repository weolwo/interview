package com.owen.interview.comfig;

import com.owen.interview.tool.JettyWebServerImpl;
import com.owen.interview.tool.TomatWebServerImpl;
import com.owen.interview.tool.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfig {


    @Bean
    @Conditional(TomatWebServerCondition.class)
    public WebServer tomcatWebServer(){
        return new TomatWebServerImpl();
    }

    @Bean
    @Conditional(JettyWebServerCondition.class)
    public WebServer jettyWebServer(){
        return new JettyWebServerImpl();
    }
}
