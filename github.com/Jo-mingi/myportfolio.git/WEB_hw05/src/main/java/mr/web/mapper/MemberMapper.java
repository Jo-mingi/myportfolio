package mr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import mr.web.model.MemberDTO;

public interface MemberMapper {


	public List<MemberDTO> getList();
	public int registerMember(MemberDTO dto);
	public int memberDelete(int num);
	public MemberDTO memberInfo(String id);
	public int memberUpdate(MemberDTO dto);

	@Select("select name from medicine_member where id=#{id} AND pw=#{pw}")
	public String selectMemberName(MemberDTO dto);

	
	
}
