package bean;

import lombok.*;

/**
 * @Author LeiPeng
 * @Date 2020/7/13 - 11:21
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private String gender;
    private String phone;
    private String email;
    private Integer eduBackGround; // 学历 1 学士 2 硕士 3 博士
    private Integer stage; // 阶段 1 面试已通过 2 已发送offer 3 背调已完成 4 三方已签约
}
