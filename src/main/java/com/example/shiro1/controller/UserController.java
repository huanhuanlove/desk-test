package com.example.shiro1.controller;

import com.example.shiro1.entity.User;
import com.example.shiro1.service.UserService;
import com.example.shiro1.vo.UserAllMenuVO;
import com.example.shiro1.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(int id) {
        return this.userService.queryById(id);
    }

    /**
     * 根据用户名查询所有的权限
     * @param username 用户名
     * @param mobile 手机号
     * @return 用户权限集合
     */
    @GetMapping("listAllMenu")
    //@ArgsNotAllNull
    //这个是配置是否有该权限的，如果是按上面的写法，这个是有权限的
    @RequiresPermissions("user:list")
    //@RequiresPermissions(value={"user:add"})//这个是没有权限的
    public String listAllMenu(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value="mobile", required = false) String mobile,
                              Model model){
        List<UserAllMenuVO> userAllMenuVOS = userService.listAllMenu(username, mobile);
        model.addAttribute("userMenus", userAllMenuVOS);
        return "index";
    }

    /**
     * <shiro:hasPermission name="user:list"><!-- 这个a标签是可以看见的 -->
     *             <a href="${pageContext.request.contextPath }/user/list" target="_blank">跳转到用户列表(有权限)</a>
     *         </shiro:hasPermission>
     *     <br/>
     *         <shiro:hasPermission name="user:add"><!-- 这个a标签是看不见的 -->
     *             <a href="${pageContext.request.contextPath }/user/add" target="_blank">跳转到新增用户列表(无权限)</a>
     *         </shiro:hasPermission>
     */

    /**
     * 查出所有用户信息
     * @return
     */
    @GetMapping("listUser")
    public String listUser(Model model){
        List<User> users = userService.listUser();
//        JsonResult result = new JsonResult();
//        result.success(result);
//        System.out.println(result.getData());
        model.addAttribute("users", users);
        return "users";
    }

    /**
     * 添加
     * @param userVO
     */
    @PostMapping("/saveUser")
    public void saveUser(UserVO userVO){
        userService.saveUser(userVO);
    }

    /**
     * 编辑
     */
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserVO userVO){
        userService.updateUser(userVO);
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteUser")
    public void removeUser(int id){
        userService.removeUser(id);
    }

    /**
     * 跳转到main界面
     */
    @GetMapping("/main")
    public String goMain(Model model){
        //中间默认页面
        model.addAttribute("page", "page1");
        model.addAttribute("frg", "page1");
        return "main";
    }
    /**
     * 跳转到page1
     */
    @GetMapping("/page1")
    public String page1(Model model){
        return "page1 :: page1";
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2 :: page2";
    }

    @GetMapping("/page3")
    public String page3(){
        return "page3 :: page3";
    }

    @GetMapping("/page4")
    public String page4(){
        return "page4 :: page4";
    }




    /***********************************************************************************************************/
    /****************************************          shiro功能练习        ************************************/
    /***********************************************************************************************************/

}