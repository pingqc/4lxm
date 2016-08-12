package com.pingqc.exls.forlxm.domain.wechat;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by pingqc on 16/6/14.
 */
@XStreamAlias("xml")
public class WeChatMessage {

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    /**
     * 文本消息
     */
    @XStreamAlias("Content")
    private String content;
//    /**
//     * 图片消息
//     */
//    @XStreamAlias("PicUrl")
//    private String picUrl;
//    @XStreamAlias("MediaId")
//    private String mediaId;
//    /**
//     * 语音消息
//     */
//    @XStreamAlias("Format")
//    private String format;
//    @XStreamAlias("Recognition")
//    private String recognition;


    @XStreamAlias("MsgId")
    private long msgId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

}
