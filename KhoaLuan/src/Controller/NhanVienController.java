package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import enity.NhanVien;
import enity.Role;

public class NhanVienController {
	
	static String GET_ALL_NHAN_VIEN="http://localhost:5001/nhanvien/getall";
	static String PUT_NHAN_VIEN="http://localhost:5001/nhanvien/update";
	static String POST_NHAN_VIEN="http://localhost:5001/nhanvien/insert";
	static String GET_ONE_ROLE="http://localhost:5001/role/getone";
	
	public  List<NhanVien>  GetAllNhanVien() throws IOException {
		List<NhanVien>getall=new ArrayList<>();
	    URL urlForGetRequest = new URL(GET_ALL_NHAN_VIEN);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET"); // set userId its a sample here
	    conection.setRequestProperty("Content-Type", "application/json");
	    int responseCode = conection.getResponseCode();

	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        String response = new String();
	        while ((readLine = in .readLine()) != null) {
	            response+=(readLine);
	        } in .close();
	        if(responseCode==200)
	        {
	        	Gson gson = new GsonBuilder()
	        		    .setDateFormat("yyyy-MM-dd")
	        		    .create();
		        JsonParser parser = new JsonParser();
		        JsonArray object = (JsonArray) parser.parse(response);// response will be the json String
		        NhanVien[] nhanVienList = gson.fromJson(object, NhanVien[].class);
		        	
		        for(int i=0;i<nhanVienList.length;i++)
		        	getall.add(nhanVienList[i]);
	        }
	        else
	        {
	        	return null;
	        }
	        
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
		return getall;

	}
	public  int POSTNhanVien(NhanVien nv) throws IOException {

		Gson gson = new GsonBuilder()
    		    .setDateFormat("yyyy-MM-dd")
    		    .create();
		String POST_PARAMS = gson.toJson(nv);
	    System.out.println(POST_PARAMS);
	    URL obj = new URL(POST_NHAN_VIEN);
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");


	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();


	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());

	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();

	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	    return responseCode;
	}
	public  int PUTNhanVien(NhanVien nv) throws IOException {

		Gson gson = new GsonBuilder()
    		    .setDateFormat("yyyy-MM-dd")
    		    .create();
		String PUT_PARAMS = gson.toJson(nv);
	    System.out.println(PUT_PARAMS);
	    URL obj = new URL(PUT_NHAN_VIEN+"/"+nv.getId());
	    HttpURLConnection putConnection = (HttpURLConnection) obj.openConnection();
	    putConnection.setRequestMethod("PUT");
	    putConnection.setRequestProperty("Content-Type", "application/json");


	    putConnection.setDoOutput(true);
	    OutputStream os = putConnection.getOutputStream();
	    os.write(PUT_PARAMS.getBytes());
	    os.flush();
	    os.close();


	    int responseCode = putConnection.getResponseCode();
	    String message=putConnection.getResponseMessage();
	    

	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            putConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();

	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("PUT NOT WORKED");
	    }
	    return responseCode;
	}
	public Date doingaytuchuoi(String s) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
        try {
             date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}
	public String doichuoitungay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = formatter.format(date);
		return dateFormat;
	}
	public Role GetOneRole(Long id) throws IOException {
		Role role=new Role();
		URL urlForGetRequest = new URL(GET_ONE_ROLE+"/"+id);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET"); // set userId its a sample here
		conection.setRequestProperty("Content-Type", "application/json");
		int responseCode = conection.getResponseCode();


		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			String response = new String();
			while ((readLine = in .readLine()) != null) {
				response+=(readLine);
			} in .close();
			
			Gson gson = new Gson();
			role = gson.fromJson(response, Role.class);

			
		} else {
			System.out.println("GET NOT WORKED");
		}

		return role;
	}
	public NhanVien NhanVienDangSuDung(String username) {
		NhanVien nv= new NhanVien();
		List<NhanVien> list= new ArrayList<NhanVien>();
		try {
			list=GetAllNhanVien();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<1;i++)
		{
			if(username.equals(list.get(i).getTaiKhoan().getUsername()))
				nv=list.get(i);
		}
		return nv;
	}
}
