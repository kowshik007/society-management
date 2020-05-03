package com.application.start.config.security;

import com.application.start.entity.TblClient;
import com.application.start.service.TblClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TblClientServiceInterface tblClientServiceInterface;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        TblClient tblClient=tblClientServiceInterface.findByClientUserId("my-trusted-client");
        String[] scopes=new String[tblClient.getTblScopeSet().size()];
        String[] auths=new String[tblClient.getTblAuthoritySet().size()];
        AtomicInteger i = new AtomicInteger();
        tblClient.getTblAuthoritySet().iterator().forEachRemaining(tblAuthority -> {
            auths[i.intValue()]=tblAuthority.getName();
            i.incrementAndGet();
        });
        AtomicInteger index = new AtomicInteger();
        tblClient.getTblScopeSet().iterator().forEachRemaining(tblScope -> {
            scopes[index.intValue()]=tblScope.getName();
            index.incrementAndGet();
        });
        clients
                .inMemory()
                .withClient(tblClient.getClientUserId())
                .authorizedGrantTypes("client_credentials", "password")
                .authorities(auths)
                .scopes(scopes)
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(0)
                .secret(tblClient.getPassword());

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
