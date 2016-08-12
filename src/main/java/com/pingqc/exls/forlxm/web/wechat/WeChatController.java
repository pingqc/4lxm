package com.pingqc.exls.forlxm.web.wechat;

import com.pingqc.exls.forlxm.domain.wechat.WeChatMessage;
import com.pingqc.exls.forlxm.util.WeChatUtil;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pingqc on 16/6/12.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatController.class);

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String index(String signature, String timestamp, String nonce, String echostr) {

        LOGGER.debug("token check: {}, {}, {}, {}", signature, timestamp, nonce, echostr);

        if (WeChatUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String postHandler(@RequestBody String xml) {
        LOGGER.debug("receive text message: {}", xml);
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(WeChatMessage.class);

        Object obj = xStream.fromXML(xml);
        WeChatMessage message = (WeChatMessage) obj;
        if ("text".equals(message.getMsgType())) {
            return xStream.toXML(message);
        } else {
            LOGGER.warn("message type {} is not supported", message.getMsgType());
        }
        return "";
    }
}
