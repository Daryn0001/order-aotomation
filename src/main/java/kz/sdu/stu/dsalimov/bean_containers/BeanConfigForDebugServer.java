package kz.sdu.stu.dsalimov.bean_containers;

import kz.sdu.stu.dsalimov.beans.BeanConfigAll;
import kz.sdu.stu.dsalimov.controller.BeanConfigControllers;
import org.springframework.context.annotation.Import;

@Import({
        BeanConfigAll.class,
        BeanConfigControllers.class
})
public class BeanConfigForDebugServer {
}
