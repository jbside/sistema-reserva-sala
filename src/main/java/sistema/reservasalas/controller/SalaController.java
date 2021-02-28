package sistema.reservasalas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sistema.reservasalas.beans.Sala;
import sistema.reservasalas.service.SalasService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalasService salaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Sala sala){
		return "sala/cadastro";
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("sala", salaService.buscarTodos());
		return "sala/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Sala sala, RedirectAttributes attr) {
		salaService.salvar(sala);
		attr.addFlashAttribute("success","Sala cadastrada com sucesso");
		return "redirect:/sala/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("sala", salaService.buscarPorId(id));
		return "sala/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Sala sala, RedirectAttributes attr) {
		salaService.editar(sala);
		attr.addFlashAttribute("success","Sala editada com sucesso");
		return "redirect:/sala/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		salaService.excluir(id);
		attr.addFlashAttribute("success","Sala exluida com sucesso!");
		return "redirect:/sala/lista";
	}

}
