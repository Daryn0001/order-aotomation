package kz.sdu.stu.dsalimov.beans;

import kz.sdu.stu.dsalimov.impl.BeanConfigRegister;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan
@Import({BeanConfigRegister.class})
public class BeanConfigAll {
}
