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
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mr.web.mapper.MedicineMapper;
import mr.web.mapper.MemoMapper;
import mr.web.model.MedicineVO;

@Controller
public class MedicineController {
	
	@Autowired
	private MedicineMapper medicineMapper;
	@Autowired
	private MemoMapper memoMapper;

	@RequestMapping("/list.do")
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
	
	@RequestMapping("/medicineInfo.do")
	public String medicineInfo(@RequestParam("num") int num, int viewPage, int totalCnt, String searchType, String keyWord, Model model) {
		
		MedicineVO vo = medicineMapper.read(num);
		
		model.addAttribute("vo", vo);
		model.addAttribute("viewPage", viewPage);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("searchType", searchType);
		
		return "board/medicineDetails";
	}
	
	@RequestMapping("/memoInsert.do")
	public String memoInsert(@RequestParam("id") String id, int num, int viewPage, int totalCnt, String searchType, String keyWord, Model model) {
		
		
		
		model.addAttribute("num", num);
		model.addAttribute("viewPage", viewPage);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("searchType", searchType);
		
//		mnum int primary key auto_increment,
//		id varchar(20) not null,
//		itemName varchar(1500) not null
		
		return "redirect:/board/medicineDetails";
	}
	
	@RequestMapping("/insert")
	public String insert(MedicineVO vo) throws IOException {
//		for(int i=1; i < 2; i++) {
		for(int i=1; i < 46; i++) {
			String PageNo = Integer.toString(i);
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=wILAtvV9ZsrSSMvJfpgApYwaywmj6N7juXb1Ka5q0G6wOHVa3IN9fn2sb6ubEAQNuqvQzAoNShdxtqiOCUWT7A%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(PageNo, "UTF-8")); /*페이지번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
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
	        	// efcyQesitm(효능)
	        	if(medicineVOs.get(j).getEfcyQesitm()!=null && medicineVOs.get(j).getEfcyQesitm()!="") {
	        		if(medicineVOs.get(j).getEfcyQesitm().length()>7) {
	        			vo.setEfcyQesitm(medicineVOs.get(j).getEfcyQesitm().substring(3, medicineVOs.get(j).getEfcyQesitm().length()-5).replaceAll("</p><p>", " "));
	        		}else {
	        			vo.setEfcyQesitm(medicineVOs.get(j).getEfcyQesitm());
	        		}
	        	}else {
	        		vo.setEfcyQesitm(medicineVOs.get(j).getEfcyQesitm());	        		
	        	}
	        	// useMethodQesitm(사용법)
	        	if(medicineVOs.get(j).getUseMethodQesitm()!=null && medicineVOs.get(j).getUseMethodQesitm()!="") {
	        		if(medicineVOs.get(j).getUseMethodQesitm().length()>7) {
	        			vo.setUseMethodQesitm(medicineVOs.get(j).getUseMethodQesitm().substring(3, medicineVOs.get(j).getUseMethodQesitm().length()-5).replaceAll("</p><p>", " "));       			        		
	        		}else {	        			
	        			vo.setUseMethodQesitm(medicineVOs.get(j).getUseMethodQesitm());	        			        		
	        		}
	        	}else {
	        		vo.setUseMethodQesitm(medicineVOs.get(j).getUseMethodQesitm());	        			        		
	        	}
	        	// atpnWarnQesitm(주의사항경고)
	        	if(medicineVOs.get(j).getAtpnWarnQesitm()!=null && medicineVOs.get(j).getAtpnWarnQesitm()!="") {
	        		if(medicineVOs.get(j).getAtpnWarnQesitm().length()>7) {      		        			        		
	        			vo.setAtpnWarnQesitm(medicineVOs.get(j).getAtpnWarnQesitm().substring(3, medicineVOs.get(j).getAtpnWarnQesitm().length()-5).replaceAll("</p><p>", " "));
	        		}else {	        				        			        		
	        			vo.setAtpnWarnQesitm(medicineVOs.get(j).getAtpnWarnQesitm());
	        		}
	        	}else {	        			        		
	        		vo.setAtpnWarnQesitm(medicineVOs.get(j).getAtpnWarnQesitm());
	        	}
	        	// atpnQesitm(주의사항)
	        	if(medicineVOs.get(j).getAtpnQesitm()!=null && medicineVOs.get(j).getAtpnQesitm()!="") {
	        		if(medicineVOs.get(j).getAtpnQesitm().length()>7) {      		        			        		
	        			
	        		}else {	        				        			        		
	        			vo.setAtpnQesitm(medicineVOs.get(j).getAtpnQesitm());
	        		}
	        	}else {	        			        		
	        		vo.setAtpnQesitm(medicineVOs.get(j).getAtpnQesitm());
	        	}
	        	
	        	// intrcQesitm(상호작용)
	        	if(medicineVOs.get(j).getIntrcQesitm()!=null && medicineVOs.get(j).getIntrcQesitm()!="") {
	        		if(medicineVOs.get(j).getIntrcQesitm().length()>7) {
	        			vo.setIntrcQesitm(medicineVOs.get(j).getIntrcQesitm().substring(3, medicineVOs.get(j).getIntrcQesitm().length()-5).replaceAll("</p><p>", " "));
	        		}else {
	        			vo.setIntrcQesitm(medicineVOs.get(j).getIntrcQesitm());
	        		}
	        	}else {
	        		vo.setIntrcQesitm(medicineVOs.get(j).getIntrcQesitm());
	        	}
	        	// seQesitm(부작용)
	        	if(medicineVOs.get(j).getSeQesitm()!=null && medicineVOs.get(j).getSeQesitm()!="") {
	        		if(medicineVOs.get(j).getSeQesitm().length()>7) {
	        			vo.setSeQesitm(medicineVOs.get(j).getSeQesitm().substring(3, medicineVOs.get(j).getSeQesitm().length()-5).replaceAll("</p><p>", " "));
	        		}else {
	        			vo.setSeQesitm(medicineVOs.get(j).getSeQesitm());
	        		}
	        	}else {
	        		vo.setSeQesitm(medicineVOs.get(j).getSeQesitm());
	        	}
	        	// depositMethodQesitm(보관법)
	        	if(medicineVOs.get(j).getDepositMethodQesitm()!=null && medicineVOs.get(j).getDepositMethodQesitm()!="") {
	        		if(medicineVOs.get(j).getDepositMethodQesitm().length()>7) {
	        			vo.setDepositMethodQesitm(medicineVOs.get(j).getDepositMethodQesitm().substring(3, medicineVOs.get(j).getDepositMethodQesitm().length()-5).replaceAll("</p><p>", " "));
	        		}else {
	        			vo.setDepositMethodQesitm(medicineVOs.get(j).getDepositMethodQesitm());
	        		}
	        	}else {
	        		vo.setDepositMethodQesitm(medicineVOs.get(j).getDepositMethodQesitm());
	        	}
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
