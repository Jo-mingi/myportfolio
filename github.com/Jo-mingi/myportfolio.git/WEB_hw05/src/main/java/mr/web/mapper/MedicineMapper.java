package mr.web.mapper;

import java.util.List;

import mr.web.model.MedicineVO;

// persistence Layer(Tier)

public interface MedicineMapper {

	public List<MedicineVO> getList(MedicineVO vo); // 게시판 리스트 가져오기
	public MedicineVO read(int num); // 글보기
	public int register(MedicineVO vo); //등록
	public MedicineVO view(int num, String mode); // 게시글 보기
//
	public int selectTotalCnt(MedicineVO vo); // 전체 게시물 개수
	
}
