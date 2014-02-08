package com.iflytek.train.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-27 10:20 PM
 * @since JDK 1.5
 */
@Controller
public class UploadController {

	/** 前缀路径 */
	//	private static final String LOCATION_PREFIX = "D://iflytek//";
	private static final String LOCATION_PREFIX = "/iflytek/";

	@RequestMapping(value = "/formajax", method = RequestMethod.GET)
	public void href_ajax() {

	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void post_upload(@RequestParam(value = "file1") MultipartFile file1, String username) {


		try {
			System.out.println("username:" + username);
			if (!file1.isEmpty()) {
				FileOutputStream fs = new FileOutputStream(LOCATION_PREFIX + File.separator + file1.getOriginalFilename());
				IOUtils.copy(file1.getInputStream(), fs);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
