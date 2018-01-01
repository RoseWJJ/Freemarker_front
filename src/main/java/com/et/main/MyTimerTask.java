package com.et.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.UUID;

import com.et.model.MyNews;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;

public class MyTimerTask extends TimerTask {
	public static final String HTML_DIR = "E:\\html";
	MyNews my = new MyNews();

	public void run() {
		// 创建模板配置实例
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		// 指定模板文件来源
		try {
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources/"));
			// 设置模板如何检索模型 选择默认
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
			Template template = cfg.getTemplate("index.ftl");
			List<Map> newList = my.queryNews();
			Map root = new HashMap();
			root.put("newList", newList);
			String saveFile = "src/main/webapp/index.html";
			Writer out = new OutputStreamWriter(new FileOutputStream(saveFile));
			template.process(root, out);
			out.flush();
			out.close();
		} catch (Exception e) {

		}


	}
}
