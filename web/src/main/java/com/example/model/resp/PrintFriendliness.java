package com.example.model.resp;

import com.alibaba.druid.support.json.JSONUtils;

import java.io.Serializable;

/**
 * 自身内容能以可读方式输出
 *
 * @author PD
 */
public abstract class PrintFriendliness implements Serializable {

    private static final long serialVersionUID = -235822080790001901L;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":"
                + JSONUtils.toJSONString(this);
    }

}
