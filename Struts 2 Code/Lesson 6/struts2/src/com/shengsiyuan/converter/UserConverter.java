package com.shengsiyuan.converter;

import java.util.Map;
import java.util.StringTokenizer;

import ognl.DefaultTypeConverter;

import com.shengsiyuan.bean.User;

public class UserConverter extends DefaultTypeConverter
{
	@Override
	public Object convertValue(Map context, Object value, Class toType)
	{
		if(User.class == toType)  //��ҳ�����̨����ת��
		{
			String[] str = (String[])value;
			
			String firstValue = str[0];
			
			StringTokenizer st = new StringTokenizer(firstValue, ";");
			
			String username = st.nextToken();
			String password = st.nextToken();
			
			User user = new User();
			
			user.setUsername(username);
			user.setPassword(password);
			
			return user;		
		}
		else if(String.class == toType) //�Ӻ�̨������ҳ��ת��
		{
			User user = (User)value;
			
			String username = user.getUsername();
			String password = user.getPassword();
			
			String userInfo = "username: " + username + ", password: " + password;
			
			return userInfo;
		}
		
		return null;
	}
}
