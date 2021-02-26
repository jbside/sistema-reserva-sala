package sistema.reservasalas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sistema.reservasalas.beans.Espaco;
import sistema.reservasalas.service.EspacoService;

@Controller
@RequestMapping("/espaco")
public class EspacoController {
	
	@Autowired
	private EspacoService espacoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar (Espaco espaco) {
		return "espaco/cadastro";
	}

	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("espaco", espacoService.buscarTodos());
		return "espaco/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Espaco espaco, RedirectAttributes attr) {
		espacoService.salvar(espaco);
		attr.addFlashAttribute("success", "Espaco cadastrado com sucesso!");
		return "redirect:/espaco/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("espaco",espacoService.buscarPorId(id));
		return "espaco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Espaco espaco, RedirectAttributes attr) {
		espacoService.editar(espaco);
		attr.addFlashAttribute("success","Espaco atualizado com sucessos");
		return "redirect:/espaco/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		espacoService.excluir(id);
		attr.addFlashAttribute("success", "Espaco excluido com sucesso");
		return "redirect:/espaco/lista";
	}
}
