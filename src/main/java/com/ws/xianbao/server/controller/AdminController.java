package com.ws.xianbao.server.controller;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.Admin;
import com.ws.xianbao.bean.User;
import com.ws.xianbao.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String USER_SESSION = "user_info_session";
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("projectName", "xianbao");
        return "login";
    }
    @GetMapping("/index")
    public String index(Model model,HttpSession session) {
        Admin current = (Admin) session.getAttribute(USER_SESSION);
        if (null != current) {
            model.addAttribute("userCount", adminService.newUserCount());
            model.addAttribute("indexUsers", adminService.indexUsers());
        }
        model.addAttribute("projectName", "xianbao");
        return "index";
    }
    @GetMapping("/newslist")
    public String newslist(Model model) {
        model.addAttribute("projectName", "xianbao");
        return "newslist";
    }
    @GetMapping("/things")
    public String things(Model model) {
        model.addAttribute("projectName", "xianbao");
        return "things";
    }
    @GetMapping("/userInfo")
    public String userInfo(Model model) {
        model.addAttribute("projectName", "xianbao");
        return "userInfo";
    }
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("projectName", "xianbao");
        return "users";
    }


    /**
     * 管理员登录表单
     * @param account
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginForm", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object>  adminLogin(String account,String password,HttpSession session){
        Map<String, Object> map = new HashMap<>();
        Admin result = adminService.adminLogin(account, password);
        if (null==result) {
            map.put("code", "1");//账号或密码错误
            map.put("msg", "账号或密码错误");
        }else{
            map.put("code", "0");//登录成功
            map.put("msg", "登录成功");
            map.put("data", result);
            session.setAttribute(USER_SESSION,result);
        }
        return map;
    }
    @GetMapping("/loginOut")
    public String  loginOut(Model model,HttpSession session){
        model.addAttribute("projectName", "xianbao");
        session.setAttribute("user_info_session",null);//清除登录session
        return  "login";
    }

//    @ResponseBody
//    @RequestMapping(value = "/loginForm", method = RequestMethod.POST,
//            produces = {"application/json;charset=UTF-8"})
//    public Map<String, Object> addUser(String account,String password){
//        Map<String, Object> map = new HashMap<>();
//        System.out.println(account+"//"+password);
//        Admin result = adminService.adminLogin(account, password);
//        if (null==result) {
//            map.put("code", "1");//账号或密码错误
//            map.put("msg", "账号或密码错误");
//        }else{
//            map.put("code", "0");//账号或密码错误
//            map.put("msg", "登录成功");
//            map.put("data", result);
//        }
//        return map;
//    }
}
