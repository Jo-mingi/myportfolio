package mr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import mr.web.model.MemberDTO;

public interface MemberMapper {


	public List<MemberDTO> getList();
	public int registerMember(MemberDTO dto);
	public int memberDelete(int num);
	public MemberDTO memberInfo(int num);
	public int memberUpdate(MemberDTO dto);

	@Select("select name from member3 where id=#{id} AND pw=#{pw}")
	public String selectMemberName(MemberDTO dto);

	
	
}
