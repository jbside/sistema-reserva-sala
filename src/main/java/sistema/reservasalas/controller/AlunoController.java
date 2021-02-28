package sistema.reservasalas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sistema.reservasalas.beans.Aluno;
import sistema.reservasalas.beans.Espaco;
import sistema.reservasalas.beans.Sala;
import sistema.reservasalas.service.AlunosService;
import sistema.reservasalas.service.EspacoService;
import sistema.reservasalas.service.SalasService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunosService alunoService;

	@Autowired
	private SalasService salaService;

	@Autowired
	private EspacoService espacoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/aluno/cadastro";
	}

	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarTodos());
		return "/aluno/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Aluno aluno, RedirectAttributes attr, @RequestParam("sala") Long id1,
			@RequestParam("sala2") Long id2) {

		if (alunoService.verificaLotacaoSala(id1, id2)) {
			alunoService.getLocacaoAtual(id1, id2);
			alunoService.salvar(aluno);
			attr.addFlashAttribute("success", "Aluno salvo com sucesso!");
		} else {
			attr.addFlashAttribute("fail", "A sala escolhida está com a lotação cheia, favor escolher outra sala");
		}

		return "redirect:/aluno/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorId(id));
		return "aluno/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Aluno aluno, RedirectAttributes attr, @RequestParam("sala") Long id1,
			@RequestParam("sala2") Long id2) {
		if (alunoService.verificaLotacaoSala(id1, id2)) {
			alunoService.alterarcaoLotacaoDaSala(aluno, id1, id2);
			alunoService.editar(aluno);
			attr.addFlashAttribute("success", "Aluno editado com sucesso!");
		} else {
			attr.addFlashAttribute("fail", "A sala escolhida está com a lotação cheia, favor escolher outra sala");
		}
		return "redirect:/aluno/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String exlcuir(@PathVariable("id") Long id, RedirectAttributes attr) {
		alunoService.decrementarLotacaoQuandoUsuarioExcluir(id);
		alunoService.excluir(id);
		attr.addFlashAttribute("success", "Aluno excluido com sucesso");
		return "redirect:/aluno/lista";
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorNome(nome));
		return "/aluno/lista";
	}

	@GetMapping("/buscar/sala")
	public String getPorSala(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorSala(id));
		return "aluno/lista";
	}

	@GetMapping("/buscar/espaco")
	public String getPorEspaco(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorEspaco(id));
		return "aluno/lista";
	}

	@ModelAttribute("sala")
	public List<Sala> listaSalas() {
		return salaService.buscarTodos();
	}

	@ModelAttribute("espaco")
	public List<Espaco> listaEspacos() {
		return espacoService.buscarTodos();
	}

}
