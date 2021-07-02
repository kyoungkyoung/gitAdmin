package chart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import chart.bean.EtcDTO;
import chart.bean.MemChartDTO;
import chart.service.ChartService;
import community.bean.CommunityDTO;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	private ChartService chartService;
	
	@RequestMapping(value = "/postGraphDetail", method = RequestMethod.GET)
	public String postGraphDetail(@RequestParam String seq, Model model) { 
		
		CommunityDTO communityDTO = chartService.getCommunityDTO(Integer.parseInt(seq));
		
		model.addAttribute("communityDTO", communityDTO);
		model.addAttribute("seq", seq);
		model.addAttribute("display", "/chart/postGraphDetail.jsp");
		return "/section/login";
	}// postGraphDetail()
	

	@RequestMapping(value = "/getEtc", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getEtc(@RequestParam String seq) {
		System.out.println("seq="+seq);
		
		List<EtcDTO> list = chartService.getEtc(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDate(@RequestParam String seq, @RequestParam String date) {
		System.out.println("찍히나"+seq);
		System.out.println("찍히나"+date);
		
		List<EtcDTO> list = chartService.getDate(seq, date);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/graph", method = RequestMethod.GET)
	public String graph(Model model) { 
		model.addAttribute("display", "/chart/graph.jsp");
		return "/section/login";
	}
	
	@RequestMapping(value = "/hitInfo", method = RequestMethod.GET)
	public String hitInfo(Model model) { 
		model.addAttribute("display", "/chart/hitInfo.jsp");
		return "/section/login";
	}// memberView()
	
	@RequestMapping(value="/getMemData", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemData(@RequestParam String date) {
		System.out.println(date);
		
		List<MemChartDTO> list = chartService.getMemData(date);
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/getTestHit", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getTestHit() {
		List<CommunityDTO> list = chartService.getTestHit();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/getloveHit", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getloveHit() {
		List<CommunityDTO> list = chartService.getloveHit();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
}
