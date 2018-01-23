package com.yuanwj.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Map;

/**
 * Created by bmk on 17-12-22.
 */
public class UserAuthentication extends AbstractAuthenticationToken {

    private Long userId;

    private String jwtToken;

    private Map<String,Object> claims;

    public UserAuthentication(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public UserAuthentication(Collection<? extends GrantedAuthority> authorities, Long userId, String jwtToken, Map<String, Object> claims) {
        super(authorities);
        super.setAuthenticated(!authorities.isEmpty());
        this.userId = userId;
        this.jwtToken = jwtToken;
        this.claims = claims;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRealName(){
        return (String) this.claims.get("realName");
    }

    public String getUserName(){
        return (String) this.claims.get("userName");
    }

    public void getAuthoriti(){
        super.getAuthorities();
        for (GrantedAuthority grantedAuthority:super.getAuthorities()){
            System.out.println(grantedAuthority.getAuthority());
        }
    }

    public static UserAuthentication getUserAuthentication(){
        return (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
