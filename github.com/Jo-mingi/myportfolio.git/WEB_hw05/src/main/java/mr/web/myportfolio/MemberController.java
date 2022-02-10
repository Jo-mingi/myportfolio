package mr.web.myportfolio;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mr.web.mapper.MemberMapper;
import mr.web.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping("/memberInfo.do")
	public String memberInfo(String id, Model model) {
		
		MemberDTO dto = memberMapper.memberInfo(id);
		
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
			session.setAttribute("msg", "존재하지 않는 사용자입니다.");
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
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int num) {
		
		int cnt = memberMapper.memberDelete(num);
		
		return "redirect:/";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberDTO dto) {
		
		int cnt = memberMapper.memberUpdate(dto);
		
		return "redirect:/";
	}
	
}
