package com.NV.springboot.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String path;
	private String errorCode;

}
