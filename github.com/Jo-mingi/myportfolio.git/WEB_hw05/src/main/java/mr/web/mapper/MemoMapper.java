package mr.web.mapper;

import mr.web.model.MemoVO;


public interface MemoMapper {

//	public MemoVO read(int num); // 글보기
	public int memoRegister(MemoVO mvo); //등록
//	public MemoVO view(int num, String mode); // 게시글 보기

}
