package com.yuanwj.security;

import com.yuanwj.model.User;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * Created by bmk on 17-12-21.
 */
public class TokenService{

    private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);

    private static Long millisecond = 60 *60 *24*1000l;

    private String signer;

    public UserAuthentication createToken(User user){
//        Signer signer = new RsaSigner("yuanwj");
        Map<String,Object> content = new HashMap<>();
        Collection<? extends GrantedAuthority> userAuthorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_user"));
        content.put(TokenConstants.USERID,user.getId());
        content.put(TokenConstants.USERNAME,user.getUserName());
        content.put(TokenConstants.REALNAME,user.getRealName());
        content.put(TokenConstants.EXPI,System.currentTimeMillis()+millisecond);
        content.put(TokenConstants.AUTHORITIES,getAuthority(userAuthorities));
        String id = UUID.randomUUID().toString();
        String token = Jwts.builder()
                .setId(id)
                .setClaims(content)
                .setSubject(user.getUserName())
                .setExpiration(new Date(System.currentTimeMillis()+millisecond))
                .signWith(SignatureAlgorithm.HS512,signer).compact();
        UserAuthentication userAuthentication = new UserAuthentication(userAuthorities,user.getId(),token,content);
        System.out.println(userAuthentication.toString());
        return userAuthentication;
//        JwtHelper.encode()
    }

    public UserAuthentication parseToken(String token){
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(signer)
                .parseClaimsJws(token);
        Claims claims = jws.getBody();
//        if (StringUtils.isEmpty(claims.getId())){
//            LOG.debug("token subject 为空");
//            throw new RuntimeException("subject 为空");
//        }

        long current = System.currentTimeMillis();
        if (current > (Long) claims.get(TokenConstants.EXPI)) {
            LOG.debug("token 过期");
            throw new RuntimeException("token 过期");
        }
        Object authority = claims.get(TokenConstants.AUTHORITIES);
        if (!(authority instanceof Collection)){
            throw new RuntimeException("权限异常");
        }

        Collection<?extends GrantedAuthority> authorities=setAuthority(StringUtils.join((Collection)authority,"",""));

        Long userId= Long.valueOf((int)claims.get(TokenConstants.USERID));
        if (userId == null){
            LOG.debug("userId 为空");
            throw new RuntimeException("");
        }
        Map<String,Object> content = new HashMap<>();
        for (String key:claims.keySet()){
            content.put(key,claims.get(key));
        }
        content.put(TokenConstants.AUTHORITIES,authorities);
        UserAuthentication authentication = new UserAuthentication(authorities,userId,token,content);
        return authentication;
    }

    public Set<String> getAuthority(Collection<? extends GrantedAuthority> authorities){
        Set<String> roles=new HashSet<>();
        for (GrantedAuthority grantedAuthority:authorities){
            roles.add(grantedAuthority.getAuthority());
        }
        return roles;
    }

    public List<GrantedAuthority> setAuthority(String...roles){
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for (String role:roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthorities;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }
}
