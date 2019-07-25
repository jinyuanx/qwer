package com.it.servlet;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.it.bean.Users;



public class TestUser {
	public static void main(String[] args) {
		
		/*Users users = new Users(1,"admin",21,67);
		*//**
		 * {"key":"value","key":"value"...}

		 *//*
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("'user_id'");
		buffer.append(":");
		buffer.append("'"+users.getUser_id()+"'");
		buffer.append(",");
		
		buffer.append("'user_name'");
		buffer.append(":");
		buffer.append("'"+users.getUser_name()+"'");
		buffer.append(",");
		buffer.append("'user_age'");
		buffer.append(":");
		buffer.append("'"+users.getUser_age()+"'");
		buffer.append(",");
		buffer.append("'user_weight'");
		buffer.append(":");
		buffer.append("'"+users.getUser_weight()+"'");
		buffer.append("}");
		
		System.out.println(buffer.toString());*/
		/*
           JSONObject jsonObject =  JSONObject.fromObject(users);
		
		
		System.out.println(jsonObject.toString());;*/
		
		
		//[{},{},{},{}]
		Users users1 = new Users(1,"admin",21,67);
		Users users2 = new Users(2,"wwe",21,67);
		Users users3 = new Users(2,"wwe",21,67);
		
		List<Users> listU = new ArrayList<Users>();
		listU.add(users1);
		listU.add(users2);
		listU.add(users3);
		/*listU.add(users1);
		listU.add(users2);
		listU.add(users3);
		StringBuilder  buffer = new StringBuilder();
		buffer.append("[");
		for(int i = 0;i<listU.size();i++){
			
			if(i!=0){
				buffer.append(",");
			}
			buffer.append("{");
			buffer.append("'user_id'");
			buffer.append(":");
			buffer.append("'"+listU.get(i).getUser_id()+"'");
			buffer.append(",");
			
			buffer.append("'user_name'");
			buffer.append(":");
			buffer.append("'"+listU.get(i).getUser_name()+"'");
			buffer.append(",");
			buffer.append("'user_age'");
			buffer.append(":");
			buffer.append("'"+listU.get(i).getUser_age()+"'");
			buffer.append(",");
			buffer.append("'user_weight'");
			buffer.append(":");
			buffer.append("'"+listU.get(i).getUser_weight()+"'");
			buffer.append("}");
			
		}
		buffer.append("]");
		
		System.out.println(buffer.toString());*/
		
		
		JSONArray array = JSONArray.fromObject(listU);
		
		System.out.println(array.toString());
		
	}

}
