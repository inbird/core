package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class OrderApp {
    public static void main(String[] args) {
 /*       AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
 */
        ApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        String name = "memberA";
        int price = 20000;

        Member member = new Member(memberId, name, Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Phone", price);

        System.out.println("order = " + order);
        System.out.println("discoutPrice = " + order.calculatePrice());


    }
}
