package bean;

import java.io.Reader;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

@Controller
public class TestBean {

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	public TestBean() throws Exception {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	@RequestMapping("/test.do")
	public ModelAndView testForm(memberDTO memdto) throws Exception {
		
		ArrayList<memberDTO> memList = new ArrayList<memberDTO>();
		
		memList = (ArrayList<memberDTO>) sqlMapper.queryForList("getMemberTB");
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memList", memList);
		mv.addObject(memdto);
		mv.setViewName("/test/test.jsp");
		
		return mv;
	}
}
