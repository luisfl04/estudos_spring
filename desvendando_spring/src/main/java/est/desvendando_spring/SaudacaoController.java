package est.desvendando_spring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import est.desvendando_spring.Saudacao;

@RestController
public class SaudacaoController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/saudacao")
    public Saudacao retornar_saudacao(@RequestParam(defaultValue = "World") String name) {
        return new Saudacao(counter.incrementAndGet(), String.format(template, name));
    }
}