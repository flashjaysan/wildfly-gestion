package jaysan.wildfly.gestion.wildflygestion.pub.dto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductLine {
	private String line;
	private String textDescription;
	private String htmlDescription;

	public ProductLine() {		
	}
	
	public ProductLine(String line, String textDescription, String htmlDescription) {
		this.line = line;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	
	public String toString() {
		return "ProductLine[" + 
	Arrays.stream(new String[] {line, textDescription})
		.collect(Collectors.joining(",")) + "]";
	}
}
