package ru.skillfactorydemo.tgbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import ru.skillfactorydemo.tgbot.dto.GetCursOnDateXml;
import ru.skillfactorydemo.tgbot.dto.GetCursOnDateXmlResponse;
import ru.skillfactorydemo.tgbot.dto.GetCursOnDateXmlResult;
import ru.skillfactorydemo.tgbot.dto.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import java.nio.charset.StandardCharsets;

@Configuration
public class AppConfig {

    @Bean
    public CentralRussianBankService cbrService() throws SOAPException {
        CentralRussianBankService cbrService = new CentralRussianBankService();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        MessageFactory msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SaajSoapMessageFactory newSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
        cbrService.setMessageFactory(newSoapMessageFactory);

        jaxb2Marshaller.setClassesToBeBound(
                GetCursOnDateXml.class,
                GetCursOnDateXmlResponse.class,
                GetCursOnDateXmlResult.class,
                ValuteCursOnDate.class);

        cbrService.setMarshaller(jaxb2Marshaller);
        cbrService.setUnmarshaller(jaxb2Marshaller);
        return cbrService;
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(StandardCharsets.UTF_8.name());
        filter.setForceEncoding(true);
        return filter;
    }
}