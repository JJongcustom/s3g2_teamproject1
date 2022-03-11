package com.ilinbun.mulcam.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ilinbun.mulcam.dto.BragBoard;
import com.ilinbun.mulcam.dto.User;
import com.ilinbun.mulcam.service.BragService;
import com.ilinbun.mulcam.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	BragService bragService;
	
	@Autowired
	UserService userService;

	@Autowired
	HttpSession session;

	@Autowired
	private ServletContext servletContext;

	@GetMapping({ "", "/index" })
	public String Main(Model model) {
		try {
			List<BragBoard> bestbragList = bragService.bragBest();
			List<BragBoard> bragList=bragService.getBragboardList(1); //첫번째 페이지에서 가져오는 의미
			model.addAttribute("bragList", bragList);
			model.addAttribute("bestbragList", bestbragList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}

	// 회원가입 폼
	@GetMapping("/join")
	public String getJoin(@ModelAttribute User user) {
		return "default/user/joinForm";
	}

	// 닉네임 중복체크
	@PostMapping("/nickCheck")
	@ResponseBody
	public String nickCheck(@RequestParam("nickname") String nickname) throws Exception {
		System.out.println("nickCheck 진입");
		System.out.println("전달받은 nickname:" + nickname);
		String msg = userService.nickCheck(nickname);
		System.out.println("확인 결과:" + msg);
		return msg;
	}

	// 이메일 중복체크
	@PostMapping("/emailCheck")
	@ResponseBody
	public String emailCheck(@RequestParam("email") String email) throws Exception {
		System.out.println("emailCheck 진입");
		System.out.println("전달받은 email:" + email);
		String msg = userService.emailCheck(email);
		System.out.println("확인 결과:" + msg);
		return msg;
	}

	// 회원가입 기능 컨트롤러
	@PostMapping("/join")
	public String postJoin(@Valid User user, BindingResult bindingResult, Model model) throws Exception {
//		System.out.println("postJoin()");
		if (bindingResult.hasErrors()) {
//			System.out.println("에러");

			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<>();

			for (int i = 0; i < list.size(); i++) {
				String field = list.get(i).getField();
				String message = list.get(i).getDefaultMessage();

//				System.out.println("field = " + field);
//				System.out.println("message = " + message);

				errorMsg.put(field, message); 
			}
			model.addAttribute("errorMsg", errorMsg);
			return "default/user/joinForm";
		}
		userService.makeUser(user);
		return "redirect:/loginSuccess";
	}

	// 회원가입 완료 폼
	@GetMapping("/loginSuccess")
	public String loginSuccess() {
		return "default/user/joinSuccessForm";
	}

	// 로그인 폼
	@GetMapping("/login")
	public String loginForm() {
		return "default/user/loginForm";
	}

	// 로그인 기능 컨트롤러
	@PostMapping("/login")
	public String login(String email, String password, boolean rememberEmail, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("login() join");
		try {
			User user = userService.loginUser(email, password);
			user.setPassword(null);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// 쿠키기능(로그인저장)
			if (rememberEmail) {
				// 1. 쿠키를 생성
				Cookie cookie = new Cookie("email", email);
				// 2. 응답에 저장
				response.addCookie(cookie);
			} else {
				// 1. 쿠키를 생성
				Cookie cookie = new Cookie("email", email);
				// 쿠키의 유효기간 0으로 설정
				cookie.setMaxAge(0);
				// 2. 응답에 저장
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = URLEncoder.encode("아이디와 비밀번호를 확인해주세요", "utf-8");
			return "redirect:/login?msg=" + msg;
		}
		System.out.println(email);
		System.out.println(password);
		return "redirect:/";
	}

	// 로그아웃 컨트롤러
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 비밀번호 찾기 폼
	@GetMapping("/searchPwd")
	public String searchPwd() {
		return "default/user/searchPwdForm";
	}

	// 마이 페이지 폼
	@GetMapping("/myPage")
	public String myPage(HttpSession session, Model model) throws Exception {

		session.getAttribute("email");
		return "user/myPageForm";
	}

	// 정보 수정 페이지 폼
	@GetMapping("/editInfo")
	public String editInfo() {
		return "user/editInfoForm";
	}

}
