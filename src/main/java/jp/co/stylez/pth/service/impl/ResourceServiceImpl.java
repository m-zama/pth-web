package jp.co.stylez.pth.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.stylez.pth.service.ResourceService;
import jp.co.stylez.pth.web.bean.JsonBean;

@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	ObjectMapper objectMapper;
	
	@Value("${resource.greeting:http://workhard.stylez.co.jp.s3-website-ap-northeast-1.amazonaws.com/greeting.json}")
	Resource greetingResource;
	
	public JsonBean accessJsonResource() throws IOException{
		try(InputStream in = greetingResource.getInputStream()){
			 String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			 System.out.println(content);
			 JsonBean jsonBean = objectMapper.readValue(content, JsonBean.class);
			 return jsonBean;
		}
	}
}
