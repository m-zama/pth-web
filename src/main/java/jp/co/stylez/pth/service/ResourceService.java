package jp.co.stylez.pth.service;

import java.io.IOException;

import jp.co.stylez.pth.web.bean.JsonBean;

public interface ResourceService {

	JsonBean accessJsonResource()throws IOException;
}
