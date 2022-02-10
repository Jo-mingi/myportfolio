package mr.web.mapper;

import java.util.List;

import mr.web.model.MemoVO;


public interface MemoMapper {

	public List<MemoVO> getList(MemoVO vo); // 게시판 리스트 가져오기
	public MemoVO read(int num); // 글보기
	public void memoRegister(MemoVO mvo); //등록
	public MemoVO view(int num, String mode); // 게시글 보기

}
