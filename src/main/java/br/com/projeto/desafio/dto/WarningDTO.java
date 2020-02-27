package br.com.projeto.desafio.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.projeto.desafio.model.Warning;

public class WarningDTO {

	private Long id;
	
	private String title;
	
	private String description;
	
	private String publication;

	private String preview;

	public WarningDTO() {
	}

	public WarningDTO(Long id, String title, String description, String publication, String preview) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.preview = preview;
	}

	public Warning convertToObject() throws ParseException {
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date data = formatDate.parse(this.publication);

		return new Warning(this.id, this.title, this.description, data);
	}

	public static WarningDTO convertToDTO(Warning warning) {
		DateFormat dateFormatPreview = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormatPublication = new SimpleDateFormat("dd/MM/yyyy");

		String datePreview = "";
		if (warning.getPreview() != null) {
			datePreview = dateFormatPreview.format(warning.getPreview());
		}

		String publication = dateFormatPublication.format(warning.getPublication());

		return new WarningDTO(warning.getId(), warning.getTitle(), warning.getDescription(), publication, datePreview);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

}
