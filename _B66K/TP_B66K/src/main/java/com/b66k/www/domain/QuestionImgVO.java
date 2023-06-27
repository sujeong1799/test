package com.b66k.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuestionImgVO {

	private  String uuid;
	private  String save_path;
	private  String file_name;
	private  int file_size;
	
}
