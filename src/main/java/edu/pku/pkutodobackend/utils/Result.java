package edu.pku.pkutodobackend.utils;

import cn.hutool.json.JSONObject;
import edu.pku.pkutodobackend.enums.ExceptionEnum;
import edu.pku.pkutodobackend.vo.DataVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liudawei
 * @Description:封装成VO的工具类
 * @DateTime:2024/10/6 20:34
 **/
public class Result {


    /**
     * @Description: 成功信息：data：[{key ,o}]
     * @param key
     * @param o
     * @return
     */
    public static DataVO successToArray(String key, Object o) {
        try {
            List<Object> d = new ArrayList<>();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(key, o);
            d.add(jsonObject);
            return generateDataVO(d, ExceptionEnum.SUCCESS);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @Description: 成功信息 data：NULL
     * @return
     */

    public static DataVO success(){
        try{
            return generateDataVO(null, ExceptionEnum.SUCCESS);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * @Description: 错误信息 data：NULL
     * @param exceptionEnum
     * @return
     */
    public static DataVO error(ExceptionEnum exceptionEnum) {
        try{
            return generateDataVO(null, exceptionEnum);
        }catch(Exception e){
            throw e;
        }
    }

    public static DataVO generateDataVO(Object object, ExceptionEnum exceptionsEnum){
        DataVO dataVO=new DataVO();
        dataVO.setCode(exceptionsEnum.getCode());
        dataVO.setMsg(exceptionsEnum.getMsg());
        if(object==null)
            dataVO.setData(new ArrayList<>());
        else
            dataVO.setData(object);
        return dataVO;
    }
}
