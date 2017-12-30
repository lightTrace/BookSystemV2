package cn.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 搜索控制
 * 
 * @author hk
 * 
 *         2013-1-16 下午8:26:09
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search/home");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ModelAndView search(@RequestParam("id") String query) {
		Map<String,Object> map= searchService.searchsNews(query);
		List peopleList = new ArrayList();
		peopleList.add(map);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search/search");
		mv.addObject("peopleList", peopleList);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public ModelAndView createInitialData() {
		searchService.builderSearchIndex();
		ModelAndView mv = new ModelAndView("forward:/book/list");
		mv.addObject("message", "人员索引已创建成功!");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search/about");
		return mv;
	}
}
