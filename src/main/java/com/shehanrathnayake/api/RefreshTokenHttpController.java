package com.shehanrathnayake.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shehanrathnayake.service.custom.RefreshTokenService;
import com.shehanrathnayake.service.custom.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/v1/refresh-token")
@CrossOrigin
@RequiredArgsConstructor
public class RefreshTokenHttpController {

    private final RefreshTokenService refreshTokenService;

    @GetMapping
    public void getAccessToken(HttpServletRequest req, HttpServletResponse res) throws IOException {
        refreshTokenService.getAccessToken(req, res);
    }
}
