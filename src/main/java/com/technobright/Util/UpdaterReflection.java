package com.technobright.Util;

import java.lang.reflect.Field;

public class UpdaterReflection {

	public static Object getUpdatedObj(Object original, Object updateable){
		Field [] fields=updateable.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
			fields[i].setAccessible(true);
			try {
				System.out.println(fields[i].get(updateable));
				if(fields[i].get(updateable)==null){
					fields[i].set(updateable, fields[i].get(original));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		}
		
		for (int i = 0; i < fields.length; i++) {
			try {
				System.out.println(fields[i].get(updateable));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateable;
	}
}
