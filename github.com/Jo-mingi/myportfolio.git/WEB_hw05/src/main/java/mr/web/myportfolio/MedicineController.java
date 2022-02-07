package mr.web.myportfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mr.web.model.MedicineVO;

@Controller
public class MedicineController {

	@RequestMapping("/search.do")
	public String test(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo, Model model, MedicineVO vo) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=wILAtvV9ZsrSSMvJfpgApYwaywmj6N7juXb1Ka5q0G6wOHVa3IN9fn2sb6ubEAQNuqvQzAoNShdxtqiOCUWT7A%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
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
//        System.out.println(sb.toString());
        
        String jsonData = sb.toString();
//        System.out.println(jsonData);
        
        JsonElement jsonElement = JsonParser.parseString(jsonData);
        
        JsonObject jsonObject = jsonElement.getAsJsonObject();
//        System.out.println(jsonObject);
        
        JsonObject bodyObj = jsonObject.get("body").getAsJsonObject();
//        System.out.println(bodyObj);
        
        String totalCount = bodyObj.get("totalCount").toString();
        int intTotalCount = Integer.parseInt(totalCount);
        String numOfRows = bodyObj.get("numOfRows").toString();
        int intNumOfRows = Integer.parseInt(numOfRows);
        
        JsonArray arrayData = bodyObj.get("items").getAsJsonArray();
        System.out.println(arrayData);
        
        Gson gson = new Gson();
        List<MedicineVO> medicineVOs = new ArrayList<MedicineVO>();
        
        for(int i=0; i < arrayData.size(); i++) {
        	MedicineVO MedicineVO = gson.fromJson(arrayData.get(i), MedicineVO.class);
        	medicineVOs.add(MedicineVO);
        }
        
        int totalPages = (int) Math.ceil(intTotalCount * 1.0 / intNumOfRows);
        
        int blockSize = 10;
        int intPageNo = Integer.parseInt(pageNo);
        
        // 현재 블럭
        int blockNum = (intPageNo - 1) / blockSize;
        
        // 페이지 시작값
        int blockStartPage = (blockSize * blockNum) + 1;
        
        // 페이지 마지막값
        int blockEndPage = blockStartPage + (blockSize - 1);
        
        if(blockEndPage > totalPages) blockEndPage = totalPages;
        
        int prevPage = blockStartPage - 1;
        int nextPage = blockEndPage + 1;
        
        if(nextPage > totalPages) nextPage = totalPages;
        
        // 현재 페이지
        model.addAttribute("pageNo", intPageNo);
        // 이전 페이지
        model.addAttribute("prevPage", prevPage);
        // 페이지 당 결과값
        model.addAttribute("intNumOfRows", intNumOfRows);
        // 다음 페이지
        model.addAttribute("nextPage", nextPage);
        // 현재 블럭 페이지 시작값
        model.addAttribute("blockStartPage", blockStartPage);
        // 현재 블럭 페이지 마지막값
        model.addAttribute("blockEndPage", blockEndPage);
        // 총 게시물 수
        model.addAttribute("totalCount", totalCount);
        // 총 페이지 수
        model.addAttribute("totalPages", totalPages);
        
        model.addAttribute("medicineVOs", medicineVOs);
        
        model.addAttribute("vo", vo);
        
//		System.out.println(dto.getKeyWord());
//		System.out.println(dto.getSearchType());
		
		return "board/test";
	}
	
	
	
	
	
}
