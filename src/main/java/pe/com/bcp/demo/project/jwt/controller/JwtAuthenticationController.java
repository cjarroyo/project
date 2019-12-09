package pe.com.bcp.demo.project.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.demo.project.jwt.business.AuthenticationBusiness;
import pe.com.bcp.demo.project.jwt.dto.JwtRequest;
import pe.com.bcp.demo.project.jwt.dto.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private AuthenticationBusiness authenticationBusiness;

    public JwtAuthenticationController(final AuthenticationBusiness authenticationBusiness) {
        this.authenticationBusiness = authenticationBusiness;
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        return authenticationBusiness.generateToken(authenticationRequest);
    }
}
