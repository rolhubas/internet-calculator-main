package com.spring.calculator.config;

import com.spring.calculator.model.NumberDAO;
import com.spring.calculator.model.NumberDAOImpl;
import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 04.27 @Configuration anotacija zyminti konfig komponenta, viduje leidzia kurti Bean per metodus su @Bean anotacija
@Configuration
public class SpringConfig {
    //04.27 Bean tai objektai kurie sudaro Spring aplikacijos pagrinda
    //04.27 paprastai tai DAo klase relizuojanti tam tikra interfeisa ir java @Bean specifikacija
    // Bean atitinka singleton sablona - programines irangos projektavimo schema,
    // kuri riboja klases ivygdyma vienu vieninteliu egzemplioriumi
    // tai naudinga kai reikia tiksliai vieno objekto norint kordinuoti veiksmus visoje sistemoje
    @Bean
    //  @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai Bean susieti priklausomybe,
    //  jeigu @Configuratio klaeje yra daugiau negu vienas Bean, @Qualifier anotacija yra privaloma, kitu atveju klaida:
    //  'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    //  or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    // turi sutapti su NumberServiceImpl nes relizuoja
    public NumberDAO getNumberDAO(){
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService(){
        return new NumberServiceImpl();
    }

}
