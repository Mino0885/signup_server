package com.aoao.workflow.Controller;

import com.aoao.workflow.Service.SignService;
import com.aoao.workflow.Service.SignServiceImpl;
import com.aoao.workflow.pojo.GroupBean;
import com.aoao.workflow.pojo.MemberBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SignUpController {
    @RequestMapping("/signUp")
    public void signUp(HttpServletRequest request) {
        String leader_name = request.getParameter("leader_name");
        String phone_num = request.getParameter("phone_num");
        String wechat_num = request.getParameter("wechat_num");
        String class_name = request.getParameter("class_name");
        String grade_name = request.getParameter("grade_name");
        Map<String, Object> signTable = new HashMap<>();
        GroupBean groupBean = new GroupBean();
        groupBean.setId(UUID.randomUUID().toString());
        groupBean.setLeader_name(leader_name);
        groupBean.setPhone_num(phone_num);
        groupBean.setWechat_num(wechat_num);
        groupBean.setClass_name(class_name);
        groupBean.setGrade_name(grade_name);
        groupBean.setCreate_time(new Date(System.currentTimeMillis()));
        signTable.put("leader", groupBean);
        //获取组员的信息
        int memberSize = Integer.parseInt(request.getParameter("memberSize"));
        for (int count = 0; count < memberSize; count++) {
            MemberBean memberBean = new MemberBean();
            memberBean.setMember_name(request.getParameter("member_name_" + count));
            memberBean.setPhone_num(request.getParameter("phone_num_" + count));
            memberBean.setWechat_num(request.getParameter("wechat_num_" + count));
            memberBean.setClass_name(request.getParameter("class_name_" + count));
            memberBean.setGrade_name(request.getParameter("grade_name_" + count));
            memberBean.setAdd_time(new Date(System.currentTimeMillis()));
            signTable.put("member_" + count, memberBean);
        }
        signTable.put("size", memberSize);
        SignService service = new SignServiceImpl();
        boolean flage = service.saveGroup(signTable);
    }
}
