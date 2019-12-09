package pe.com.bcp.demo.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import pe.com.bcp.demo.project.convert.business.ConvertBusiness;
import pe.com.bcp.demo.project.convert.business.ConvertGetData;
import pe.com.bcp.demo.project.convert.service.ConvertService;
import pe.com.bcp.demo.project.convert.service.impl.ConvertServiceImpl;
import pe.com.bcp.demo.project.jwt.business.AuthenticationBusiness;
import pe.com.bcp.demo.project.jwt.service.JwtUserDetailsService;
import pe.com.bcp.demo.project.jwt.util.JwtTokenUtil;
import pe.com.bcp.demo.project.money.business.MoneyBusiness;
import pe.com.bcp.demo.project.money.repository.MoneyRepository;
import pe.com.bcp.demo.project.money.service.MoneyService;
import pe.com.bcp.demo.project.money.service.impl.MoneyServiceImpl;
import pe.com.bcp.demo.project.typechange.business.TypeChangeBusiness;
import pe.com.bcp.demo.project.typechange.business.TypeChangeGetData;
import pe.com.bcp.demo.project.typechange.repository.TypeChangeRepository;
import pe.com.bcp.demo.project.typechange.service.TypeChangeService;
import pe.com.bcp.demo.project.typechange.service.impl.TypeChangeServiceImpl;

@Configuration
public class CoreConfig {
    @Autowired
    private MoneyService moneyService;
    @Autowired
    private TypeChangeService typeChangeService;
    @Autowired
    private ConvertService convertService;
    @Autowired
    private MoneyRepository moneyRepository;
    @Autowired
    private TypeChangeRepository typeChangeRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Bean
    public ConvertBusiness convertBusiness() {
        return ConvertBusiness.builder().
                convertGetData(convertGetData()).
                convertService(convertService).
                build();
    }

    @Bean
    public MoneyBusiness moneyBusiness() {
        return MoneyBusiness.builder().
                moneyService(moneyService).
                build();
    }

    @Bean
    public TypeChangeBusiness typeChangeBusiness() {
        return TypeChangeBusiness.builder().
                typeChangeGetData(typeChangeGetData()).
                typeChangeService(typeChangeService).
                build();
    }

    @Bean
    public AuthenticationBusiness authenticationBusiness() {
        return AuthenticationBusiness.builder().
                authenticationManager(authenticationManager).
                jwtTokenUtil(jwtTokenUtil()).
                userDetailsService(userDetailsService).
                build();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return JwtTokenUtil.builder().build();
    }

    @Bean
    public TypeChangeGetData typeChangeGetData() {
        return TypeChangeGetData.builder().
                moneyService(moneyService).
                typeChangeService(typeChangeService).
                build();
    }

    @Bean
    public ConvertGetData convertGetData() {
        return ConvertGetData.builder().
                moneyService(moneyService).
                typeChangeService(typeChangeService).
                build();
    }

    @Bean
    public ConvertService convertService() {
        return ConvertServiceImpl.builder().
                build();
    }

    @Bean
    public MoneyService moneyService(final MoneyRepository moneyRepository) {
        return MoneyServiceImpl.builder().
                moneyRepository(moneyRepository).
                build();
    }

    @Bean
    public TypeChangeService typeChangeService(final TypeChangeRepository typeChangeRepository) {
        return TypeChangeServiceImpl.builder().
                typeChangeRepository(typeChangeRepository).
                build();
    }
}
