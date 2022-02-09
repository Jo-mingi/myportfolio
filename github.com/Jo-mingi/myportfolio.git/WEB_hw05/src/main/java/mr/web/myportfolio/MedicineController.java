package mr.web.myportfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mr.web.mapper.MedicineMapper;
import mr.web.model.MedicineVO;

@Controller
public class MedicineController {
	
	@Autowired
	private MedicineMapper medicineMapper;

	@RequestMapping("/search.do")
	public String test(Model model, MedicineVO vo) {
		
		// 전체 게시물 수
		int totalCnt = medicineMapper.selectTotalCnt(vo);
		
		// 한 페이지 당 게시물 수
		int cntPerPages = vo.getCntPerPages();
		
		// 사용자가 클릭한 페이지
		int viewPage = vo.getViewPage();
		
		// 전체 페이지 수
		int totalPages = (int)Math.ceil((double)totalCnt/cntPerPages);
		
		if(viewPage > totalPages || viewPage < 1) {
			viewPage = 1;
		}
		
		// 시작 페이지
		int startIndex = (viewPage - 1) * cntPerPages;
		
		vo.setStartIndex(startIndex);
		
		int blockSize = vo.getBlockSize();
		
		int blockNum = (viewPage - 1) / blockSize;
		
		int blockStart = (blockSize * blockNum) + 1;
		
		int blockEnd = blockStart + (blockSize - 1);
		
		if(blockEnd > totalPages) {
			blockEnd = totalPages;
		}
		
		int prevPage = blockStart - 1;
		int nextPage = blockEnd + 1;
		if(nextPage > totalPages) {
			nextPage = totalPages;
		}
		
		model.addAttribute("blockStart", blockStart);
		model.addAttribute("blockEnd", blockEnd);
		
		model.addAttribute("viewPage", viewPage);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalCnt", totalCnt);
		
		List<MedicineVO> list = medicineMapper.getList(vo);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
        
		return "board/search";
	}
	
	@RequestMapping("/insert")
	public String insert(MedicineVO vo) throws IOException {
		for(int i=1; i < 46; i++) {
			String PageNo = Integer.toString(i);
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=wILAtvV9ZsrSSMvJfpgApYwaywmj6N7juXb1Ka5q0G6wOHVa3IN9fn2sb6ubEAQNuqvQzAoNShdxtqiOCUWT7A%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(PageNo, "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
	        
	        urlBuilder.append("&" + URLEncoder.encode("entpName","UTF-8")); /*업체명*/
	        urlBuilder.append("&" + URLEncoder.encode("itemName","UTF-8")); /*제품명*/
	        urlBuilder.append("&" + URLEncoder.encode("itemSeq","UTF-8")); /*품목기준코드*/
	        urlBuilder.append("&" + URLEncoder.encode("efcyQesitm","UTF-8")); /*이 약의 효능은 무엇입니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("useMethodQesitm","UTF-8")); /*이 약은 어떻게 사용합니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("atpnWarnQesitm","UTF-8")); /*이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("atpnQesitm","UTF-8")); /*이 약의 사용상 주의사항은 무엇입니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("intrcQesitm","UTF-8")); /*이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("seQesitm","UTF-8")); /*이 약은 어떤 이상반응이 나타날 수 있습니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("depositMethodQesitm","UTF-8")); /*이 약은 어떻게 보관해야 합니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("openDe","UTF-8")); /*공개일자*/
	        urlBuilder.append("&" + URLEncoder.encode("updateDe","UTF-8")); /*수정일자*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
//	        System.out.println(sb.toString());
	        
	        String jsonData = sb.toString();
//	        System.out.println(jsonData);
	        
	        JsonElement jsonElement = JsonParser.parseString(jsonData);
	        
	        JsonObject jsonObject = jsonElement.getAsJsonObject();
//	        System.out.println(jsonObject);
	        
	        JsonObject bodyObj = jsonObject.get("body").getAsJsonObject();
//	        System.out.println(bodyObj);
	        
	        JsonArray arrayData = bodyObj.get("items").getAsJsonArray();
//	        System.out.println(arrayData);
	        
	        Gson gson = new Gson();
	        List<MedicineVO> medicineVOs = new ArrayList<MedicineVO>();
	        
	        for(int j=0; j < arrayData.size(); j++) {
	        	MedicineVO MedicineVO = gson.fromJson(arrayData.get(j), MedicineVO.class);
	        	medicineVOs.add(MedicineVO);
	        }
	        
	        for(int j=0; j < arrayData.size(); j++) {
	        	vo.setEntpName(medicineVOs.get(j).getEntpName());
	        	vo.setItemName(medicineVOs.get(j).getItemName());
	        	vo.setItemSeq(medicineVOs.get(j).getItemSeq());
	        	vo.setEfcyQesitm(medicineVOs.get(j).getEfcyQesitm());
	        	vo.setUseMethodQesitm(medicineVOs.get(j).getUseMethodQesitm());
	        	vo.setAtpnWarnQesitm(medicineVOs.get(j).getAtpnWarnQesitm());
	        	vo.setAtpnQesitm(medicineVOs.get(j).getAtpnQesitm());
	        	vo.setIntrcQesitm(medicineVOs.get(j).getIntrcQesitm());
	        	vo.setSeQesitm(medicineVOs.get(j).getSeQesitm());
	        	vo.setDepositMethodQesitm(medicineVOs.get(j).getDepositMethodQesitm());
	        	vo.setOpenDe(medicineVOs.get(j).getOpenDe());
	        	vo.setUpdateDe(medicineVOs.get(j).getUpdateDe());
	        	vo.setItemImage(medicineVOs.get(j).getItemImage());
	        	
	        	medicineMapper.register(vo);
	        	vo = new MedicineVO();
	        	
	        }
	        
		}
        
        
        return "board/search";
	}
	
	
	
}
