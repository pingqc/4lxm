package com.pingqc.exls.forlxm.web.commom;

import com.pingqc.exls.forlxm.domain.AjaxResp;
import com.pingqc.exls.forlxm.exception.ExlsException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by darcy on 2016/8/12.
 */
@ControllerAdvice(basePackages = "com.pingqc.exls.forlxm.web")
public class CommonAdviceController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

	@ExceptionHandler(Exception.class)
	public AjaxResp exlsExceptionHandler(Exception e) {
        AjaxResp ajaxResp = new AjaxResp();
        ajaxResp.setMsg(e.getMessage());
        ajaxResp.setResult(AjaxResp.FAILED);
        if (e instanceof ExlsException) {
            ajaxResp.setCode(((ExlsException) e).getCode());
        }
        return ajaxResp;
    }

}
