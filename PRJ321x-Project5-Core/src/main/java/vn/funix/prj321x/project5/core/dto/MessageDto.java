package vn.funix.prj321x.project5.core.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto implements Serializable {

	private String emailFrom;
	private String emailTo;
	private String emailCC;
	private String emailSubject;
	private String emailMessage;
	private Date   date;

	public String getSimpleDate() {
		return new SimpleDateFormat("dd:mm:yyy HH:mm").format(this.date);
	}

}
