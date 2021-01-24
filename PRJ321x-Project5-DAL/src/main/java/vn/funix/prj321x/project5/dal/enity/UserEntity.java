package vn.funix.prj321x.project5.dal.enity;

import javax.persistence.Entity;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

}
