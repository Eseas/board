package com.fastcampus.ch4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/read")
	public String read(Integer bno, Integer page, Integer pageSize, RedirectAttributes rattr, Model m, HttpSession session) throws Exception{
		try {
			BoardDto boardDto = boardService.read(bno);
			m.addAttribute(boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/board/list";
		}
		return "board";
	}
	
	@PostMapping("/remove")
	public String delete(BoardDto boardDto, Integer page, Integer pageSize, Model m, HttpSession session) throws Exception {
		try {
			boardService.remove(boardDto.getBno(), boardDto.getWriter());
			m.addAttribute("msg", "DEL_OK");
		} catch(Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "DEL_ERR");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model m) {
		m.addAttribute("mode", "new");
		return "board";
	}
	
	@PostMapping("/write")
	public String write(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) throws Exception {
		String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);
        
        try {
            if (boardService.write(boardDto) != 1)
                throw new Exception("Write failed.");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }
	}
	
	@PostMapping("/modify")
	public String modify(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) throws Exception {
		try {
			if(boardService.modify(boardDto) != 1) {
				throw new Exception("Modify failed.");
			}
			System.out.println(boardDto.toString());
			rattr.addFlashAttribute("msg", "MOD_OK");
			return "redirect:/board/list";
		} catch(Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "MOD_ERR");
		}
		return "board";
	}
	
	@GetMapping("/list")
	public String getList(Model m, HttpServletRequest request) {
		if(!loginCheck(request)) {
			return "login"; 
		}
		try {
			List<BoardDto> boardDto = boardService.getList();
			m.addAttribute("list", boardDto);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }
		return "boardlist";
	}
	
	public boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		return session.getAttribute("id") != null;
	}
}
