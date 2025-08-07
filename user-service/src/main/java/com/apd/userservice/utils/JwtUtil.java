package com.apd.userservice.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email, UUID userId) throws JOSEException {
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userId.toString())
                .claim("email", email)
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000))
                .build();

        JWSSigner jwsSigner = new MACSigner(secret.getBytes());

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256), jwtClaimsSet
        );

        signedJWT.sign(jwsSigner);

        return signedJWT.serialize();
    }

    public Map<String, String> getDecodedToken(String token) throws Exception{
        SignedJWT signedJWT = SignedJWT.parse(token);

        JWSVerifier jwsVerifier = new MACVerifier(secret.getBytes());

        if(!signedJWT.verify(jwsVerifier)){
            throw new IllegalArgumentException("Invalid Signature");
        }

        Date exp = signedJWT.getJWTClaimsSet().getExpirationTime();

        if(exp.before(new Date())){
            throw new IllegalArgumentException("Token expired");
        }

        Map<String, String> decodeToken = new HashMap<>();
        decodeToken.put("userId", signedJWT.getJWTClaimsSet().getSubject());
        decodeToken.put("email", signedJWT.getJWTClaimsSet().getClaimAsString("email"));

        return decodeToken;
    }


}
