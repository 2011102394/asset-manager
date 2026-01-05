package com.arsc.asset.common.core.domain.result;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TableInfoResult implements Serializable {

	private static final long serialVersionUID = 1L;

	 /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;
    
    /**
     * 分页
     * 
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableInfoResult(List<?> list, long total)
    {
        this.rows = list;
        this.total = total;
    }

}
