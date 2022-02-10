package mr.web.myportfolio;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mr.web.mapper.MemberMapper;
import mr.web.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping("/memberInfo.do")
	public String memberInfo(int num, Model model) {
		
		MemberDTO dto = memberMapper.memberInfo(num);
		
		model.addAttribute("dto", dto);
		
		return "member/memberInfo"; // View 이름만 넘겨줌
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogout(HttpSession session) {
		session.removeAttribute("sessionUserId");
		session.removeAttribute("sessionUserName");
		
		return "redirect:/";
	}

	@RequestMapping("/memberLogin.do")
	public String memberlogin(MemberDTO dto, HttpSession session) {
		String userName = memberMapper.selectMemberName(dto);
		
		if(userName !=null && !"".contentEquals(userName)) {
			session.setAttribute("sessionUserId", dto.getId());
			session.setAttribute("sessionUserName", userName);
		}else {
			session.setAttribute("sessionUserId", "");
			session.setAttribute("sessionUserName", "");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberDTO dto) {
		int cnt = memberMapper.registerMember(dto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/memberJoin.do")
	public String memberJoin() {
		
		return "member/join";
	}
	
}
