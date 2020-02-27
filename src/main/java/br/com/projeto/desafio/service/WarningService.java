package br.com.projeto.desafio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.desafio.exception.NotFoundException;
import br.com.projeto.desafio.model.Warning;
import br.com.projeto.desafio.repository.WarningRepository;

@Service
public class WarningService {

	private WarningRepository repository;

	@Autowired
	public WarningService(WarningRepository repository) {
		this.repository = repository;
	}
	
	public Warning details(Long id) throws NotFoundException {
		Warning warning = this.findById(id);
		warning.setPreview(new Date());
		return warning;
	}
	
	public List<Warning> findAll() {
		return this.repository.findAll();
	}

	public Warning findById(Long id) throws NotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Warning not found for this id :: " + id));
	}

	public Warning update(Warning warning) throws NotFoundException {
		Warning warningSearch = this.findById(warning.getId());
		warningSearch.setTitle(warning.getTitle());
		warningSearch.setDescription(warning.getDescription());
		return this.repository.save(warningSearch);
	}

	public void delete(Long id) throws NotFoundException {
		Warning warning = this.findById(id);
		this.repository.delete(warning);
	}
	
	public Warning save(Warning warning) {
		return this.repository.save(warning);
	}
}
