package br.com.projeto.desafio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_warning")
public class Warning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "publication")
	private Date publication;

	@Column(name = "preview")
	private Date preview;

	public Warning() {
	}

	public Warning(Long id, String title, String description, Date publication) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.publication = publication;
	}

	public Warning(String title, String description) {
		this.title = title;
		this.description = description;
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

	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public Date getPreview() {
		return preview;
	}

	public void setPreview(Date preview) {
		this.preview = preview;
	}

}
