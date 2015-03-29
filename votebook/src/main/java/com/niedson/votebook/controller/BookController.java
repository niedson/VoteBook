package com.niedson.votebook.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	protected static Logger logger = Logger.getLogger("LivroController");
	 
//	private LivroService livroService;
	
//	@Autowired 
//	public LivroController(LivroService livroService) {
//		this.livroService = livroService;
//	}
	
	@RequestMapping("/")
	public ModelAndView voteNoLivro(){
		
		logger.info("entering context()");
		
		System.out.println("asds");
		
//		this.livroService = new LivroService();
//		
//		Livro livro = new Livro("Livro 1", "autor 1", "sinopse 1", "Idioma 1", 1999);
		
//		livroService.addLivro(livro);
//		
//		List<Livro> listaLivro = livroService.getAllLivros();
//		
//		System.out.println("asdasd");
//		
		
		return new ModelAndView("chooseBook", "mensagem", null);
	}

}
