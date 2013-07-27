package com.technobright.appSettings;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.technobright.dao.DAOInterface;
import com.technobright.entities.Page;
import com.technobright.entities.UserPreference;

public class SASISCtxListenerImpl implements ServletContextListener{

	private DAOInterface dao;
	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public void contextDestroyed(ServletContextEvent ctxEvt) {
			
		System.out.println("the context has destroyed............");
	}

	public void contextInitialized(ServletContextEvent ctxEvt) {
		ServletContext servCtx=ctxEvt.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ctxEvt.getServletContext());
        dao =(DAOInterface) applicationContext.getBean("daoDerbyImpl");
        Map<Integer, UserPreference> prefMap=new TreeMap<Integer, UserPreference>();
        for(UserPreference usrPref:dao.getAllUsrPrefs()){
        	prefMap.put(usrPref.getUsrPrefId(), usrPref);
        }
        servCtx.setAttribute("prefMap", prefMap);
        
        Map<Integer, Page> pageMap=new TreeMap<Integer, Page>();
        for(Page page:dao.getAllPages()){
        	pageMap.put(page.getPageId(), page);
        }
        servCtx.setAttribute("pageMap", pageMap);
        System.out.println("the context has been initialized............");
	}

}
