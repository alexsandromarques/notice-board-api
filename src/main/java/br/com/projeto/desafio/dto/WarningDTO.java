package br.com.projeto.desafio.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.projeto.desafio.model.Warning;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WarningDTO {

	private Long id;

	private String title;

	private String description;

	private String publication;

	private String preview;

	public Warning convertToObject() throws ParseException {

		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date dataPublication = formatDate.parse(this.publication);

		return new Warning(this.id, this.title, this.description, dataPublication, null);
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

}
