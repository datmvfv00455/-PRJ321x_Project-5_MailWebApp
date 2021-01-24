package vn.funix.prj321x.project5.core.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

	private Integer userID;
	private String  userName;
	private String  userPassword;

}
