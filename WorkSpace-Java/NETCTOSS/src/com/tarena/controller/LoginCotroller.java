package com.tarena.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.dao.AdminMapper;
import com.tarena.entity.Admin;
import com.tarena.entity.Module;
import com.tarena.util.ImageUtil;

@Controller
@RequestMapping("/login")
public class LoginCotroller extends BaseController {
	
	public static final int SUCCESS=0;
	public static final int ADMIN_CODE_ERROR=1;
	public static final int PWD_ERROR=2;
	public  static final int IMAGE_CODE_ERROR=3;
	
	@Resource
	private AdminMapper adminMapper;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "main/login";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "main/index";
	}
	
	@RequestMapping("/checkLogin.do")
	@ResponseBody
	public int checkLogin(String adminCode,String password,String userCode,HttpSession session){
		//校验验证码
		String imageCode =  (String)session.getAttribute("imageCode");
		if(userCode == null||!userCode.equalsIgnoreCase(imageCode)){
			return IMAGE_CODE_ERROR;
		}
		Admin admin =adminMapper.findByCode(adminCode);
		if(admin==null){
			return ADMIN_CODE_ERROR;
		}else if(!admin.getPassword().equals(password)){
			return PWD_ERROR;
		} else{
			//验证通过，将信息存入session
			session.setAttribute("admin", admin);
			List<Module> list = adminMapper.findModuleByAdmin(admin.getAdmin_id());
			session.setAttribute("adminModules", list);
			return SUCCESS;
		}
	}
	
	@RequestMapping("/createImage.do")
	public void creatImage(HttpSession session,HttpServletResponse response) throws IOException{
		//创建验证码图片
		Map<String,BufferedImage> map = ImageUtil.createImage();
		//将验证码存入session,方便登录时校验
		String code = map.keySet().iterator().next();
		session.setAttribute("imageCode", code);
		//将图片输出到页面
		BufferedImage image = map.get(code);
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpeg",os);
		os.close();
	}
	
}
