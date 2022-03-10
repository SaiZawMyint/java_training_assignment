package ojt.simpletask.app.web.form.excelproduct;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> ExcelProduct Class</h2>
 * <p>
 * Process for Displaying ExcelProduct
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcelProduct {
	/**
	 * <h2> filename</h2>
	 * <p>
	 * filename
	 * </p>
	 */
	@NotNull
	@Size(min=1,max=10)
	private String filename;
	/**
	 * <h2> description</h2>
	 * <p>
	 * description
	 * </p>
	 */
	private String description;
	/**
	 * <h2> excelfiles</h2>
	 * <p>
	 * excelfiles
	 * </p>
	 */
	private List<MultipartFile> excelfiles;
}
