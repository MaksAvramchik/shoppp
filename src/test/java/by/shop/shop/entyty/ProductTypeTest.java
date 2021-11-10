package by.shop.shop.entyty;

import by.shop.shop.controller.DefaultController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductTypeTest {
    @Autowired
    private MockMvc MockMvc;

    @Autowired
    private DefaultController controller;

    @Test
    public void contextLoads() throws Exception {
        this.MockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("!!!NEW!!!")))
                .andExpect(content().string(containsString("В нашем интернет-магазине представлен широкий выбор одноразовых вейп POD систем!")))
                .andExpect(content().string(containsString("Попробуй новые яркие вкусы от фирмы HQD! Количество подов ограничено! Не упусти момент!")))
                .andExpect(content().string(containsString("КУПИТЬ СЕЙЧАС!")))
                .andExpect(content().string(containsString("Добро пожаловать в вейп шоп VapePodSystem")));
    }
}