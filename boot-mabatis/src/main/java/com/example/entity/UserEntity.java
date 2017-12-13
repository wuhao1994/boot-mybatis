package com.example.entity;


import java.io.Serializable;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private String userSex;
	private String nickName;
	
}
