package pe.com.bcp.demo.project.jwt.business;

import lombok.Builder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import pe.com.bcp.demo.project.jwt.dto.JwtRequest;
import pe.com.bcp.demo.project.jwt.dto.JwtResponse;
import pe.com.bcp.demo.project.jwt.util.JwtTokenUtil;

@Builder
public class AuthenticationBusiness {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;

    public JwtResponse generateToken(final JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        //simula BD
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return JwtResponse.builder().
                jwttoken(jwtTokenUtil.generateToken(userDetails)).
                build();
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
