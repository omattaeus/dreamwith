package br.com.compilou.apirh.services;

import br.com.compilou.apirh.data.vo.v1.security.TokenVO;
import br.com.compilou.apirh.repositories.UserRepository;
import br.com.compilou.apirh.security.Jwt.AccountCredentialsVO;
import br.com.compilou.apirh.security.Jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServices {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin(AccountCredentialsVO data){
        try {
            var username = data.getUsername();
            var password = data.getPassword();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            var user = repository.findByUsername(username);

            var tokenReponse = new TokenVO();
            if(user != null){
                tokenProvider.createAccessToken(username, convertRolesToList(user.getRoles()));
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            return ResponseEntity.ok(tokenReponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

    private List<String> convertRolesToList(List<String> roles) {
        return new ArrayList<>(roles);
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity refreshToken(String username, String refreshToken){

        var user = repository.findByUsername(username);

        var tokenReponse = new TokenVO();
        if(user != null){
            tokenReponse = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
            return ResponseEntity.ok(tokenReponse);
    }
}