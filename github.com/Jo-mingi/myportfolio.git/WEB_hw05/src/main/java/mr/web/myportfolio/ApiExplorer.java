package mr.web.myportfolio;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.*;

import mr.web.model.MedicineVO;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
	
    public static void main(String[] args, MedicineVO vo) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=wILAtvV9ZsrSSMvJfpgApYwaywmj6N7juXb1Ka5q0G6wOHVa3IN9fn2sb6ubEAQNuqvQzAoNShdxtqiOCUWT7A%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("4430", "UTF-8")); /*한 페이지 결과 수*/
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
        System.out.println(bodyObj);
        
        JsonArray arrayData = bodyObj.get("items").getAsJsonArray();
        System.out.println(arrayData);
        
        Gson gson = new Gson();
        List<MedicineVO> medicineVOs = new ArrayList<MedicineVO>();
        
        for(int i=0; i < arrayData.size(); i++) {
        	MedicineVO MedicineVO = gson.fromJson(arrayData.get(i), MedicineVO.class);
        	medicineVOs.add(MedicineVO);
        }

        for(int i=0; i < arrayData.size(); i++) {
        	System.out.println(medicineVOs.get(1).getEntpName());
        	vo.setEntpName(medicineVOs.get(i).getEntpName());
        	vo.setItemName(medicineVOs.get(i).getItemName());
        	vo.setItemSeq(medicineVOs.get(i).getItemSeq());
        	vo.setEfcyQesitm(medicineVOs.get(i).getEfcyQesitm());
        	vo.setUseMethodQesitm(medicineVOs.get(i).getUseMethodQesitm());
        	vo.setAtpnWarnQesitm(medicineVOs.get(i).getAtpnWarnQesitm());
        	vo.setAtpnQesitm(medicineVOs.get(i).getAtpnQesitm());
        	vo.setIntrcQesitm(medicineVOs.get(i).getIntrcQesitm());
        	vo.setSeQesitm(medicineVOs.get(i).getSeQesitm());
        	vo.setDepositMethodQesitm(medicineVOs.get(i).getDepositMethodQesitm());
        	vo.setOpenDe(medicineVOs.get(i).getOpenDe());
        	vo.setUpdateDe(medicineVOs.get(i).getUpdateDe());
        	vo.setItemImage(medicineVOs.get(i).getItemImage());

        }
        
		
		
	}
}
