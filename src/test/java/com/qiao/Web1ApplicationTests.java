package com.qiao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class Web1ApplicationTests {

    @Test
    void contextLoads() {
    }
    //生成JWT令牌
    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "itheima").setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)).compact();
        System.out.println(jwt);
    }
    //解析JWT
   @Test
    public void testParseJwt(){
       Map<String, Object> claims = Jwts.parser().setSigningKey("itheima").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MzU1MzcwMH0.alh-n5Mip8sTtzgOngsIqAhAehIgamwlrkuLcCyGvPA").getBody();
       System.out.println(claims);

   }
}
