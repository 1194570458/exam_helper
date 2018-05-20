package com.kason.app.handle;

import com.kason.app.entity.Result;
import com.kason.app.exception.AppException;
import com.kason.app.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger =LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof AppException){
            AppException appException= (AppException) e;
            return ResultUtil.error(appException.getCode(),appException.getMessage());
        }
        else {
            logger.error("[ 系统错误 ] ： {} " ,e.getMessage().toString());
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
