package br.com.projeto.desafio.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.desafio.dto.WarningDTO;
import br.com.projeto.desafio.exception.WarningNotFoundException;
import br.com.projeto.desafio.model.Warning;
import br.com.projeto.desafio.service.WarningService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class WarningController {

	@Autowired
	private WarningService warningService;

	@GetMapping("/list")
	public List<WarningDTO> findAll() {
		List<Warning> warnings = this.warningService.findAll();
		return warnings.stream().map(e -> WarningDTO.convertToDTO(e)).collect(Collectors.toList());
	}

	@GetMapping("/warning/{id}")
	public ResponseEntity<WarningDTO> getWarningById(@PathVariable(value = "id") Long idWarning)
			throws WarningNotFoundException, ParseException {
		Warning warning = this.warningService.findById(idWarning);
		return new ResponseEntity<>(WarningDTO.convertToDTO(warning), HttpStatus.OK);
	}

	@GetMapping("/details/{id}")
	public ResponseEntity<WarningDTO> details(@PathVariable(value = "id") Long idWarning)
			throws WarningNotFoundException, ParseException {
		Warning warning = this.warningService.details(idWarning);
		return new ResponseEntity<>(WarningDTO.convertToDTO(warning), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<WarningDTO> save(@RequestBody WarningDTO warningDTO) throws ParseException {
		Warning warning = this.warningService.save(warningDTO.convertToObject());
		return new ResponseEntity<>(WarningDTO.convertToDTO(warning), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<WarningDTO> update(@Valid @RequestBody WarningDTO warningDTO)
			throws WarningNotFoundException, ParseException {
		Warning warning = this.warningService.update(warningDTO.convertToObject());
		return new ResponseEntity<>(WarningDTO.convertToDTO(warning), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long idWarning) throws WarningNotFoundException {
		this.warningService.delete(idWarning);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
